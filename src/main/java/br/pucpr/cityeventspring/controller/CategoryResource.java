package br.pucpr.cityeventspring.controller;

import br.pucpr.cityeventspring.model.Category;
import br.pucpr.cityeventspring.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    private CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@Valid @RequestBody Category c){

    }

}
