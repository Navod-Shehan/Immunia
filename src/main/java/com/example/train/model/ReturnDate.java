package com.example.train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long returnDateId;
    private String vaccineType;
    private String dosage;
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "childId")
    private Child child;
}
