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
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long childId;
    private String vaccinationCardNumber;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate DateOfBirth;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "id")
    private Parent parent;
}
