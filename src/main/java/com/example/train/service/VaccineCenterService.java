package com.example.train.service;

import com.example.train.model.Schedule;
import com.example.train.model.VaccineCenter;

import java.util.List;

public interface VaccineCenterService {
    VaccineCenter saveVaccineCenterUser(VaccineCenter vaccineCenter);
    List<VaccineCenter> getVaccineCenterUsers();
    VaccineCenter getVaccineCenterUser(Long id);
    void deleteVaccineCenterUser(Long id);

    VaccineCenter updateVaccineCenter(Long id, VaccineCenter vaccineCenter);
}
