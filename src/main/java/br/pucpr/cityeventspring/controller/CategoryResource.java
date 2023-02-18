package br.pucpr.cityeventspring.controller;

import br.pucpr.cityeventspring.model.Category;
import br.pucpr.cityeventspring.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    private CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@Valid @RequestBody Category c){
        Category obj = service.create(c);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return list.size() > 0 ? ResponseEntity.ok().body(list) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Category> findById( @PathVariable Long id){
        Category obj = service.findById(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @Valid @RequestBody Category c){
        Category novObj = service.update(id, c);
        return novObj != null ? ResponseEntity.ok().body(novObj) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
