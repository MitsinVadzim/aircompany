package com.mitin.aircompany.util;

import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.model.Route;

import java.util.List;
import java.util.stream.Collectors;

public class RouteConverter {
    public static Route convertToModel(RouteEntity routeEntity){
        return new Route(
                routeEntity.getId(),
                routeEntity.getFromPlace(), routeEntity.getToPlace()
        );
    }

    public static List<Route> convertToModel(List<RouteEntity> routeEntities){
        return routeEntities.stream()
                .map(RouteConverter::convertToModel)
                .collect(Collectors.toList());
    }

    public static RouteEntity convertToEntity(Route route){
        return new RouteEntity(
                route.getFromPlace(), route.getToPlace()
        );
    }

    public static void update(RouteEntity routeEntity, Route route){
        routeEntity.setFromPlace(route.getFromPlace());
        routeEntity.setToPlace(route.getToPlace());
    }
}
