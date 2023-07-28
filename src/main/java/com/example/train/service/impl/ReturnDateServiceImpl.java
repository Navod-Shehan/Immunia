package com.example.train.service.impl;

import com.example.train.model.Child;
import com.example.train.model.ReturnDate;
import com.example.train.model.VaccineRecord;
import com.example.train.repository.ReturnDateRepository;
import com.example.train.service.ReturnDateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReturnDateServiceImpl implements ReturnDateService {
    private final ReturnDateRepository returnDateRepository;

    @Override
    public void createOrUpdateReturnDate(ReturnDate newReturnDate) {
        Optional<ReturnDate>  exsistReturnDate = Optional.ofNullable(returnDateRepository.findByChild(newReturnDate.getChild()));

        if(exsistReturnDate.isPresent()){
            ReturnDate returnDate = exsistReturnDate.get();

            returnDate.setReturnDate(newReturnDate.getReturnDate());
            returnDate.setDosage(newReturnDate.getDosage());
            returnDate.setVaccineType(newReturnDate.getVaccineType());

            returnDateRepository.save(returnDate);
        } else{
            returnDateRepository.save(newReturnDate);
        }

    }
    public ReturnDate getReturnDate(Long id){
        log.info("Get {} return date from database",id);
        return returnDateRepository.findById(id).get();
    }

    public ReturnDate[] getReturnDateByChild(Long id){
        log.info("Get {} vaccination record from database");
        return returnDateRepository.findAll().stream().filter(vaccineRecord ->{
            Child child = vaccineRecord.getChild();
            if(child!=null){
                return child.getChildId().equals(id);
            }
            return false;

        } ).toArray(ReturnDate[]::new);
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
