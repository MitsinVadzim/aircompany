package com.mitin.aircompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Flight {

    private Long id;

    private LocalDateTime dateTime;

    private int capacity;

    private int numberOfSeats;

    private BigDecimal price;

    private Long routeId;
}
