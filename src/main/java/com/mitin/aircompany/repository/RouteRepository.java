package com.mitin.aircompany.repository;

import com.mitin.aircompany.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
}
