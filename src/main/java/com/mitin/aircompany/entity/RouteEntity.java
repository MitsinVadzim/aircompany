package com.mitin.aircompany.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "route")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String num;

    private String fromPlace;

    private String toPlace;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<FlightEntity> flightEntities;

    @ManyToMany
    @JoinTable(
            name = "Subscriber_Route",
            joinColumns = {@JoinColumn(name = "route_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<UserEntity> subscribers = new HashSet<>();

    @ManyToMany(mappedBy = "routes")
    private Set<DiscountEntity> discounts = new HashSet<>();

    public RouteEntity(String num, String fromPlace, String toPlace) {
        this.num = num;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
    }
}
