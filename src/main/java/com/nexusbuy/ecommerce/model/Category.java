package com.nexusbuy.ecommerce.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="category_name")
    private @NotBlank  String categoryName;
    private @NotBlank String description;
    private @NotBlank String imageUrl;
}
