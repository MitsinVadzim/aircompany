package com.mitin.aircompany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
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

    public DiscountEntity(LocalDateTime fromDate, LocalDateTime toDate, Double value) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.value = value;
    }
}
