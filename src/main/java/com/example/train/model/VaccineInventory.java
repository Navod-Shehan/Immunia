package com.example.train.model;

import com.example.train.enums.VaccineType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;
    private Long batchNumber;
    private int quantity;
    private VaccineType vaccineType;
    private Date manufactureDate;
    private Date expireDate;
    private String manufacturer;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id")
    private VaccineCenter vaccineCenter;
}
