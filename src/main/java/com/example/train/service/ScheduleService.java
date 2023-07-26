package com.example.train.service;

import com.example.train.model.Parent;
import com.example.train.model.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleService {
    Schedule saveSchedule(Schedule schedule);
    List<Schedule> getSchedules();
    Schedule getSchedule(Long id);
    Schedule[] getSchedulesByDate(Date date, Long id);
    Schedule changeStatus(Boolean status, Long scheduleId);
    Schedule[] saveScheduleArray(Schedule[] schedules);
    void deleteSchedule(Long id);

     Schedule updateSchedule(Long id, Schedule schedule);
}
