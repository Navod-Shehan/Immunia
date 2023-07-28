package com.example.train.repository;

import com.example.train.model.Child;
import com.example.train.model.Schedule;
import com.example.train.model.VaccineRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface VaccineRecordRepository extends JpaRepository<VaccineRecord, Long> {

}
