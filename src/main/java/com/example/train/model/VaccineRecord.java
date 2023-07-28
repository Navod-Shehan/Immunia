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
public class VaccineRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vaccineRecordId;
    private String vaccineType;
    private String dosage;
    private String location;
    private Date date;
    private String month;
    private Long weight;

    @ManyToOne
    @JoinColumn(name = "childId")
    private Child child;
}
