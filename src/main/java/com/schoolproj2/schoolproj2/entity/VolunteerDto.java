package com.schoolproj2.schoolproj2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
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

}

