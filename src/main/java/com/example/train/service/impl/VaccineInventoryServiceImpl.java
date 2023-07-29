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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VaccineInventoryServiceImpl implements VaccineInventoryService {
    private final VaccineInventoryRepository vaccineInventoryRepository;

    public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInventory){
        log.info("Saving vaccine inventory {} to the database",vaccineInventory.getVaccineType());
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

    public Boolean decreaseVaccineInventory(Long id){

        // First, fetch the vaccine from the repository using the provided ID
        Optional<VaccineInventory> optionalVaccineInventory = vaccineInventoryRepository.findById(id);

// Check if the vaccine with the given ID exists in the repository
        if (optionalVaccineInventory.isPresent()) {
            // Get the Vaccine object from the Optional
            VaccineInventory vaccineInventory = optionalVaccineInventory.get();

            // Get the current quantity of the vaccine
            int currentQuantity = vaccineInventory.getQuantity();

            // Decrease the quantity by one
            int newQuantity = currentQuantity - 1;

            // Set the new quantity back to the Vaccine object
            vaccineInventory.setQuantity(newQuantity);

            // Save the updated Vaccine object back to the repository
            vaccineInventoryRepository.save(vaccineInventory);
            return true;
        }

        return false;
    }

    public VaccineInventory updateVaccineInventory(Long id, VaccineInventory vaccineInventory){
        VaccineInventory  existingVaccineInventory = vaccineInventoryRepository.findById(id).get();

        if(Objects.nonNull(vaccineInventory.getQuantity()) ){
            existingVaccineInventory.setQuantity(vaccineInventory.getQuantity());
        } else if (Objects.nonNull(vaccineInventory.getVaccineType())) {
            existingVaccineInventory.setVaccineType(vaccineInventory.getVaccineType());
        }else if (Objects.nonNull(vaccineInventory.getManufactureDate())) {
            existingVaccineInventory.setManufactureDate(vaccineInventory.getManufactureDate());
        }else if (Objects.nonNull(vaccineInventory.getExpireDate())) {
            existingVaccineInventory.setExpireDate(vaccineInventory.getExpireDate());
        }else if (Objects.nonNull(vaccineInventory.getManufacturer())) {
            existingVaccineInventory.setManufacturer(vaccineInventory.getManufacturer());
        }else if (Objects.nonNull(vaccineInventory.getDescription())) {
            existingVaccineInventory.setDescription(vaccineInventory.getDescription());
        }
        return vaccineInventoryRepository.save(existingVaccineInventory);
    }


}
