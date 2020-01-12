package mtds.microservices.cart.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseFactory {

    private Response response;

    public ResponseFactory build(Object data) {
        this.response = new Response(true, "Message sent to the RabbitMQ product queue Successfully", data);
        return this;
    }

    public Response getResponse(Object data) {
        return this.response;
    }

    public String serialize() {
        ObjectMapper Obj = new ObjectMapper();

        try {
            return Obj.writeValueAsString(this.response);
        } catch (JsonProcessingException e) {
            return "JsonProcessingException: " + e;
        }
    }
}
