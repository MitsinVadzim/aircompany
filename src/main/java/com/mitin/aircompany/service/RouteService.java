package com.mitin.aircompany.service;

import com.mitin.aircompany.model.Route;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RouteService {

    List<Route> findAll(Pageable pageable);

    Route findById(Long routeId);

    Route save(Route route);

    Route update(Route route, Long routeId);

    void delete(Long routeId);
}
