package com.mitin.aircompany.service;

import com.mitin.aircompany.exception.DiscountNotFoundException;
import com.mitin.aircompany.model.Discount;
import com.mitin.aircompany.repository.DiscountRepository;
import com.mitin.aircompany.util.DiscountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> findAll(Pageable pageable){
        return DiscountConverter.convertToModel(discountRepository.findAll(pageable).getContent());
    }

    public Discount findById(Long discountId){
        return DiscountConverter.convertToModel(discountRepository.findById(discountId).orElseThrow(() -> new DiscountNotFoundException(discountId)));
    }

    public Discount save(Discount discount){

    }
}
