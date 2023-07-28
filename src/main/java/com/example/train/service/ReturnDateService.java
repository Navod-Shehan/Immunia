package com.example.train.service;

import com.example.train.model.ReturnDate;
import com.example.train.model.VaccineRecord;

public interface ReturnDateService {
    void createOrUpdateReturnDate(ReturnDate returnDate);
    ReturnDate getReturnDate(Long id);
    ReturnDate[] getReturnDateByChild(Long id);
}
