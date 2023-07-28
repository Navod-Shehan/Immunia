package com.example.train.service;

import com.example.train.model.ReturnDate;

public interface ReturnDateService {
    void createOrUpdateReturnDate(ReturnDate returnDate);
    ReturnDate getReturnDate(Long id);

}
