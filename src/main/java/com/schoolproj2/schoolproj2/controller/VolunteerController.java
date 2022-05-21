package com.schoolproj2.schoolproj2.controller;


import com.schoolproj2.schoolproj2.entity.VolunteerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class VolunteerController {



    //자원봉사자 등록 페이지
    @GetMapping("/Volunteer/signup")
    public String signup(VolunteerDto volunteerDto){
        return "/signup";
    }
    @PostMapping("/VolunteerDto")
    private ResponseEntity<String> Volunteer(@RequestBody VolunteerDto volunteerDto){
        log.info("Volunteer.location = {}",volunteerDto.getLocation());
        log.info("Volunteer.startAt = {}",volunteerDto.getStartAt());
        log.info("Volunteer.endAt = {}",volunteerDto.getEndAt());
        log.info("Volunteer.phonenumber= {}",volunteerDto.getPhonenumber());
        return new ResponseEntity<>("데이터 전송 완료 ", HttpStatus.OK);
    }


///생성완료 이제 DB저장은 VolunteerService

}