package com.mitin.aircompany.controller;

import com.mitin.aircompany.converter.FlightConverter;
import com.mitin.aircompany.model.Flight;
import com.mitin.aircompany.repository.FlightRepository;
import com.mitin.aircompany.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;
    private final FlightRepository flightRepository;
    private final FlightConverter flightConverter;

    @Autowired
    public FlightController(FlightService flightService, FlightRepository flightRepository, FlightConverter flightConverter) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
        this.flightConverter = flightConverter;
    }

//    @GetMapping
//    public List<Flight> findAll(
//            @RequestParam("page") int page,
//            @RequestParam("size") int size
//    ){
//        Pageable pageable = PageRequest.of(page, size);
//        return flightService.findAll(pageable);
//    }

    @GetMapping
    public List<Flight> findAll(){
        return flightConverter.toModel(flightRepository.findAll());
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

    @PutMapping("{flightId}")
    public Flight update(
            @RequestBody Flight flight,
            @PathVariable Long flightId
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
