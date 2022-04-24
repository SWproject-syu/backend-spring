package com.schoolproj2.schoolproj2.controller;

import java.util.Map;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exampleREST {
	// 예시 GET http://localhost:8080/example?coffee=diet-coffee&price=5
	@GetMapping(value = "/example", produces = "application/json; charset=utf-8")
	// GetMapping 에서도 인코딩을 지정하기 위해 produces 를 사용 가능
	public String getAll(@RequestParam(value = "coffee", defaultValue = "americano") String name,
			@RequestParam(value = "price", required = true) int price) {
		// RequestParam 을 이용하여 Get parameter 를 가져올 수 있으며, defaultValue, required 등의 옵션
		// 설정이 가능하다.
		return "{\"coffee\":{" + "\"name\":\"" + name + "\"," + "\"prince\":" + price + "," + "}}";
	}

	// 예시 GET http://localhost:8080/example/2?coffee=diet-coffee&price=5
	// {} 를 이용하여 `count` path variable 정의
	@GetMapping(value = "/example/{user_id}", produces = "application/json; charset=utf-8")
	public String get(@PathVariable(value = "user_id") int user_id, // count PathVariable 선언
			@RequestParam(value = "coffee", defaultValue = "americano") String name,
			@RequestParam(value = "price", required = true) int price) {
		return "{\"coffee\":{" + "\"name\":\"" + name + "\"," + "\"prince\":" + price + "," + "\"user_id\":" + user_id
				+ "}}";
	}

	// 예시 POST http://localhost:8080/example/minsekim

	@PostMapping(value = "/example/{nickname}", produces = "application/json; charset=utf-8")
	public String add(
			@PathVariable(value = "nickname") String nickname,
			@RequestBody Map<String, String> body) {
		return "Nickname " + nickname +
				" order " + body.get("EA") +
				" " + body.get("coffee") + " " + body;
	}

}
