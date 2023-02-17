package br.pucpr.cityeventspring.controller;

import br.pucpr.cityeventspring.model.Rating;
import br.pucpr.cityeventspring.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingResource {

    private RatingService service;

    public RatingResource(RatingService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> create(@Valid @RequestBody Rating r){
        Rating obj = service.create(r);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Rating>> findAll(){
        List<Rating> list = service.findAll();
        return list.size() > 0 ? ResponseEntity.ok().body(list) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Rating> findById( @PathVariable Long id){
        Rating obj = service.findById(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rating> atualizarEndereco(@PathVariable Long id, @Valid @RequestBody Rating r){
        Rating novObj = service.update(id, r);
        return r != null ? ResponseEntity.ok().body(r) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
