package com.mitin.aircompany.converter;

import com.mitin.aircompany.entity.DiscountEntity;
import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.model.Discount;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscountConverter {
    public Discount convertToModel(DiscountEntity discountEntity){
        return new Discount(
                discountEntity.getId(), discountEntity.getFromDate(),
                discountEntity.getToDate(), discountEntity.getValue()
        );
    }

    public List<Discount> convertToModel(List<DiscountEntity> discountEntities){
        return discountEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    public DiscountEntity convertToEntity(Discount discount){
        return new DiscountEntity(
                discount.getFromDate(), discount.getToDate(), discount.getValue()
        );
    }

    public DiscountEntity update(
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
