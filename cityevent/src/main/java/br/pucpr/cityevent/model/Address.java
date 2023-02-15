package br.pucpr.cityevent.model;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @NotBlank
    private String street;

    private String complement;
    @NotBlank
    private String district;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zipCode;
    // fazer um micro serviço que buscar o cep na api e preenche os campos.

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "events_id", referencedColumnName = "id")
    private Event event;
}
