package com.example.train.controller;

import com.example.train.model.Child;
import com.example.train.service.ChildService;
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

@Api(tags = "Child")
@RestController
@RequestMapping("/api/child")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService childService;
    @ApiOperation(value = "all children", notes = "Get all children")
    @GetMapping("/")
    public ResponseEntity<List<Child>> getChildren(){
        return ResponseEntity.ok().body(childService.getChildren());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Child> getChild(@PathVariable Long id){
        return new ResponseEntity<Child>(childService.getChild(id), HttpStatus.OK);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<Child> getChildWithAppointments(@PathVariable Long id){
        return new ResponseEntity<Child>(childService.getChildWithAppointments(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Child> saveChild(@RequestBody Child child){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/child/save").toUriString());
        return ResponseEntity.created(uri).body(childService.saveChild(child));
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Child> updateChild(@RequestBody Child child, @PathVariable Long id){
//        try{
////            Student existingStudent = studentService.StudentGet(id);
//            Child appUserNew = childService.updateChild(id,child);
////            return new ResponseEntity<>(HttpStatus.OK);
//            return ResponseEntity.ok().body(appUserNew);
//        }catch (NoSuchElementException e){
//            return new ResponseEntity<Child>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteChild(@PathVariable Long id){
        childService.deleteChild(id);
        return "Deleted child with id "+id;
    }
}
