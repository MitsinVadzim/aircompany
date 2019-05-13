package com.mitin.aircompany.controller;

import com.mitin.aircompany.converter.DiscountConverter;
import com.mitin.aircompany.model.Discount;
import com.mitin.aircompany.repository.DiscountRepository;
import com.mitin.aircompany.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;
    private final DiscountConverter discountConverter;
    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountController(DiscountService discountService, DiscountConverter discountConverter, DiscountRepository discountRepository) {
        this.discountService = discountService;
        this.discountConverter = discountConverter;
        this.discountRepository = discountRepository;
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
    ){
        return discountConverter.convertToModel(discountRepository.findAll());
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
