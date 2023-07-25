package com.example.train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;
    private String startTime;
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "id")
    private VaccineCenter vaccineCenter;
}
