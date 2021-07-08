package springBasicAuth.springBasicAuth.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBasicAuth.springBasicAuth.model.TestClassA;
import springBasicAuth.springBasicAuth.model.TestClassC;

@RestController
@RequestMapping("/rest-api")
public class RestApiController {
    @Autowired
    private TestClassA testClassA;
    @Autowired
    private TestClassC testClassC;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        testClassA.addCountOnB();
        testClassC.minCount(1);
        return String.format("Hello " + name +" count B: " + testClassA.getCountB() + " count C " + testClassC.getCount());
    }
}
