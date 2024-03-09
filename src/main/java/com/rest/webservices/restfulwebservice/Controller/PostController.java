package com.rest.webservices.restfulwebservice.Controller;

import com.rest.webservices.restfulwebservice.Model.Post;
import com.rest.webservices.restfulwebservice.Model.User;
import com.rest.webservices.restfulwebservice.Repo.PostRepo;
import com.rest.webservices.restfulwebservice.Repo.UserRepo;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    private MessageSource messageSource;
    private PostRepo postRepo;
    private UserRepo userRepo;

    public PostController(MessageSource messageSource, PostRepo postRepo, UserRepo userRepo) {
        this.messageSource = messageSource;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @PostMapping("/users/{id}/post")
    public ResponseEntity<Post> addUser(@Valid @RequestBody Post post, @PathVariable Integer id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        }
        post.setUser(user);
        Post createPost = postRepo.save(post);
        return ResponseEntity.ok(createPost);

    }

    @GetMapping("/users/{id}/post")
    public ResponseEntity<List<Post>> GetAllUserPosts(@PathVariable Integer id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        }
       List<Post> posts = postRepo.findAllByUserId(122);
        return ResponseEntity.ok(posts);

    }


//    @GetMapping("/users/{id}/post")
//    public ResponseEntity<List<Post>> GetUserPosts(@PathVariable Integer id) {
//        boolean isExist = userRepo.existsById(id);
//        if (!isExist) {
//            throw new UserNotFoundException();
//        }
//        List<Post> posts = postRepo.findAllByUserId(id);
//        return ResponseEntity.ok(posts);
//
//    }

    @GetMapping("/hey")
    public ResponseEntity<String> getSimpleStuff() {
        String s = "Hola Tej";
        return ResponseEntity.ok(s);

    }

}
