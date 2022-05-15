package com.schoolproj2.schoolproj2.service;

import com.schoolproj2.schoolproj2.entity.VolunteerDto;
import com.schoolproj2.schoolproj2.repository.VolunteerRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
@Builder
public class VolunteerSerivce {

    private VolunteerRepository volunteerRepository;

    public String signup(VolunteerDto volunteerDto) {
        volunteerRepository.save(volunteerDto.builder()
                .name(volunteerDto.getName())
                .phonenumber(volunteerDto.getPhonenumber())
                .startAt(volunteerDto.getStartAt())
                .endAt(volunteerDto.getEndAt())
                .build());
        return "Success save";
    }
}
