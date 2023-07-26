package com.example.train.repository;

import com.example.train.model.AppUser;
import com.example.train.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    Schedule[] findByScheduleDate(Date date);
}
