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
public class VaccineRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vaccineRecordId;
    @Enumerated(EnumType.ORDINAL)
    private VaccineType vaccineType;
    private String dosage;
    private String location;
    private Date date;
    private Long weight;

    @ManyToOne
    @JoinColumn(name = "childId")
    private Child child;
}
