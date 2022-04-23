package com.demo.otlp.rental.dao;

import com.demo.otlp.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RentalRepo extends JpaRepository<Rental, Long> {
    public List<Rental> findByCustomerId(int id);
}
