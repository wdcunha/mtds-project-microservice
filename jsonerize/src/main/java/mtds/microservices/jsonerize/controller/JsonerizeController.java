package mtds.microservices.jsonerize.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mtds.microservices.jsonerize.service.JsonerizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class JsonerizeController {

    @Autowired
    JsonerizeService jsonerizeService;

    @Autowired
    public JsonerizeController(JsonerizeService jsonerizeService) {
        this.jsonerizeService = jsonerizeService;
    }

    @GetMapping(value = "/api/files/system/{filename}", produces = "text/csv; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Resource getFileFromFileSystem(@PathVariable String filename, HttpServletResponse response) {
        return jsonerizeService.getFileSystem(filename, response);
    }

    @CrossOrigin
    @RequestMapping(value = "/products/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadProductsJsonFile() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(jsonerizeService.getProductListReceived());
        byte[] isr = json.getBytes();
        String fileName = "products.json";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentLength(isr.length);
        responseHeaders.setContentType(new MediaType("text", "json"));
        responseHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

        return new ResponseEntity<byte[]>(isr, responseHeaders, HttpStatus.OK);

    }


}
