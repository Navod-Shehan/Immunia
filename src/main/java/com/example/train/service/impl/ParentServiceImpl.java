package com.example.train.service.impl;

import com.example.train.model.AppUser;
import com.example.train.model.Donor;
import com.example.train.model.Parent;
import com.example.train.repository.ParentRepository;
import com.example.train.service.ParentService;
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
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final PasswordEncoder passwordEncoder;

    public Parent saveParentUser(Parent parent){
        log.info("Saving parent {} to the database",parent.getFirstName());
        parent.setPassword(passwordEncoder.encode(parent.getPassword()));
        parent.setUserRole("parent"); // Set the userRole as "parent"
        return parentRepository.save(parent);
    }
    public List<Parent> getParentUsers(){
        log.info("Get all parents from database");
        return parentRepository.findAll();
    }
    public Parent getParentUser(Long id){
        log.info("Get {} user from database",id);
        return parentRepository.findById(id).get();
    }
    public void deleteParentUser(Long id){
        log.info("Delete user {} from database",id);
        parentRepository.deleteById(id);
    }

    public Parent updateParent(Long id, Parent parent){
        Parent  existingParent = parentRepository.findById(id).get();

        if(Objects.nonNull(parent.getFirstName()) && !"".equalsIgnoreCase(parent.getFirstName())){
            existingParent.setFirstName(parent.getFirstName());
        } else if (Objects.nonNull(parent.getLastName()) && !"".equalsIgnoreCase(parent.getLastName())) {
            existingParent.setLastName(parent.getLastName());
        } else if (Objects.nonNull(parent.getAddress()) && !"".equalsIgnoreCase(parent.getAddress())) {
            existingParent.setAddress(parent.getAddress());
        }else if (Objects.nonNull(parent.getNICNumber()) && !"".equalsIgnoreCase(parent.getNICNumber())) {
            existingParent.setNICNumber(parent.getNICNumber());
        }else if (Objects.nonNull(parent.getEmergencyContactNumber()) && !"".equalsIgnoreCase(parent.getEmergencyContactNumber())) {
            existingParent.setEmergencyContactNumber(parent.getEmergencyContactNumber());
        }
        return parentRepository.save(existingParent);
    }
}
