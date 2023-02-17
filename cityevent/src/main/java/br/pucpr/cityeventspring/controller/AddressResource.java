package br.pucpr.cityeventspring.controller;


import br.pucpr.cityeventspring.model.Address;
import br.pucpr.cityeventspring.view.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressResource {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<Address> getCep(@PathVariable String cep) {

        Address address = cepService.buscaEnderecoPorCep(cep);
        return address != null ? ResponseEntity.ok().body(address) : ResponseEntity.notFound().build();
    }

}
