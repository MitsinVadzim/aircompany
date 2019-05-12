package com.mitin.aircompany.converter;

import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.model.Route;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RouteConverter {
    public Route convertToModel(RouteEntity routeEntity){
        return new Route(
                routeEntity.getId(),
                routeEntity.getFromPlace(), routeEntity.getToPlace()
        );
    }

    public List<Route> convertToModel(List<RouteEntity> routeEntities){
        return routeEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    public RouteEntity convertToEntity(Route route){
        return new RouteEntity(
                route.getFromPlace(), route.getToPlace()
        );
    }

    public void update(RouteEntity routeEntity, Route route){
        routeEntity.setFromPlace(route.getFromPlace());
        routeEntity.setToPlace(route.getToPlace());
    }
}
