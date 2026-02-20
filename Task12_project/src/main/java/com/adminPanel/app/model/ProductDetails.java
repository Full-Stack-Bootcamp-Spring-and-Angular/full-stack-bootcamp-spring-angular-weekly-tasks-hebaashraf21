package com.adminPanel.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private String manufacturer;

    private double price;

    private boolean available;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
