package com.mitin.aircompany.controller;

import com.mitin.aircompany.model.Discount;
import com.mitin.aircompany.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/discounts")
    public List<Discount> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return discountService.findAll(pageable);
    }

    @GetMapping("/discounts/{discountid}")
    public Discount findById(@PathVariable("discountid") Long discountId){
        return discountService.findById(discountId);
    }
}
