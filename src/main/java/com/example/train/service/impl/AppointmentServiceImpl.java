package com.example.train.service.impl;

import com.example.train.model.Admin;
import com.example.train.model.Appointment;
import com.example.train.repository.AppointmentRepository;
import com.example.train.service.AppointmentService;
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
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public Appointment saveAppointment(Appointment appointment){
        log.info("Saving appointment {} to the database",appointment.getAppointmentId());
        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAppointments(){
        log.info("Get all appointments from database");
        return appointmentRepository.findAll();
    }
    public Appointment getAppointment(Long id){
        log.info("Get {} appointment from database",id);
        return appointmentRepository.findById(id).get();
    }

    public Appointment updateAppointment(Long id, Appointment appointment){
        Appointment existingAppointment = appointmentRepository.findById(id).get();

        if(Objects.nonNull(appointment.getVaccineType())){
            existingAppointment.setVaccineType(appointment.getVaccineType());
        } else if (Objects.nonNull(appointment.getParentName())) {
            existingAppointment.setParentName(appointment.getParentName());
        } else if (Objects.nonNull(appointment.getVaccinationCardNumber())) {
            existingAppointment.setVaccinationCardNumber(appointment.getVaccinationCardNumber());
        } else if (Objects.nonNull(appointment.getStatus())) {
            existingAppointment.setStatus(appointment.getStatus());
        } else if (Objects.nonNull(appointment.getChildName())) {
            existingAppointment.setChildName(appointment.getChildName());
        } else if (Objects.nonNull(appointment.getVaccinationCenter())) {
            existingAppointment.setVaccinationCenter(appointment.getVaccinationCenter());
        } else if (Objects.nonNull(appointment.getDate())) {
            existingAppointment.setDate(appointment.getDate());
        } else if (Objects.nonNull(appointment.getTime())) {
            existingAppointment.setTime(appointment.getTime());
        }
        return appointmentRepository.save(existingAppointment);
    }
}
