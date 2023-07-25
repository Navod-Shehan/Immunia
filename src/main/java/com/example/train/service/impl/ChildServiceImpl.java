package com.example.train.service.impl;

import com.example.train.model.AppUser;
import com.example.train.model.Child;
import com.example.train.repository.ChildRepository;
import com.example.train.service.ChildService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository;
    public Child saveChild(Child child){
        log.info("Saving child {} to the database",child.getFirstName());
        return childRepository.save(child);
    }
    public List<Child> getChildren(){
        log.info("Get all children from database");
        return childRepository.findAll();
    }
    public Child getChild(Long id){
        log.info("Get {} child from database",id);
        return childRepository.findById(id).get();
    }
    public void deleteChild(Long id){
        log.info("Delete child {} from database",id);
        childRepository.deleteById(id);
    }
    public Child getChildWithAppointments(Long childId){
        return childRepository.findByChildId(childId);
    }

    public Child updateChild(Long id, Child child){
        Child existingChild = childRepository.findById(id).get();

        if(Objects.nonNull(child.getVaccinationCardNumber()) && !"".equalsIgnoreCase(child.getVaccinationCardNumber())){
            existingChild.setVaccinationCardNumber(child.getVaccinationCardNumber());
        } else if (Objects.nonNull(child.getFirstName()) && !"".equalsIgnoreCase(child.getFirstName())) {
            existingChild.setFirstName(child.getFirstName());
        } else if (Objects.nonNull(child.getLastName()) && !"".equalsIgnoreCase(child.getLastName())) {
            existingChild.setLastName(child.getLastName());
        } else if (Objects.nonNull(child.getGender()) && !"".equalsIgnoreCase(child.getGender())) {
            existingChild.setGender(child.getGender());
        } else if (Objects.nonNull(child.getComments()) && !"".equalsIgnoreCase(child.getComments())) {
            existingChild.setComments(child.getComments());
        } else if (Objects.nonNull(child.getDateOfBirth()) && !"".equalsIgnoreCase(String.valueOf(child.getDateOfBirth()))) {
            existingChild.setDateOfBirth(child.getDateOfBirth());
        }
        return childRepository.save(existingChild);
    }
}
