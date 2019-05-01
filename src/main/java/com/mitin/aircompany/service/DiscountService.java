package com.mitin.aircompany.service;

import com.mitin.aircompany.model.Discount;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {
    List<Discount> findAll(Pageable pageable);

    Discount findById(Long discountId);
}
