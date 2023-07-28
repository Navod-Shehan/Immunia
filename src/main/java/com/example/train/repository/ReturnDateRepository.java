package com.example.train.repository;

import com.example.train.model.Child;
import com.example.train.model.ReturnDate;
import com.example.train.model.VaccineRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnDateRepository extends JpaRepository<ReturnDate, Long> {
    ReturnDate findByChild(Child child);
}
