package com.example.train.service.impl;

import com.example.train.model.*;
import com.example.train.repository.DonationRepository;
import com.example.train.service.DonationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepository;

    public Donation saveDonation(Donation donation){
        log.info("Saving donation {} to the database",donation.getDonationId());
        return donationRepository.save(donation);
    }
    public List<Donation> getDonations(){
        log.info("Get all donations from database");
        return donationRepository.findAll();
    }
    public Donation getDonation(Long id){
        log.info("Get {} donation from database",id);
        return donationRepository.findById(id).get();
    }

    public Donation updateDonation(Long id, Donation donation){
        Donation existingDonation = donationRepository.findById(id).get();

        if(Objects.nonNull(donation.getDate()) && !"".equalsIgnoreCase(String.valueOf(donation.getDate()))){
            existingDonation.setDate(donation.getDate());
        } else if (Objects.nonNull(donation.getDescription()) && !"".equalsIgnoreCase(donation.getDescription())) {
            existingDonation.setDate(donation.getDate());
        }
        return donationRepository.save(existingDonation);
    }

}
