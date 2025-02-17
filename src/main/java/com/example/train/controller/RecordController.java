package com.example.train.controller;

import com.example.train.dto.VaccineRecordDTO;
import com.example.train.dto.WeightDTO;
import com.example.train.model.Child;
import com.example.train.model.ReturnDate;
import com.example.train.model.VaccineRecord;
import com.example.train.service.ChildService;
import com.example.train.service.ReturnDateService;
import com.example.train.service.VaccineRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(tags = "Schedule")
@RestController
@RequestMapping("/api/records")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class RecordController {
    private final VaccineRecordService vaccineRecordService;
    private  final ReturnDateService returnDateService;
    private final ChildService childService;

    @ApiOperation(value = "all records", notes = "Get all records")
    @GetMapping("/")
    public ResponseEntity<List<VaccineRecord>> getRecords(){
        return  ResponseEntity.ok().body(vaccineRecordService.getVaccineRecords());
    }

    @GetMapping("/vaccineRecord/{id}")
    public ResponseEntity<VaccineRecord> getVaccineRecord(@PathVariable Long id){
        return new ResponseEntity<VaccineRecord>(vaccineRecordService.getVaccineRecord(id), HttpStatus.OK);
    }

    @GetMapping("/vaccineRecordByChild/{id}")
    public VaccineRecord[] getVaccineRecordsByChild(@PathVariable Long id){
        return vaccineRecordService.getVaccineRecordsByChild(id);
    }

    @GetMapping("/returnDateByChild/{id}")
    public ReturnDate[] getReturnDateByChild(@PathVariable Long id){
        return returnDateService.getReturnDateByChild(id);
    }

    @PostMapping("/vaccineRecord/save")
    public ResponseEntity<VaccineRecord> saveVaccineRecord(@RequestBody VaccineRecord vaccineRecord){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/records/vaccineRecord/save").toUriString());
        return ResponseEntity.created(uri).body(vaccineRecordService.saveVaccineRecord(vaccineRecord));
    }

    @PostMapping("/weightRecord/submit")
    public ResponseEntity<VaccineRecord> saveWeightRecords(@RequestBody WeightDTO weightDTO){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/records/weightRecord/submit").toUriString());
        return ResponseEntity.created(uri).body(vaccineRecordService.saveWeighRecord(weightDTO));
    }

    @PostMapping("/vaccineRecord/submit")
    public ResponseEntity<VaccineRecordDTO> submitVaccineRecord(@RequestBody VaccineRecordDTO vaccineRecordDTO){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/records/vaccineRecord/submit").toUriString());
        vaccineRecordService.saveVaccineRecord(vaccineRecordDTO.getVaccineRecord());
        returnDateService.createOrUpdateReturnDate(vaccineRecordDTO.getReturnDate());

        return ResponseEntity.ok().body(vaccineRecordDTO);
    }

    @GetMapping("/returnDate/{id}")
    public ResponseEntity<ReturnDate> getReturnDate(@PathVariable Long id){
        return new ResponseEntity<ReturnDate>(returnDateService.getReturnDate(id), HttpStatus.OK);
    }

    @PostMapping("/returnDate/saveOrUpdate/{id}")
    public ResponseEntity<ReturnDate> saveOrUpdateReturnDate(@PathVariable Long id, @RequestBody ReturnDate returnDate) {
        Child child = childService.getChild(id);
        if (child == null) {
            return ResponseEntity.notFound().build();
        }

        returnDate.setChild(child);
        returnDateService.createOrUpdateReturnDate(returnDate);
        return ResponseEntity.ok().body(returnDate);
    }

}
