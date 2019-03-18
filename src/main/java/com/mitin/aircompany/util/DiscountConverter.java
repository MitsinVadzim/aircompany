package com.mitin.aircompany.util;

import com.mitin.aircompany.entity.DiscountEntity;
import com.mitin.aircompany.model.Discount;

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
}
