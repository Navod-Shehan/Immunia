package com.example.train.service.impl;

import com.example.train.model.VaccineRecord;
import com.example.train.repository.VaccineRecordRepository;
import com.example.train.service.VaccineRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VaccineRecordServiceImpl implements VaccineRecordService {
    private final VaccineRecordRepository vaccineRecordRepository;

    public VaccineRecord saveVaccineRecord(VaccineRecord vaccineRecord){
        log.info("Saving vaccine record {} to the database");
        return vaccineRecordRepository.save(vaccineRecord);
    }

    public List<VaccineRecord> getVaccineRecords(){
        log.info("Get all vaccination records from database");
        return vaccineRecordRepository.findAll();
    }

    public VaccineRecord getVaccineRecord(Long id){
        log.info("Get {} vaccination record from database",id);
        return vaccineRecordRepository.findById(id).get();
    }
}
