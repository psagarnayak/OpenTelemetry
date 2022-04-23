package com.demo.otlp.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue
    @Column(name = "rental_id")
    private long id;

    private int customerId;

    private Timestamp rentalDate;

    private Timestamp returnDate;

    private Timestamp lastUpdate;
}
