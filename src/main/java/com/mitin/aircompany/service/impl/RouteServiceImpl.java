package com.mitin.aircompany.service.impl;

import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.exception.RouteNotFoundException;
import com.mitin.aircompany.model.Route;
import com.mitin.aircompany.repository.RouteRepository;
import com.mitin.aircompany.service.RouteService;
import com.mitin.aircompany.util.RouteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    @Transactional
    public List<Route> findAll(Pageable pageable){
        return RouteConverter.convertToModel(routeRepository.findAll(pageable).getContent());
    }

    @Override
    @Transactional
    public Route findById(Long routeId){
        RouteEntity routeEntity = routeRepository.findById(routeId)
                .orElseThrow(() -> new RouteNotFoundException(routeId));
        return RouteConverter.convertToModel(routeEntity);
    }

    @Override
    @Transactional
    public Route save(Route route){
        RouteEntity routeEntity = RouteConverter.convertToEntity(route);
        return RouteConverter.convertToModel(routeRepository.save(routeEntity));
    }

    @Override
    @Transactional
    public Route update(Route route, Long routeId){
        RouteEntity routeEntity = routeRepository.findById(routeId).orElseThrow(() -> new RouteNotFoundException(routeId));
        RouteConverter.update(routeEntity, route);
        return RouteConverter.convertToModel(routeRepository.save(routeEntity));
    }

    @Override
    @Transactional
    public void delete(Long routeId){
        routeRepository.deleteById(routeId);
    }
}
