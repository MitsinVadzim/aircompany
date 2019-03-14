package com.mitin.aircompany.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String num;

    private String fromPlace;

    private String toPlace;

    private int numberOfSeats;


    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<FlightInfoEntity> flightInfoEntities;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<DiscountEntity> discountEntities;

    @ManyToMany
    @JoinTable(
            name = "Subscriber_Flight",
            joinColumns = {@JoinColumn(name = "flight_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<UserEntity> subscribers = new HashSet<>();
}
