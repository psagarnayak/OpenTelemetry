package com.demo.otlp.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name="customer_id")
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private int addressId;

    @Column(name="activebool")
    private boolean active;

    private Date createDate;

    private Timestamp lastUpdate;
}
