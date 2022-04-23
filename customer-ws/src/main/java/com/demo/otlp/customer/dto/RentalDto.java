package com.demo.otlp.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RentalDto {

    private long id;
    private int customerId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;
}
