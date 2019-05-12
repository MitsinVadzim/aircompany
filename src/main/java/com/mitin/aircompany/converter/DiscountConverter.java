package com.mitin.aircompany.converter;

import com.mitin.aircompany.entity.DiscountEntity;
import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.model.Discount;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountConverter {
    public static Discount convertToModel(DiscountEntity discountEntity){
        return new Discount(
                discountEntity.getId(), discountEntity.getFromDate(),
                discountEntity.getToDate(), discountEntity.getValue()
        );
    }

    public static List<Discount> convertToModel(List<DiscountEntity> discountEntities){
        return discountEntities.stream()
                .map(DiscountConverter::convertToModel)
                .collect(Collectors.toList());
    }

    public static DiscountEntity convertToEntity(Discount discount){
        return new DiscountEntity(
                discount.getFromDate(), discount.getToDate(), discount.getValue()
        );
    }

    public static DiscountEntity update(
            DiscountEntity discountEntity,
            Discount discount,
            List<RouteEntity> routeEntities
    ){
        discountEntity.setFromDate(discount.getFromDate());
        discountEntity.setToDate(discount.getToDate());
        discountEntity.setValue(discount.getValue());
        discountEntity.setRoutes(new HashSet<>(routeEntities));
        return discountEntity;
    }
}
