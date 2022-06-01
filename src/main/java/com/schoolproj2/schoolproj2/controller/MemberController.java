package com.schoolproj2.schoolproj2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MemberController {
    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }
}
