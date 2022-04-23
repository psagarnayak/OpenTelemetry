package com.demo.otlp.customer.service;

import com.demo.otlp.customer.dao.CustomerRepo;
import com.demo.otlp.customer.dto.CustomerDto;
import com.demo.otlp.customer.dto.RentalDto;
import com.demo.otlp.customer.entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    private RestTemplate restTemplate;
    private CustomerRepo customerRepo;
    private ModelMapper modelMapper;

    private static final String RENTAL_SERVICE_URL = "http://localhost:8081/rentals?customerId=%s";

    public CustomerService(RestTemplate restTemplate, CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    public List<CustomerDto> fetchAll(){

        List<Customer> customers = this.customerRepo.findAll();
        List<CustomerDto> customerDtos = modelMapper.map(customers, new TypeToken<List<CustomerDto>>() {
        }.getType());

        customerDtos.stream().forEach(this::enrichWithRentalInfo);

        return customerDtos;
    }


    public CustomerDto fetchById(long id){
        Customer customer = this.customerRepo.findById(id).orElse(null);
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        enrichWithRentalInfo(customerDto);
        return customerDto;
    }

    public List<CustomerDto> findByFirstName(String name) {
        List<Customer> customers = this.customerRepo.findByFirstNameContainingIgnoreCase(name);
        List<CustomerDto> customerDtos = modelMapper.map(customers, new TypeToken<List<CustomerDto>>() { }.getType());
        customerDtos.stream().forEach(this::enrichWithRentalInfo);
        return customerDtos;
    }

    private void enrichWithRentalInfo(CustomerDto customerDto) {
        String url = String.format(RENTAL_SERVICE_URL, Long.toString(customerDto.getId()));
        List<RentalDto> rentalDtos = Arrays.asList(restTemplate.getForObject(url, RentalDto[].class));
        customerDto.setRentals(rentalDtos);
    }
}
