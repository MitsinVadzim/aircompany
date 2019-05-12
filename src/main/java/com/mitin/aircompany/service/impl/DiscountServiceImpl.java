package com.mitin.aircompany.service.impl;

import com.mitin.aircompany.exception.DiscountNotFoundException;
import com.mitin.aircompany.model.Discount;
import com.mitin.aircompany.repository.DiscountRepository;
import com.mitin.aircompany.entity.DiscountEntity;
import com.mitin.aircompany.entity.RouteEntity;
import com.mitin.aircompany.repository.RouteRepository;
import com.mitin.aircompany.service.DiscountService;
import com.mitin.aircompany.converter.DiscountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public DiscountServiceImpl(DiscountRepository discountRepository, RouteRepository routeRepository) {
        this.discountRepository = discountRepository;
        this.routeRepository = routeRepository;
    }


    @Override
    public List<Discount> findAll(Pageable pageable){
        return DiscountConverter.convertToModel(discountRepository.findAll(pageable).getContent());
    }

    @Override
    @Transactional
    public Discount findById(Long discountId) {
        return DiscountConverter.convertToModel(discountRepository.findById(discountId)
                .orElseThrow(() -> new DiscountNotFoundException(discountId)));
    }

    @Override
    @Transactional
    public Discount save(Discount discount, List<Long> routeEntityIds){
        List<RouteEntity> routeEntities = routeRepository.findAllById(routeEntityIds);
        DiscountEntity discountEntity = DiscountConverter.convertToEntity(discount);
        discountEntity.setRoutes(new HashSet<>(routeEntities));
        return DiscountConverter.convertToModel(discountRepository.save(discountEntity));
    }

    @Override
    @Transactional
    public Discount update(Discount discount, Long discountId, List<Long> routeEntityIds) {
        DiscountEntity existingDiscount = discountRepository.findById(discountId)
                .orElseThrow(() -> new DiscountNotFoundException(discountId));
        List<RouteEntity> routeEntities = routeRepository.findAllById(routeEntityIds);
        DiscountEntity toUpdate = DiscountConverter.update(existingDiscount, discount, routeEntities);
        return DiscountConverter.convertToModel(discountRepository.save(toUpdate));
    }

    @Override
    @Transactional
    public void delete(Long discountId) {
        discountRepository.deleteById(discountId);
    }
}
