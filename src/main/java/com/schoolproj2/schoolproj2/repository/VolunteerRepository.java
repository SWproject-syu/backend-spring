package com.schoolproj2.schoolproj2.repository;

import com.schoolproj2.schoolproj2.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer,Long> {

    List<Volunteer> findAll();
}
