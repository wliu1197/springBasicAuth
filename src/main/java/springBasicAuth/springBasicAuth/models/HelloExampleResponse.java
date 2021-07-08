package springBasicAuth.springBasicAuth.models;

import io.swagger.annotations.ApiModelProperty;

public class HelloExampleResponse {
    @ApiModelProperty(
            name = "message",
            dataType = "String",
            example = "Hello World count B: 2 count C 99")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
