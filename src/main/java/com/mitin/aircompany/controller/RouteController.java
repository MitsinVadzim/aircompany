package com.mitin.aircompany.controller;

import com.mitin.aircompany.model.Route;
import com.mitin.aircompany.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public List<Route> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return routeService.findAll(pageable);
    }

    @GetMapping("/routes/{routeId}")
    public Route findById(@PathVariable("routeId") Long routeId) {
        return routeService.findById(routeId);
    }

    @PostMapping("/routes")
    public Route save(@RequestBody Route route) {
        return routeService.save(route);
    }

    @PutMapping("/routes/{routeId}")
    public Route update(
            @RequestBody Route route,
            @PathVariable("routeId") Long routeId
    ) {
        return routeService.update(route, routeId);
    }

    @DeleteMapping("/routes/{routeId}")
    public void delete(
            @PathVariable("routeId") Long routeId
    ) {
        routeService.delete(routeId);
    }
}
