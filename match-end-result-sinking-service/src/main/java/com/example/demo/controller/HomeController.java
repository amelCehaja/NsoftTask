package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.MatchResult;
import com.example.demo.service.IMatchResultService;

@RestController
public class HomeController 
{
	private IMatchResultService matchResultService;
	
	public HomeController(IMatchResultService service) {
		this.matchResultService = service;
	}
	
	@PostMapping("/save-end-result")
	public MatchResult Insert(@Valid @RequestBody MatchResult request) {
		try {
			matchResultService.Insert(request);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		return request;
	}
	
}
