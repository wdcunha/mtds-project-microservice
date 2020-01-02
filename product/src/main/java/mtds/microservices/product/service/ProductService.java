//package mtds.microservices.product.service;
//
//import mtds.microservices.product.dao.ProductDao;
//import mtds.microservices.product.model.Product;
//import mtds.microservices.product.model.ProductDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
////@Service
//public class ProductService {
//
////    @Autowired
//    private ProductDao productDao;
//
////    public Iterable<Product> productsList() {
////        System.out.println("Listing all microservices- courses");
////        return productDao.findAll();
////    }
//
//    public Product saveProduct(ProductDTO productDTO) {
//        Product newProduct = new Product();
//        newProduct.setProductName(productDTO.getProductName());
//        newProduct.setDescription(productDTO.getDescription());
//        return productDao.save(newProduct);
//    }
//
//}
