package com.example.train.service;

import com.example.train.dto.WeightDTO;
import com.example.train.model.Child;
import com.example.train.model.VaccineRecord;

import java.util.List;

public interface VaccineRecordService {
    VaccineRecord saveVaccineRecord(VaccineRecord vaccineRecord);
    List<VaccineRecord> getVaccineRecords();
    VaccineRecord[] getVaccineRecordsByChild(Child child);
    VaccineRecord getVaccineRecord(Long id);

    VaccineRecord saveWeighRecord(WeightDTO weightDTO);
}
