package mtds.microservices.jsonerize.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import mtds.microservices.jsonerize.model.ProductDTO;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Configurable
public class JsonerizeService {

    private List<ProductDTO> productListReceived;
    private ObjectMapper mapper;


    public void saveJson(List<ProductDTO> productList) {

        this.productListReceived = productList;

        this.mapper = new ObjectMapper();

        try {

            mapper.writeValue(new File("products.json"), productList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private enum ResourceType {
        FILE_SYSTEM,
        CLASSPATH
    }

    private static final String FILE_DIRECTORY = "/var/files";

    /**
     * @param filename filename
     * @param response Http response.
     * @return file from system.
     */
    public Resource getFileSystem(String filename, HttpServletResponse response) {
        return getResource(filename, response, ResourceType.FILE_SYSTEM);
    }

    /**
     * @param filename filename
     * @param response Http response.
     * @return file from classpath.
     */
    public Resource getClassPathFile(String filename, HttpServletResponse response) {
        return getResource(filename, response, ResourceType.CLASSPATH);
    }

    private Resource getResource(String filename, HttpServletResponse response, ResourceType resourceType) {
        response.setContentType("text/csv; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        response.setHeader("filename", filename);

        Resource resource = null;
        switch (resourceType) {
            case FILE_SYSTEM:
                resource = new FileSystemResource(FILE_DIRECTORY + filename);
                break;
            case CLASSPATH:
                resource = new ClassPathResource("data/" + filename);
                break;
        }

        return resource;
    }

    public List<ProductDTO> getProductListReceived() {
        return productListReceived;
    }

    public void setProductListReceived(List<ProductDTO> productListReceived) {
        this.productListReceived = productListReceived;
    }
}
