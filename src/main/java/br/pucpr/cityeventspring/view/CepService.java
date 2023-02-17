package br.pucpr.cityeventspring.view;

import br.pucpr.cityeventspring.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {

    @GetMapping("{cep}/json")
    Address buscaEnderecoPorCep(@PathVariable("cep") String cep);
}


