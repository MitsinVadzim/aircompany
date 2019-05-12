package com.mitin.aircompany.service;

import com.mitin.aircompany.model.Flight;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    List<Flight> findAll(Pageable pageable);

    Flight findById(Long flightId);

    Flight save(Flight flight);

    Flight update(Flight flight);

    void delete(Long flightId);
}
