package br.pucpr.cityeventspring.service;

import br.pucpr.cityeventspring.exception.ObjectNotFoundException;
import br.pucpr.cityeventspring.model.Address;
import br.pucpr.cityeventspring.model.Event;
import br.pucpr.cityeventspring.repository.AddressRepository;
import br.pucpr.cityeventspring.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private EventRepository repository;
    private AddressRepository addressRepository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event create(@Valid Event e){
        //addressRepository.save(e.getAddress());
        return repository.save(e);
    }


    public List<Event> findAll(){

        List<Event> list = repository.findAll();
        /*
        *  realizar as validação
        *  SE a data for MENOR que a DATA ATUAL deixar fora da lista
        *
        *  via QUARY ou validação JAVA
        * */
        return list;
    }

    public Event findById(Long id){
        Optional<Event> e = repository.findById(id);
        return e.orElseThrow(
                () -> new ObjectNotFoundException("Nenhuma resultado encontrado para o Id: "+ id));
    }

    public Event update (Long id, @Valid Event e) {
        Event old = findById(id);

        old.setTitle(e.getTitle());
        old.setStartDate(e.getStartDate());
        old.setEndDate(e.getEndDate());
        old.setStatus(old.isStatus());
        old.setDiscription(e.getDiscription());
        old.setCategorys(e.getCategorys());
        old.setAddress(e.getAddress());

        addressRepository.saveAndFlush(e.getAddress());

        return repository.saveAndFlush(old);
    }

    public boolean delete(Long id) {
        Event e = findById(id);
        if(e != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
