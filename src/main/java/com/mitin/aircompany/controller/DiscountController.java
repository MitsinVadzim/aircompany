package com.mitin.aircompany.controller;

import com.mitin.aircompany.model.Discount;
import com.mitin.aircompany.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

//    @GetMapping
//    public List<Discount> findAll(
//            @RequestParam("page") int page,
//            @RequestParam("size") int size
//    ){
//        Pageable pageable = PageRequest.of(page, size);
//        return discountService.findAll(pageable);
//    }

    @GetMapping
    public List<Discount> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return discountService.findAll(pageable);
    }

    @GetMapping("{discountId}")
    public Discount findById(@PathVariable("discountId") Long discountId){
        return discountService.findById(discountId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public Discount save(
            @RequestBody Discount discount,
            @RequestParam("routeIds") List<Long> routeEntityIds
    ){
        return discountService.save(discount, routeEntityIds);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{discountId}")
    public Discount update(
            @RequestBody Discount discount,
            @PathVariable("discountId") Long discountId,
            @RequestParam("routeIds") List<Long> routeEntityIds
    ){
        return discountService.update(discount, discountId, routeEntityIds);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{discountId}")
    public void delete(
        @PathVariable("discountId") Long discountId
    ){
        discountService.delete(discountId);
    }
}
