package com.nexusbuy.ecommerce.controller;

import com.nexusbuy.ecommerce.model.Category;
import com.nexusbuy.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Void> createCategory(@RequestBody Category category) {
        if(Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {
            categoryService.createCategory(category);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
