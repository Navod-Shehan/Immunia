package com.example.train.service.impl;

import com.example.train.model.ReturnDate;
import com.example.train.repository.ReturnDateRepository;
import com.example.train.service.ReturnDateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReturnDateServiceImpl implements ReturnDateService {
    private final ReturnDateRepository returnDateRepository;

    @Override
    public void createOrUpdateReturnDate(ReturnDate returnDate) {
        // Check if the ReturnDate table is empty
        if (returnDateRepository.count() == 0) {
            returnDateRepository.save(returnDate);
        } else {
            // Get the existing ReturnDate entity (assuming there is only one)
            ReturnDate existingReturnDate = returnDateRepository.findAll().get(0);

            // Update the existing ReturnDate entity with the values from the input ReturnDate
            existingReturnDate.setVaccineType(returnDate.getVaccineType());
            existingReturnDate.setDosage(returnDate.getDosage());
            existingReturnDate.setReturnDate(returnDate.getReturnDate());

            // Save the updated ReturnDate entity
            returnDateRepository.save(existingReturnDate);
        }
    }
    public ReturnDate getReturnDate(Long id){
        log.info("Get {} return date from database",id);
        return returnDateRepository.findById(id).get();
    }

    public ReturnDate updateReturnDate(Long id, ReturnDate returnDate){
        ReturnDate existingReturnDate = returnDateRepository.findById(id).get();

        if(Objects.nonNull(returnDate.getReturnDate())){
            existingReturnDate.setReturnDate(returnDate.getReturnDate());
        } else if (Objects.nonNull(returnDate.getVaccineType())) {
            existingReturnDate.setVaccineType(returnDate.getVaccineType());
        } else if (Objects.nonNull(returnDate.getDosage())) {
            existingReturnDate.setDosage(returnDate.getDosage());
        }
        return returnDateRepository.save(existingReturnDate);
    }
}
