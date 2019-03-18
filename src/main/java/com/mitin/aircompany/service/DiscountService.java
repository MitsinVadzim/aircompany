package com.mitin.aircompany.service;

import com.mitin.aircompany.entity.DiscountEntity;
import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.exception.DiscountNotFoundException;
import com.mitin.aircompany.model.Discount;
import com.mitin.aircompany.repository.DiscountRepository;
import com.mitin.aircompany.repository.RouteRepository;
import com.mitin.aircompany.util.DiscountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository, RouteRepository routeRepository) {
        this.discountRepository = discountRepository;
        this.routeRepository = routeRepository;
    }

    public List<Discount> findAll(Pageable pageable){
        return DiscountConverter.convertToModel(discountRepository.findAll(pageable).getContent());
    }

    public Discount findById(Long discountId){
        return DiscountConverter.convertToModel(discountRepository.findById(discountId).orElseThrow(() -> new DiscountNotFoundException(discountId)));
    }

    public Discount save(Discount discount, String fromPlace, String toPlace){
        List<RouteEntity> routeEntities;
        if(toPlace.equals("")){
            routeEntities = routeRepository.findByFromPlaceAfter(fromPlace);
        }else {
            routeEntities = routeRepository.findByFromPlaceAfterAndToPlaceBefore(fromPlace, toPlace);
        }
        DiscountEntity discountEntity = DiscountConverter.convertToEntity(discount);
        discountEntity.setRoutes(new HashSet<>(routeEntities));
        return DiscountConverter.convertToModel(discountRepository.save(discountEntity));
    }
}
