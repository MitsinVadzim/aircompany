package com.mitin.aircompany.controller;

import com.mitin.aircompany.converter.RouteConverter;
import com.mitin.aircompany.model.Route;
import com.mitin.aircompany.repository.RouteRepository;
import com.mitin.aircompany.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final RouteRepository routeRepository;
    private final RouteConverter routeConverter;

    @Autowired
    public RouteController(RouteService routeService, RouteRepository routeRepository, RouteConverter routeConverter) {
        this.routeService = routeService;
        this.routeRepository = routeRepository;
        this.routeConverter = routeConverter;
    }

//    @GetMapping()
//    public List<Route> findAll(
//            @RequestParam("page") int page,
//            @RequestParam("size") int size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return routeService.findAll(pageable);
//    }

    @GetMapping()
    public List<Route> findAll(){
        return  routeConverter.convertToModel(routeRepository.findAll());
    }

    @GetMapping("{routeId}")
    public Route findById(@PathVariable("routeId") Long routeId) {
        return routeService.findById(routeId);
    }

    @GetMapping("place/{place}")
    public List<Route> findByPlace(@PathVariable("place") String place){
        return routeService.findByPlace(place);
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping()
    public Route save(@RequestBody Route route) {
        return routeService.save(route);
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{routeId}")
    public Route update(
            @RequestBody Route route,
            @PathVariable("routeId") Long routeId
    ) {
        return routeService.update(route, routeId);
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{routeId}")
    public void delete(
            @PathVariable("routeId") Long routeId
    ) {
        routeService.delete(routeId);
    }


}
