package com.mitin.aircompany.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "route")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String num;

    private String fromPlace;

    private String toPlace;



    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<FlightEntity> flightEntities;
//
//    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
//    private List<DiscountEntity> discountEntities;
//
//    @ManyToMany
//    @JoinTable(
//            name = "Subscriber_Flight",
//            joinColumns = {@JoinColumn(name = "flight_id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_id")}
//    )
//    private Set<UserEntity> subscribers = new HashSet<>();
}
