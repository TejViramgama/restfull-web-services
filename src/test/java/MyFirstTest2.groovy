import com.rest.webservices.restfulwebservice.Controller.PostController
import com.rest.webservices.restfulwebservice.Model.Post
import com.rest.webservices.restfulwebservice.Repo.PostRepo
import com.rest.webservices.restfulwebservice.Repo.UserRepo
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class MyFirstTest2 extends Specification {

    PostRepo postRepo = Mock();
    MessageSource messageSource = Mock();
    UserRepo userRepo = Stub();
    PostController postController = new PostController(messageSource, postRepo, userRepo);

    def "Test 2"() {

        given:
        def id = 1;
        userRepo.existsById(id) >> true;

        when:
        ResponseEntity<List<Post>> posts =  postController.GetUserPosts(id);

        then:
        1 * postRepo.findAllByUserId(id)
        posts.getStatusCode() == HttpStatus.OK;


    }

}