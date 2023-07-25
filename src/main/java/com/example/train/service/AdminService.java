package com.example.train.service;

import com.example.train.model.Admin;
import com.example.train.model.AppUser;
import com.example.train.model.Child;

import java.util.List;

public interface AdminService {
    Admin saveAdminUser(Admin admin);
    List<Admin> getAdminUsers();
    Admin getAdminUser(Long id);
    void deleteAdminUser(Long id);

    Admin updateAdmin(Long id, Admin admin);
}
