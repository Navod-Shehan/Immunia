package com.example.train.repository;

import com.example.train.model.AppUser;
import com.example.train.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
