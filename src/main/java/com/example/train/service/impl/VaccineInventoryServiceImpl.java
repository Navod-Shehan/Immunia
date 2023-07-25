package com.example.train.service.impl;

import com.example.train.model.Parent;
import com.example.train.model.VaccineCenter;
import com.example.train.model.VaccineInventory;
import com.example.train.repository.VaccineInventoryRepository;
import com.example.train.service.VaccineInventoryService;
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
public class VaccineInventoryServiceImpl implements VaccineInventoryService {
    private final VaccineInventoryRepository vaccineInventoryRepository;

    public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInventory){
        log.info("Saving vaccine inventory {} to the database",vaccineInventory.getVaccinationType());
        return vaccineInventoryRepository.save(vaccineInventory);
    }
    public List<VaccineInventory> getVaccineInventories(){
        log.info("Get all inventories from database");
        return vaccineInventoryRepository.findAll();
    }
    public VaccineInventory getVaccineInventory(Long id){
        log.info("Get {} inventory from database",id);
        return vaccineInventoryRepository.findById(id).get();
    }
    public void deleteVaccineInventory(Long id){
        log.info("Delete inventory {} from database",id);
        vaccineInventoryRepository.deleteById(id);
    }

    public VaccineInventory updateVaccineInventory(Long id, VaccineInventory vaccineInventory){
        VaccineInventory  existingVaccineInventory = vaccineInventoryRepository.findById(id).get();

        if(Objects.nonNull(vaccineInventory.getQuantity()) && !"".equalsIgnoreCase(String.valueOf(vaccineInventory.getQuantity()))){
            existingVaccineInventory.setQuantity(vaccineInventory.getQuantity());
        } else if (Objects.nonNull(vaccineInventory.getVaccinationType()) && !"".equalsIgnoreCase(vaccineInventory.getVaccinationType())) {
            existingVaccineInventory.setVaccinationType(vaccineInventory.getVaccinationType());
        }else if (Objects.nonNull(vaccineInventory.getManufactureDate()) && !"".equalsIgnoreCase(String.valueOf(vaccineInventory.getManufactureDate()))) {
            existingVaccineInventory.setManufactureDate(vaccineInventory.getManufactureDate());
        }else if (Objects.nonNull(vaccineInventory.getExpireDate()) && !"".equalsIgnoreCase(String.valueOf(vaccineInventory.getExpireDate()))) {
            existingVaccineInventory.setExpireDate(vaccineInventory.getExpireDate());
        }else if (Objects.nonNull(vaccineInventory.getManufacturer()) && !"".equalsIgnoreCase(String.valueOf(vaccineInventory.getManufacturer()))) {
            existingVaccineInventory.setManufacturer(vaccineInventory.getManufacturer());
        }else if (Objects.nonNull(vaccineInventory.getDescription()) && !"".equalsIgnoreCase(String.valueOf(vaccineInventory.getDescription()))) {
            existingVaccineInventory.setDescription(vaccineInventory.getDescription());
        }
        return vaccineInventoryRepository.save(existingVaccineInventory);
    }
}
