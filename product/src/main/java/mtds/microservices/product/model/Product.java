package mtds.microservices.product.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producttb")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id", scope = Product.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String productName;

    @Column
    private Double price;

    @Column
    private String pictureUrl;

    public Product() {
    }

    public Product(Long id, String productName, Double price, String pictureUrl) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
