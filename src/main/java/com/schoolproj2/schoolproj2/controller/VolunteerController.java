package com.schoolproj2.schoolproj2.controller;


import com.schoolproj2.schoolproj2.entity.Volunteer;
import com.schoolproj2.schoolproj2.entity.VolunteerDto;
import com.schoolproj2.schoolproj2.service.VolunteerSerivce;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VolunteerController {


    private final VolunteerSerivce volunteerSerivce;
/**
    //자원봉사자 등록 페이지
    @CrossOrigin(origins = "*")
    @PostMapping("/apply")

    private ResponseEntity<String> Volunteer(@RequestBody VolunteerDto volunteerDto){

        volunteerDto.toEntity(volunteerDto);

        log.info("Volunteer.name = {}",volunteerDto.getName());
        log.info("Volunteer.location = {}",volunteerDto.getLocation());
        log.info("Volunteer.startAt = {}",volunteerDto.getStartAt());
        log.info("Volunteer.endAt = {}",volunteerDto.getEndAt());
        log.info("Volunteer.phonenumber= {}",volunteerDto.getPhonenumber());


        return new ResponseEntity<>("데이터 전송 완료 ", HttpStatus.OK);
    }

    **/
    //조회 매핑
    /**@GetMapping("/list")
    public String list(VolunteerDto volunteerDto){
        List<Volunteer> volunteerList = volunteerSerivce.findVolunteers();
        return "/volunteerList";
    }**/

/**
    @PostMapping("/apply")
    public String create(VolunteerDto volunteerDto){
        Volunteer volunteer = new Volunteer();
        volunteer.setName(volunteerDto.getName());
        volunteer.setPhonenumber(volunteerDto.getPhonenumber());
        volunteer.setLocation(volunteerDto.getLocation());
        volunteerSerivce.signup(volunteerDto);
        return "redirect:/";
    }
   **/

    //자원봉사자 새로 등록 페이지 연결
    @GetMapping("/apply/new")
    public String createForm(Model model){
        model.addAttribute("form",new VolunteerForm());
        return "volunteers/newvolunteerForm";
    }
    //자원봉사자 저장
    @PostMapping("/apply")
    public String create(VolunteerForm form){
        Volunteer volunteer = new Volunteer();
        volunteer.setName(form.getName());
        volunteer.setPhonenumber(form.getPhonenumber());
        volunteer.setLocation(form.getLocation());
        volunteer.setDate(form.getDate());
        volunteer.setStartAt(form.getStartAt());
        volunteer.setEndAt(form.getEndAt());
        volunteer.setCreateAt(form.getCreateAt());


        volunteerSerivce.saveVolunteer(volunteer);
        
        return "redirect:/";

    }
    //자원봉사자 조회
    @GetMapping("/volunteers")
    public String list (Model model){
        List<Volunteer> volunteers = volunteerSerivce.findVolunteers();
        model.addAttribute("volunteers",volunteers);
        return "volunteers/volunteerList";
    }

///생성완료 이제 DB저장은 VolunteerService

}