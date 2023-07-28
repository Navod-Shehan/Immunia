package com.example.train.service;

import com.example.train.model.VaccineRecord;

import java.util.List;

public interface VaccineRecordService {
    VaccineRecord saveVaccineRecord(VaccineRecord vaccineRecord);
    List<VaccineRecord> getVaccineRecords();
    VaccineRecord getVaccineRecord(Long id);
}
