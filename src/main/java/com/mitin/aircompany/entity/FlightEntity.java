package com.mitin.aircompany.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
}
