package com.schoolproj2.schoolproj2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class test {
	@RequestMapping("/")
	public String init() {
		return "Server is running ...";
	}
}
