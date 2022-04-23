package com.demo.otlp.customer.resource;

import com.demo.otlp.customer.dto.CustomerDto;
import com.demo.otlp.customer.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerResource {

    private CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDto> fetchAll(@RequestParam(name = "firstName", required = false) String firstName){
        return StringUtils.isNotBlank(firstName) ?
                this.customerService.findByFirstName(firstName) : this.customerService.fetchAll();
    }

    @GetMapping("/customers/{id}")
    public CustomerDto findByID(@PathVariable("id") Long id){
        return this.customerService.fetchById(id);
    }
}
