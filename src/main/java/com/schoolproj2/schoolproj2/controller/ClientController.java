package com.schoolproj2.schoolproj2.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.schoolproj2.schoolproj2.entity.Client;
import com.schoolproj2.schoolproj2.repository.ClientRepository;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@Autowired
	ClientRepository clientRepository;

	@GetMapping(value = "/client", produces = "application/json; charset=utf-8")
	public Iterable<Client> getClientAll() {
		Iterable<Client> client = clientRepository.findAll();
		return client;
	}

	@GetMapping(value = "/client/{id}", produces = "application/json; charset=utf-8")
	public Client getClient(@PathVariable(value = "id") Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}

	@PostMapping(value = "/client", produces = "application/json; charset=utf-8")
	public String setMenu(@RequestBody Map<String, String> body) throws ParseException {
		Client client = new Client(body.get("name"), body.get("phonenumber"), body.get("require_at"));
		clientRepository.save(client);
		return body.toString();
	}

}
