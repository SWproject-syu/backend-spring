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
    /**회원가입
    @Transactional (readOnly = false)
    public Long join(Volunteer volunteer){
        validateDuplicateVolunteer(volunteer);
        volunteerRepository.
                save(volunteer);
        return volunteer
    }
    private void validateDuplicateVolunteer(Volunteer volunteer) {
        List<Volunteer> findVolunteers =
                VolunteerRepository.findByName(volunteer.getName());
        if (!findVolunteers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    **/
    //전체 조회

/**
    public  List<Volunteer> findVolunteers(){
        return VolunteerRepository.findAll();
    }
**/





  /** public String signup(VolunteerDto volunteerDto) {
        volunteerRepository.save(Volunteer.builder()
                .name(volunteerDto.getName())
                .phonenumber(volunteerDto.getPhonenumber())
                .startAt(volunteerDto.getStartAt())
                .endAt(volunteerDto.getEndAt())
                .build());
        return "Success save"; **/
    }

