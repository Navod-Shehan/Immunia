package com.example.train.controller;

import com.example.train.model.AppUser;
import com.example.train.model.Donation;
import com.example.train.service.DonationService;
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

@Api(tags = "Donation")
@RestController
@RequestMapping("/api/donation")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    @ApiOperation(value = "all donations", notes = "Get all donations")
    @GetMapping("/")
    public ResponseEntity<List<Donation>> getDonations(){
        return ResponseEntity.ok().body(donationService.getDonations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonation(@PathVariable Long id){
        return new ResponseEntity<Donation>(donationService.getDonation(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Donation> saveDonation(@RequestBody Donation donation){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/donation/save").toUriString());
        return ResponseEntity.created(uri).body(donationService.saveDonation(donation));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Donation> updateDonation(@RequestBody Donation donation, @PathVariable Long id){
        try{
//            Student existingStudent = studentService.StudentGet(id);
            Donation donationNew = donationService.updateDonation(id,donation);
//            return new ResponseEntity<>(HttpStatus.OK);
            return ResponseEntity.ok().body(donationNew);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Donation>(HttpStatus.NOT_FOUND);
        }
    }
}
