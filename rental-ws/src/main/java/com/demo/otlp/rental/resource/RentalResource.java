package com.demo.otlp.rental.resource;

import com.demo.otlp.rental.entity.Rental;
import com.demo.otlp.rental.service.RentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentalResource {

    private RentalService rentalService;

    public RentalResource(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/rentals")
    public List<Rental> fetchRentals(@RequestParam(name = "customerId", required = false) Integer customerId) {

        return customerId == null ? this.rentalService.fetchAllRentals() : this.rentalService.fetchRentalByCustomerId(customerId);
    }
}
