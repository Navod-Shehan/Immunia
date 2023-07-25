package com.example.train.controller;

import com.example.train.model.Donor;
import com.example.train.model.Schedule;
import com.example.train.service.DonorService;
import com.example.train.service.ScheduleService;
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
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @ApiOperation(value = "all schedules", notes = "Get all schedules")
    @GetMapping("/")
    public ResponseEntity<List<Schedule>> getSchedules(){
        return ResponseEntity.ok().body(scheduleService.getSchedules());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id){
        return new ResponseEntity<Schedule>(scheduleService.getSchedule(id), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/schedule/save").toUriString());
        return ResponseEntity.created(uri).body(scheduleService.saveSchedule(schedule));
    }
}
