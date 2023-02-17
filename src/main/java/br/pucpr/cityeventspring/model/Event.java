package br.pucpr.cityeventspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private Integer ageMin;

    @NotBlank
    private boolean status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ratings_id", referencedColumnName = "id")
    private Set<Rating> ratings;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private Set<Category> categorys;


    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Address address;
}
