package br.pucpr.cityeventspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(name = "street")
    @NotBlank
    private String logradouro;
    @Column(name = "complement")
    private String complemento;
    @Column(name = "district")
    @NotBlank
    private String bairro;
    @Column(name = "city")
    @NotBlank
    private String localidade;
    @Column(name = "state")
    @NotBlank
    private String uf;
    @Column(name = "zipCode")
    @NotBlank
    private String cep;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "events_id", referencedColumnName = "id")
    private Event event;
}
