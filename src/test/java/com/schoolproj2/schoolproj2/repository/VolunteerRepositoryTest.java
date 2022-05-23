package com.schoolproj2.schoolproj2.repository;

import com.schoolproj2.schoolproj2.entity.Volunteer;
import com.schoolproj2.schoolproj2.entity.VolunteerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class VolunteerRepositoryTest {







    @Test

    public void 로그인() {

        //when
//        VolunteerRepository volunteerRepository = new VolunteerRepository();
        VolunteerDto volunteerDto = new VolunteerDto();
        volunteerDto.setEndAt("20101212");
        volunteerDto.setLocation("일산");
        volunteerDto.setName("서영");
        volunteerDto.setStartAt("201212121");
        volunteerDto.setPhonenumber("0102222222");



        //given
        Volunteer volunteer1 = volunteerDto.toEntity(volunteerDto);

/**
        //then
        //List<Volunteer> all = volunteerRepository.findAll();
        volunteerRepository.save(volunteer1);
        Volunteer seo = volunteerRepository.findByName("서영");
        assertEquals(seo, volunteer1);
    } **/
}}



