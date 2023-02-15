package br.pucpr.cityevent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NotBlank
    private String title;
    @NotBlank
    @DateTimeFormat(pattern = "MM-dd-yyyy hh:mm")
    private Date startDate;
    @NotBlank
    @DateTimeFormat(pattern = "MM-dd-yyyy hh:mm")
    private Date endDate;
    private String discription;

    private boolean paid;

    private int ageMin;

    @NotBlank
    private boolean status;

    private List<Category> categorys;


    @OneToOne(mappedBy = "address")
    private Address adress;
}
