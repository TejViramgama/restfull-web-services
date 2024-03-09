package com.rest.webservices.restfulwebservice.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rest.webservices.restfulwebservice.Model.Meal;
import com.rest.webservices.restfulwebservice.Model.Meetup;
import com.rest.webservices.restfulwebservice.Model.Post;
import com.rest.webservices.restfulwebservice.Model.User;
import com.rest.webservices.restfulwebservice.Repo.MeetupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MeetupController {

    MeetupRepo meetupRepo;

    @Autowired
    public MeetupController(MeetupRepo meetupRepo) {
        this.meetupRepo = meetupRepo;
    }

    @PostMapping("/meetup")
    public ResponseEntity<Meetup> addMeal(@RequestBody Meetup meetup) {

        Meetup meetup1 = meetupRepo.save(meetup);
        return ResponseEntity.ok(meetup1);
    }

    @GetMapping("/meetup")
    public List<Meetup> GetAllMeetUps() {
        List<Meetup> meetups = meetupRepo.findAll();
        return meetups;

    }

    @GetMapping("/meetup/{id}")
    public Meetup GetMeetUps(@PathVariable Integer id) {
        Meetup meetup = meetupRepo.findById(id).orElse(null);
        return meetup;

    }

    @PostMapping("/test-callback")
    public ResponseEntity<?> getData(@RequestBody Object callBackResponse) {

        try {

            System.out.printf(String.format("logCode=atgPayCallBack, callBack response (%s)", callBackResponse.toString()));
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(callBackResponse);
            System.out.printf(String.format("logCode=atgPayCallBack, callBack response (%s)", json));
        } catch (Exception e) {
            System.out.printf("logCode=atgPayCallBack, callBack response not captured");
            System.out.println("callBack response not captured");
        }
        return ResponseEntity.ok(null);
    }
}
