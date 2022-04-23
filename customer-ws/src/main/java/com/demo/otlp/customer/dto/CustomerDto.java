package com.demo.otlp.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int addressId;
    private boolean active;
    private Date createDate;
    private Timestamp lastUpdate;

    private List<RentalDto> rentals = new ArrayList<>();
}
