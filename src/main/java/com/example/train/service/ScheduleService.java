package com.example.train.service;

import com.example.train.model.Parent;
import com.example.train.model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule saveSchedule(Schedule schedule);
    List<Schedule> getSchedules();
    Schedule getSchedule(Long id);
    void deleteSchedule(Long id);

     Schedule updateSchedule(Long id, Schedule schedule);
}
