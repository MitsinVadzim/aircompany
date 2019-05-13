package com.mitin.aircompany.service.impl;

import com.mitin.aircompany.converter.FlightConverter;
import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.exception.FlightNotFoundException;
import com.mitin.aircompany.exception.RouteNotFoundException;
import com.mitin.aircompany.model.Flight;
import com.mitin.aircompany.repository.FlightRepository;
import com.mitin.aircompany.repository.RouteRepository;
import com.mitin.aircompany.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final FlightConverter flightConverter;
    private final RouteRepository routeRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightConverter flightConverter, RouteRepository routeRepository) {
        this.flightRepository = flightRepository;
        this.flightConverter = flightConverter;
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Flight> findAll(Pageable pageable) {
        return flightConverter.toModel(flightRepository.findAll(pageable).getContent());
    }

    @Override
    public Flight findById(Long flightId) {
        return flightConverter.toModel(flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId)));
    }

    @Override
    public Flight save(Flight flight) {
        RouteEntity routeEntity = routeRepository.findById(flight.getRouteId())
                .orElseThrow(() -> new RouteNotFoundException(flight.getRouteId()));
        return flightConverter.toModel(flightRepository.save(flightConverter.toEntity(flight, routeEntity)));
    }

    @Override
    public Flight update(Flight flight) {
        RouteEntity routeEntity = routeRepository.findById(flight.getRouteId())
                .orElseThrow(() -> new RouteNotFoundException(flight.getRouteId()));
        return flightConverter.toModel(flightRepository.save(flightConverter.toEntity(flight, routeEntity)));
    }

    @Override
    public void delete(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
