package com.schoolproj2.schoolproj2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VolunteerDto {

    private String location;
    private String startAt;
    private String endAt;
    private String name;
    private String phonenumber;

    public Volunteer toEntity(VolunteerDto volunteerDto){
        return Volunteer.builder()
                .name(volunteerDto.name)
                .endAt(endAt)
                .startAt(startAt)
                .location(location)
                .build();
    }
}

