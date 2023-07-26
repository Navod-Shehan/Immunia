package com.example.train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentId;
    private String vaccinationName;
    private String parentName;
    private String vaccinationCardNumber;
    private Boolean status;
    private String childName;
    private String vaccinationCenter;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "vaccineCenterId", referencedColumnName = "id")
    private VaccineCenter vaccineCenter;


    @ManyToOne
    @JoinColumn(name = "childId", referencedColumnName = "childId")
    private Child child;

    @OneToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;


}
