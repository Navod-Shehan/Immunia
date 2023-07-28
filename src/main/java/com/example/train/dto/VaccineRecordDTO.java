package com.example.train.dto;

import com.example.train.model.ReturnDate;
import com.example.train.model.VaccineRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineRecordDTO {
    private VaccineRecord vaccineRecord;
    private ReturnDate returnDate;
}
