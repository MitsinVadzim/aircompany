package com.mitin.aircompany.converter;

import com.mitin.aircompany.entity.FlightEntity;
import com.mitin.aircompany.model.Flight;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightConverter {

    public FlightEntity toEntity(Flight flight){
        return FlightEntity.builder()
                .capacity(flight.getCapacity())
                .dateTime(flight.getDateTime())
                .numberOfSeats(flight.getNumberOfSeats())
                .price(flight.getPrice())
                .routeId(flight.getRouteId())
                .build();
    }

    public Flight toModel(FlightEntity flightEntity){
        return Flight.builder()
                .capacity(flightEntity.getCapacity())
                .dateTime(flightEntity.getDateTime())
                .id(flightEntity.getId())
                .numberOfSeats(flightEntity.getNumberOfSeats())
                .price(flightEntity.getPrice())
                .routeId(flightEntity.getRouteId())
                .build();
    }

    public List<Flight> toModel(List<FlightEntity> flightEntities){
        return flightEntities
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
