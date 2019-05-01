package com.mitin.aircompany.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "discount")
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime fromDate;

    private LocalDateTime toDate;

    private Double value;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Route_Discount",
            joinColumns = {@JoinColumn(name = "discount_id")},
            inverseJoinColumns = {@JoinColumn(name = "route_id")}
    )
    private Set<RouteEntity> routes = new HashSet<>();
}
