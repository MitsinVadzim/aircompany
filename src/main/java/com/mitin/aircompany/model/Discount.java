package com.mitin.aircompany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private Long id;

    private LocalDateTime fromDate;

    private LocalDateTime toDate;

    private Double value;
}
