package br.pucpr.cityeventspring.service;

import br.pucpr.cityeventspring.exception.ObjectNotFoundException;
import br.pucpr.cityeventspring.model.Category;
import br.pucpr.cityeventspring.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    public Category create(@Valid Category c){
        return repository.save(c);
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(@Valid Long id){
        Optional<Category> c = repository.findById(id);
        return c.orElseThrow(() -> new ObjectNotFoundException("Not Found Category"));
    }

    public Category update (@Valid Long id, @Valid Category c) {
        Category oldC = findById(id);
        oldC.setTitle(c.getTitle());
        return repository.saveAndFlush(oldC);
    }

    public boolean delete(@Valid Long id) {
        Category c = findById(id);
        if(c != null) {
           repository.deleteById(id);
           return true;
        }
        return false;
    }
}
