package com.example.train.repository;

import com.example.train.model.Child;
import com.example.train.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query("SELECT c FROM Child c LEFT JOIN FETCH c.appointments WHERE c.childId = :childId")
    Child findByIdWithAppointments(@Param("childId") Long childId);

    Child findByChildId(Long childId);
}
