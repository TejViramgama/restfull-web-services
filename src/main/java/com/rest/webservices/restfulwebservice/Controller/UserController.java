package com.rest.webservices.restfulwebservice.Controller;

import com.rest.webservices.restfulwebservice.Model.User;
import com.rest.webservices.restfulwebservice.Repo.UserRepo;
import com.rest.webservices.restfulwebservice.Util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    private MessageSource messageSource;
    private UserRepo userRepo;
    private com.rest.webservices.restfulwebservice.Util.Config Config;


    public UserController(MessageSource messageSource, UserRepo userRepo, Config Config) {
        this.messageSource = messageSource;
        this.userRepo = userRepo;
        this.Config = Config;
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user = userRepo.findById(id).orElse(null);

        if (user == null) {
            throw new UserNotFoundException();
        }

        System.out.println(Config.getUrl()+ "  ***********************  "+Config.getTtm());

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

        User createdUser = userRepo.save(user);
        throw new UserNotFoundException();
//        return ResponseEntity.ok(createdUser);
    }
}
