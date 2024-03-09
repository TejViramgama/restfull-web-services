import com.rest.webservices.restfulwebservice.Controller.PostController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TestMvcSpec extends Specification {

    @Autowired
    private PostController postController;

    def "Test MVC 1"() {
        expect:
        postController.perfome
    }

}