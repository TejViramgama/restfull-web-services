package com.rest.webservices.restfulwebservice.Controller;

import com.rest.webservices.restfulwebservice.Model.*;
import com.rest.webservices.restfulwebservice.Repo.*;
import net.sf.ehcache.CacheManager;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class MealController {

    MealRepo mealRepo;
    CourseRepo courseRepo;
    CreatorRepo creatorRepo;
    ReviewRepo reviewRepo;
    StudentRepo studentRepo;
    @PersistenceContext
    private EntityManager entityManager;

    public MealController(MealRepo mealRepo, CourseRepo courseRepo, CreatorRepo creatorRepo, ReviewRepo reviewRepo, StudentRepo studentRepo) {
        this.mealRepo = mealRepo;
        this.courseRepo = courseRepo;
        this.creatorRepo = creatorRepo;
        this.reviewRepo = reviewRepo;
        this.studentRepo = studentRepo;
    }

    @GetMapping("/meals/{id}")
    public ResponseEntity<MealDto> getMeal(@PathVariable Integer id) {
        Meal m = mealRepo.findById(id).orElse(null);
        MealDto md = new MealDto();
        md.setId(m.getId());
        md.setAuthor(m.getName());
        md.setText(m.getDescription());
        return ResponseEntity.ok(md);
    }

    @GetMapping("/meals")
    public ResponseEntity<List<MealDto>> getAllMeals() {
        List<Meal> mealList = mealRepo.findAll();
        List<MealDto> mealDtos = new ArrayList<>();
        for (Meal m : mealList) {
            MealDto md = new MealDto();
            md.setId(m.getId());
            md.setAuthor(m.getName());
            md.setText(m.getDescription());

            mealDtos.add(md);
        }
        return ResponseEntity.ok(mealDtos);
    }

    @PostMapping("/meal")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {

        Meal createdmeal = mealRepo.save(meal);
        return ResponseEntity.ok(createdmeal);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> orderMeal(@RequestBody String obj) {
        System.out.println(obj);
        return ResponseEntity.ok("Success");
    }


    @PostMapping("/course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Creator creator = new Creator();
        creator.setAge(course.getCreator().getAge());
        creator.setName(course.getCreator().getName());
        Creator cr = creatorRepo.save(creator);

        creator.setName("Update" +creator.getName());
        course.setCreator(cr);
        Course c = courseRepo.save(course);

        return ResponseEntity.ok(c);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCources(@PathVariable Integer id) {

        Course course = entityManager.find(Course.class,id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Integer id) {

        courseRepo.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/creator/{id}")
    public ResponseEntity<Creator> getcreator(@PathVariable Integer id) {

        Creator creator1 = entityManager.find(Creator.class,id);
        return ResponseEntity.ok(creator1);
    }

    @PostMapping("review/{courseId}")
    public ResponseEntity<Review> addReview(@PathVariable Integer courseId, @RequestBody Review r) {
        Course c = courseRepo.findById(courseId).get();

        c.addReview(r);
        r.setCourse(c);
        Review review = reviewRepo.save(r);

        return ResponseEntity.ok(review);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Integer id) {

        Review review = reviewRepo.findById(id).get();

        return ResponseEntity.ok(review);
    }

    @PostMapping("student/{courseId}")
    public ResponseEntity<Student> addReview(@PathVariable Integer courseId, @RequestBody Student student) {
        Course c = courseRepo.findById(courseId).get();
        Student student1 = studentRepo.save(student);

        c.addStudent(student1);
        student1.addCourse(c);

        Student student2 = studentRepo.save(student1);
        return ResponseEntity.ok(student2);
    }


    @GetMapping("/course")
    public ResponseEntity<List<Course>> GetCourses() {
        List<Course> course = courseRepo.findAll();
        return ResponseEntity.ok(course);
    }
}
