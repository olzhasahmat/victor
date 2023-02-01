package com.example.victorcrud.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String name;


    @Column
    private String description;


    @Column
    private Integer amount;


    @Column
    private BigDecimal price;


    @ManyToOne
    private MetaDocument photo;
}
