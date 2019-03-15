package com.mitin.aircompany.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Discount {
    private Long id;

    private LocalDateTime fromDate;

    private LocalDateTime toDate;

    private Double value;

    public Discount(Long id, LocalDateTime fromDate, LocalDateTime toDate, Double value) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.value = value;
    }
}
