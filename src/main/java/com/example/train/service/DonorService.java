package com.example.train.service;

import com.example.train.model.Donation;
import com.example.train.model.Donor;
import com.example.train.model.Parent;

import java.util.List;

public interface DonorService {
    Donor saveDonor(Donor donor);
    List<Donor> getDonors();
    Donor getDonor(Long id);

    Donor updateDonor(Long id, Donor donor);
}
