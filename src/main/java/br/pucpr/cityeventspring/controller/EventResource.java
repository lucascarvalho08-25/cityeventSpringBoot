package br.pucpr.cityeventspring.controller;

import br.pucpr.cityeventspring.model.Category;
import br.pucpr.cityeventspring.model.Event;
import br.pucpr.cityeventspring.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventResource {


    private EventService service;

    public EventResource(EventService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<Event> create(@Valid @RequestBody Event e){
        Event obj = service.create(e);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Event>> findAll(){
        List<Event> list = service.findAll();
        return list.size() > 0 ? ResponseEntity.ok().body(list) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Event> findById( @PathVariable Long id){
        Event obj = service.findById(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> update(@PathVariable Long id, @Valid @RequestBody Event e){
        Event novObj = service.update(id, e);
        return novObj != null ? ResponseEntity.ok().body(novObj) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }



}
