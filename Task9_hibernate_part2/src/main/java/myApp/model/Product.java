package myApp.model;

import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private String productId;

    private String name;

    private String description;

    private BigDecimal price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    private String manufacturer;

    @Column(name = "production_date")
    private LocalDate productionDate;

}
