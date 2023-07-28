package com.example.train.dto;

import com.example.train.model.Child;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightDTO {
    private Long weight;
    private Date date;
    private String location;
    private Child child;
}
