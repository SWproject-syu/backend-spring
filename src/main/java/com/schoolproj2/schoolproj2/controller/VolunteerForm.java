package com.schoolproj2.schoolproj2.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter @Setter
public class VolunteerForm {
    private String Name;
    private Long id;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;
    private String name;
    private	String phonenumber;
    private String location;
    private String date;
    private String startAt;
    private String endAt;
    private String dateDesc;
}
