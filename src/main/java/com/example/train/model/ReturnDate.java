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
public class ReturnDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long returnDateId;
    @Enumerated(EnumType.ORDINAL)
    private VaccineType vaccineType;
    private String dosage;
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "childId")
    private Child child;
}
