package br.pucpr.cityeventspring.service;

import br.pucpr.cityeventspring.exception.ObjectNotFoundException;
import br.pucpr.cityeventspring.model.Rating;
import br.pucpr.cityeventspring.repository.RatingRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private RatingRepository repository;

    public RatingService(RatingRepository repository) {
        this.repository = repository;
    }


    // APENAS USER DO TIPO USER PODEM AVALIAR OS EVENTOS
    public Rating create(Rating r){
        return repository.save(r);
    }

    // APENAS MODERADORES PODEM TER ACESSO A TODAS AS AVALIAÇÕES
    public List<Rating> findAll(){
        return repository.findAll();
    }

    // APENAS USER DO TIPO USER PODEM BUSCAR POR UMA AVALIAÇÃO ( A SUA )
    public Rating findById(Long id){
        Optional<Rating> r = repository.findById(id);
        return r.orElseThrow(() -> new ObjectNotFoundException("Not Found Category"));
    }

    // APENAS USER DO TIPO USER PODEM ATUALIZAR UMA AVALIAÇÃO ( A SUA )
    public Rating update (Long id, @Valid Rating r) {
        Rating oldR = findById(id);
        oldR.setValue(r.getValue());
        return repository.saveAndFlush(oldR);
    }

    // APENAS USER DO TIPO USER PODEM DELETAR UMA AVALIAÇÃO ( A SUA )
    public boolean delete(Long id) {
        Rating r = findById(id);
        if(r != null) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
