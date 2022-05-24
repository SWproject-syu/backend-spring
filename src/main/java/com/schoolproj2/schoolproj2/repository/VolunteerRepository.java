package com.schoolproj2.schoolproj2.repository;

import com.schoolproj2.schoolproj2.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer,Long> {

    List<Volunteer> findAll();

    @Query("select v from Volunteer v where v.name = :name")
    Volunteer findByName(@Param("name") String name);
}
