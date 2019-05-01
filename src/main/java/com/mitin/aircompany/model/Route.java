package com.mitin.aircompany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private Long id;

    private String fromPlace;

    private String toPlace;
}
