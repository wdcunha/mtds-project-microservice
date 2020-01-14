package mtds.microservices.product.controller;

import mtds.microservices.product.dao.ProductDao;
import mtds.microservices.product.model.Product;
import mtds.microservices.product.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> listProducts() {
        return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ResponseEntity<?> saveProd(@RequestBody ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setProductName(productDTO.getProductName());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setPictureUrl(productDTO.getPictureUrl());
        return ResponseEntity.ok(productDao.save(newProduct));
    }
}
