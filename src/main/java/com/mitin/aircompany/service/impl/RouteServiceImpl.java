package com.mitin.aircompany.service.impl;

import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.exception.RouteNotFoundException;
import com.mitin.aircompany.model.Route;
import com.mitin.aircompany.repository.RouteRepository;
import com.mitin.aircompany.service.RouteService;
import com.mitin.aircompany.converter.RouteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final RouteConverter routeConverter;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, RouteConverter routeConverter) {
        this.routeRepository = routeRepository;
        this.routeConverter = routeConverter;
    }

    @Override
    @Transactional
    public List<Route> findAll(Pageable pageable){
        return routeConverter.convertToModel(routeRepository.findAll(pageable).getContent());
    }

    @Override
    @Transactional
    public Route findById(Long routeId){
        return routeConverter.convertToModel(routeRepository.findById(routeId)
                .orElseThrow(()-> new RouteNotFoundException(routeId)));
    }

    @Override
    @Transactional
    public Route save(Route route){
        return routeConverter.convertToModel(routeRepository.save(routeConverter.convertToEntity(route)));
    }

    @Override
    @Transactional
    public Route update(Route route, Long routeId){
        RouteEntity routeEntity = routeRepository.findById(routeId)
                .orElseThrow(() -> new RouteNotFoundException(routeId));
        routeConverter.update(routeEntity, route);
        return routeConverter.convertToModel(routeRepository.save(routeEntity));
    }

    @Override
    @Transactional
    public void delete(Long routeId){
        routeRepository.deleteById(routeId);
    }
}
