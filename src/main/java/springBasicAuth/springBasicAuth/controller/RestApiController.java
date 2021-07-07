package springBasicAuth.springBasicAuth.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-api")
public class RestApiController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
