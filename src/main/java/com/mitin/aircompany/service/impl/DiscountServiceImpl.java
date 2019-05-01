package com.mitin.aircompany.service.impl;

import com.mitin.aircompany.exception.DiscountNotFoundException;
import com.mitin.aircompany.model.Discount;
import com.mitin.aircompany.repository.DiscountRepository;
import com.mitin.aircompany.service.DiscountService;
import com.mitin.aircompany.util.DiscountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    @Transactional
    public List<Discount> findAll(Pageable pageable){
        return DiscountConverter.convertToModel(discountRepository.findAll(pageable).getContent());
    }

    @Override
    @Transactional
    public Discount findById(Long discountId){
        return DiscountConverter.convertToModel(discountRepository.findById(discountId)
                .orElseThrow(() -> new DiscountNotFoundException(discountId)));
    }
}
