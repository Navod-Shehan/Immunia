package com.example.train.service.impl;

import com.example.train.model.Schedule;
import com.example.train.model.VaccineCenter;
import com.example.train.repository.VaccineCenterRepository;
import com.example.train.service.VaccineCenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VaccineCenterImpl implements VaccineCenterService {
    private final VaccineCenterRepository vaccineCenterRepository;
    private final PasswordEncoder passwordEncoder;
    public VaccineCenter saveVaccineCenterUser(VaccineCenter vaccineCenter){
        log.info("Saving Vaccine Center {} to the database", vaccineCenter.getCenterName());
        vaccineCenter.setPassword(passwordEncoder.encode(vaccineCenter.getPassword()));
        vaccineCenter.setUserRole("vaccine_center");
        return vaccineCenterRepository.save(vaccineCenter);
    }

    public List<VaccineCenter> getVaccineCenterUsers(){
        log.info("Get all centers from database");
        return vaccineCenterRepository.findAll();
    }
    public VaccineCenter getVaccineCenterUser(Long id){
        log.info("Get {} user from database",id);
        return vaccineCenterRepository.findById(id).get();
    }
    public void deleteVaccineCenterUser(Long id){
        log.info("Delete user {} from database",id);
        vaccineCenterRepository.deleteById(id);
    }

    public VaccineCenter updateVaccineCenter(Long id, VaccineCenter vaccineCenter){
        VaccineCenter  existingVaccineCenter = vaccineCenterRepository.findById(id).get();

        if(Objects.nonNull(vaccineCenter.getCenterType()) && !"".equalsIgnoreCase(vaccineCenter.getCenterType())){
            existingVaccineCenter.setCenterType(vaccineCenter.getCenterType());
        } else if (Objects.nonNull(vaccineCenter.getCenterAddress()) && !"".equalsIgnoreCase(vaccineCenter.getCenterAddress())) {
            existingVaccineCenter.setCenterAddress(vaccineCenter.getCenterAddress());
        }else if (Objects.nonNull(vaccineCenter.getCenterName()) && !"".equalsIgnoreCase(vaccineCenter.getCenterName())) {
            existingVaccineCenter.setCenterName(vaccineCenter.getCenterName());
        }else if (Objects.nonNull(vaccineCenter.getProvince()) && !"".equalsIgnoreCase(vaccineCenter.getProvince())) {
            existingVaccineCenter.setProvince(vaccineCenter.getProvince());
        }
        return vaccineCenterRepository.save(existingVaccineCenter);
    }
}
