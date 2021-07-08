package springBasicAuth.springBasicAuth.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springBasicAuth.springBasicAuth.models.HelloExampleResponse;
import springBasicAuth.springBasicAuth.models.TestClassA;
import springBasicAuth.springBasicAuth.models.TestClassC;


import java.util.Map;

@RestController
@RequestMapping("/rest-api")
public class RestApiController {


    @Autowired
    private TestClassA testClassA;
    @Autowired
    private TestClassC testClassC;
    ObjectMapper mapper = new ObjectMapper();
    @ApiOperation(value = "Say Hello!", response = Iterable.class)
    /*@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response = HelloExampleResponse.class),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })*/
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response = HelloExampleResponse.class)
    })
    @GetMapping("/hello")
    @ResponseStatus(value = HttpStatus.OK)
    public JsonNode hello(@RequestParam(value = "name", defaultValue = "World") String name) throws JsonProcessingException {
        testClassA.addCountOnB();
        testClassC.minCount(1);
        String json =  "{\"message\":" + "\"Hello " + name +" count B: " + testClassA.getCountB() + " count C " + testClassC.getCount() + "\"}";
        return mapper.readTree(json);
    }


    @ApiOperation(value = "Say Hello!", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response = HelloExampleResponse.class)
    })
    @PostMapping("/herePost")
    @ResponseStatus(value = HttpStatus.OK)
    public JsonNode testPost(@ApiParam(value = "{foo: whatever, bar: whatever2}")@RequestBody JsonNode payload) throws JsonProcessingException {
        Map<String, String> payloadMap = mapper.convertValue(payload, new TypeReference<Map<String, String>>(){});
        String json =  "{\"message\": \"" + payloadMap.get("message") + "\"}";
        return mapper.readTree(json);
    }
}
