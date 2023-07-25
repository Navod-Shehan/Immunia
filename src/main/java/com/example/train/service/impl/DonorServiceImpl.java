package com.example.train.service.impl;

import com.example.train.model.Donation;
import com.example.train.model.Donor;
import com.example.train.repository.DonorRepository;
import com.example.train.service.DonorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DonorServiceImpl implements DonorService{
    private final DonorRepository donorRepository;

    public Donor saveDonor(Donor donor){
        log.info("Saving donor {} to the database", donor.getDonorName());
        return donorRepository.save(donor);
    }
    public List<Donor> getDonors(){
        log.info("Get all donor from database");
        return donorRepository.findAll();
    }
    public Donor getDonor(Long id){
        log.info("Get {} user from database",id);
        return donorRepository.findById(id).get();
    }

    public Donor updateDonor(Long id, Donor donor){
        Donor existingDonor = donorRepository.findById(id).get();

        if(Objects.nonNull(donor.getDonorName()) && !"".equalsIgnoreCase(String.valueOf(donor.getDonorName()))){
            existingDonor.setDonorName(donor.getDonorName());
        } else if (Objects.nonNull(donor.getDonorName()) && !"".equalsIgnoreCase(donor.getDonorName())) {
            existingDonor.setDonorName(donor.getDonorName());
        }
        return donorRepository.save(existingDonor);
    }
}
