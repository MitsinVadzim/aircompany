package com.mitin.aircompany.model;

import lombok.Data;

@Data
public class Route {
    private Long id;

    private String num;

    private String fromPlace;

    private String toPlace;

    public Route(Long id, String num, String fromPlace, String toPlace) {
        this.id = id;
        this.num = num;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
    }
}
