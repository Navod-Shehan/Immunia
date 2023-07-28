package com.example.train.service.impl;

import com.example.train.dto.WeightDTO;
import com.example.train.model.Child;
import com.example.train.model.Schedule;
import com.example.train.model.VaccineRecord;
import com.example.train.repository.VaccineRecordRepository;
import com.example.train.service.VaccineRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
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

    public VaccineRecord saveWeighRecord(WeightDTO weightDTO){
        log.info("Saving vaccine record {} to the database");
        VaccineRecord weightRecord = new VaccineRecord();
        weightRecord.setWeight(weightDTO.getWeight());
        weightRecord.setDate(weightDTO.getDate());
        weightRecord.setLocation(weightDTO.getLocation());
        weightRecord.setChild(weightDTO.getChild());
        vaccineRecordRepository.save(weightRecord);
        return weightRecord;
    }

    public List<VaccineRecord> getVaccineRecords(){
        log.info("Get all vaccination records from database");
        return vaccineRecordRepository.findAll();
    }

    public VaccineRecord getVaccineRecord(Long id){
        log.info("Get all vaccination records from database");
        return vaccineRecordRepository.findById(id).get();
    }

    public VaccineRecord[] getVaccineRecordsByChild(Long id){
        log.info("Get {} vaccination record from database");
        return vaccineRecordRepository.findAll().stream().filter(vaccineRecord -> vaccineRecord.getChild().getChildId().equals(id)).toArray(VaccineRecord[]::new);
    }



}
