package com.example.train.service.impl;

import com.example.train.model.Admin;
import com.example.train.model.Child;
import com.example.train.repository.AdminRepository;
import com.example.train.service.AdminService;
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
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public Admin saveAdminUser(Admin admin){
        log.info("Saving admin {} to the database",admin.getFirstName());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
    public List<Admin> getAdminUsers(){
        log.info("Get all admins from database");
        return adminRepository.findAll();
    }
    public Admin getAdminUser(Long id){
        log.info("Get {} admin from database",id);
        return adminRepository.findById(id).get();
    }
    public void deleteAdminUser(Long id){
        log.info("Delete admin {} from database",id);
        adminRepository.deleteById(id);
    }

    public Admin updateAdmin(Long id, Admin admin){
        Admin existingAdmin = adminRepository.findById(id).get();

        if(Objects.nonNull(admin.getFirstName()) && !"".equalsIgnoreCase(admin.getFirstName())){
            existingAdmin.setFirstName(admin.getFirstName());
        } else if (Objects.nonNull(admin.getLastName()) && !"".equalsIgnoreCase(admin.getLastName())) {
            existingAdmin.setLastName(admin.getLastName());
        }
        else if (Objects.nonNull(admin.getContactNumber()) && !"".equalsIgnoreCase(admin.getContactNumber())) {
            existingAdmin.setContactNumber(admin.getContactNumber());
        }
        return adminRepository.save(existingAdmin);
    }
}
