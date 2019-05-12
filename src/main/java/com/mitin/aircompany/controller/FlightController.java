package com.mitin.aircompany.controller;

import com.mitin.aircompany.model.Flight;
import com.mitin.aircompany.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return flightService.findAll(pageable);
    }

    @GetMapping("{flightId}")
    public Flight findById(
            @PathVariable("flightId") Long flightId
    ){
        return flightService.findById(flightId);
    }

    @PostMapping
    public Flight save(
            @RequestBody Flight flight
    ){
        return flightService.save(flight);
    }

    @PutMapping
    public Flight update(
            @RequestBody Flight flight
    ){
        return flightService.update(flight);
    }

    @DeleteMapping("{flightId}")
    public void delete(
            @PathVariable("flightId") Long flightId
    ){
        flightService.delete(flightId);
    }
}
