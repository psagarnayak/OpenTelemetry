package com.demo.otlp.rental.service;

import com.demo.otlp.rental.dao.RentalRepo;
import com.demo.otlp.rental.entity.Rental;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private RentalRepo rentalRepo;

    public RentalService(RentalRepo rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    public List<Rental> fetchAllRentals(){
        return rentalRepo.findAll();
    }

    public List<Rental> fetchRentalByCustomerId(int customerId){
        return this.rentalRepo.findByCustomerId(customerId);
    }

}
