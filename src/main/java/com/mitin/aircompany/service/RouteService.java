package com.mitin.aircompany.service;

import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.exception.RouteNotFoundException;
import com.mitin.aircompany.model.Route;
import com.mitin.aircompany.repository.RouteRepository;
import com.mitin.aircompany.util.RouteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> findAll(Pageable pageable){
        return RouteConverter.convertToModel(routeRepository.findAll(pageable).getContent());
    }

    public Route findById(Long routeId){
        return RouteConverter.convertToModel(routeRepository.findById(routeId).orElseThrow(()-> new RouteNotFoundException(routeId)));
    }

    public Route save(Route route){
        return RouteConverter.convertToModel(routeRepository.save(RouteConverter.convertToEntity(route)));
    }

    public Route update(Route route, Long routeId){
        RouteEntity routeEntity = RouteConverter.convertToEntity(route);
        routeEntity.setId(routeId);
        return RouteConverter.convertToModel(routeRepository.save(routeEntity));
    }

    public void delete(Long routeId){
        routeRepository.deleteById(routeId);
    }
}
