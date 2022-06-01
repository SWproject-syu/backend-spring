package com.schoolproj2.schoolproj2.service;

import com.schoolproj2.schoolproj2.entity.Volunteer;
import com.schoolproj2.schoolproj2.entity.VolunteerDto;
import com.schoolproj2.schoolproj2.repository.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class VolunteerSerivce {

    private final VolunteerRepository volunteerRepository;

    /**
     * public Long join(Volunteer volunteer){
     * <p>
     * Volunteer volunteer1 = new Volunteer();
     * <p>
     * volunteer.setLocation(volunteer.getLocation());
     * volunteer.setPhonenumber(volunteer.getPhonenumber());
     * volunteer.setName(volunteer.getName());
     * volunteer.setStartAt(volunteer.getStartAt());
     * volunteer.setEndAt(volunteer.getEndAt());
     * <p>
     * <p>
     * <p>
     * volunteerRepository.save(volunteer);
     * <p>
     * return volunteer.getId();
     * }
     **/

    @Transactional
    public void saveVolunteer(Volunteer volunteer){
        volunteerRepository.save(volunteer);
    }

    public List<Volunteer> findVolunteers(){
        return volunteerRepository.findAll();
    }


    public String signup(Volunteer volunteer) {
        volunteerRepository.save(Volunteer.builder()
                .name(volunteer.getName())
                .phonenumber(volunteer.getPhonenumber())
                .startAt(volunteer.getStartAt())
                .endAt(volunteer.getEndAt())
                .build());
        return "Success save";
    }

}