package br.pucpr.cityeventspring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime startDate;
    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime endDate;
    private String discription;
    private boolean paid;
    private Integer ageMin;
    @NotBlank
    private boolean status;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<Rating> ratings;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Set<Category> categorys;
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Address address;
}
