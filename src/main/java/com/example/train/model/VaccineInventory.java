package com.example.train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long batchNumber;
    private int quantity;
    private String vaccinationType;
    private Date manufactureDate;
    private Date expireDate;
    private String manufacturer;
    private String description;
}
