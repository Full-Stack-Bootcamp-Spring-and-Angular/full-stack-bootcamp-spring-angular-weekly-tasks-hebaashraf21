package com.adminPanel.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Product name is required")
    @Size(min = 3, message = "Product name must be at least 3 characters")
    private String name;

    @Column(name = "image_path")
    private String imagePath;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @Valid
    @NotNull(message = "Product details are required")
    private ProductDetails productDetails;

    public Product(String name) {
        this.name = name;
    }
}
