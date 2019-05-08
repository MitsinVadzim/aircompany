package com.mitin.aircompany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "route")
@AllArgsConstructor
@NoArgsConstructor
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

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

    public RouteEntity(String fromPlace, String toPlace){
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
    }
}
