package com.adminPanel.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "product")
@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be in the future")
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private double price;

    private boolean available;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductDetails(Date expirationDate,
                          String manufacturer, double price, boolean available) {

        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }
}

