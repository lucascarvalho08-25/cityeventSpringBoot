package br.pucpr.cityeventspring.service;

import br.pucpr.cityeventspring.model.Category;
import br.pucpr.cityeventspring.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service

public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    private Category create(@Valid Category c){
        return repository.save(c);
    }



}
