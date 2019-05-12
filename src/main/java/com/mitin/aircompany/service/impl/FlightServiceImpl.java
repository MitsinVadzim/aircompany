package com.mitin.aircompany.service.impl;

import com.mitin.aircompany.converter.FlightConverter;
import com.mitin.aircompany.entity.FlightEntity;
import com.mitin.aircompany.exception.FlightNotFoundException;
import com.mitin.aircompany.model.Flight;
import com.mitin.aircompany.repository.FlightRepository;
import com.mitin.aircompany.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final FlightConverter flightConverter;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightConverter flightConverter) {
        this.flightRepository = flightRepository;
        this.flightConverter = flightConverter;
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
        return flightConverter.toModel(flightRepository.save(flightConverter.toEntity(flight)));
    }

    @Override
    public Flight update(Flight flight) {
        return flightConverter.toModel(flightRepository.save(flightConverter.toEntity(flight)));
    }

    @Override
    public void delete(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
