package com.example.train.controller;

import com.example.train.model.Admin;
import com.example.train.model.Child;
import com.example.train.model.Parent;
import com.example.train.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@Api(tags = "Admin")
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @ApiOperation(value = "all admins", notes = "Get all admins")
    @GetMapping("/")
    public ResponseEntity<List<Admin>> getAdminUsers(){
        return ResponseEntity.ok().body(adminService.getAdminUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminUser(@PathVariable Long id){
        return new ResponseEntity<Admin>(adminService.getAdminUser(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdminUser(@RequestBody Admin admin){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/admin/save").toUriString());
        return ResponseEntity.created(uri).body(adminService.saveAdminUser(admin));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable Long id){
        try{
//            Student existingStudent = studentService.StudentGet(id);
            Admin adminNew = adminService.updateAdmin(id,admin);
//            return new ResponseEntity<>(HttpStatus.OK);
            return ResponseEntity.ok().body(adminNew);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdminUser(@PathVariable Long id){
        adminService.deleteAdminUser(id);
        return "Deleted admin with id "+id;
    }
}
