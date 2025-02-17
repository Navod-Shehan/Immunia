package com.example.train.controller;

import com.example.train.model.Donation;
import com.example.train.model.Donor;
import com.example.train.service.DonorService;
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

@Api(tags = "Donor")
@RestController
@RequestMapping("/api/donor")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DonorController {
    private final DonorService donorService;
    @ApiOperation(value = "all donors", notes = "Get all donors")
    @GetMapping("/")
    public ResponseEntity<List<Donor>> getDonors(){
        return ResponseEntity.ok().body(donorService.getDonors());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonor(@PathVariable Long id){
        return new ResponseEntity<Donor>(donorService.getDonor(id), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Donor> saveDonor(@RequestBody Donor donor){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/donor/save").toUriString());
        return ResponseEntity.created(uri).body(donorService.saveDonor(donor));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Donor> updateDonar(@RequestBody Donor donor, @PathVariable Long id){
        try{
//            Student existingStudent = studentService.StudentGet(id);
            Donor donorNew = donorService.updateDonor(id,donor);
//            return new ResponseEntity<>(HttpStatus.OK);
            return ResponseEntity.ok().body(donorNew);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Donor>(HttpStatus.NOT_FOUND);
        }
    }
}
