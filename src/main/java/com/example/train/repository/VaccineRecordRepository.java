package com.example.train.repository;

import com.example.train.model.VaccineRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRecordRepository extends JpaRepository<VaccineRecord, Long> {
}
