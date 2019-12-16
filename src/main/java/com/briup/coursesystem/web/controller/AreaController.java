package com.briup.coursesystem.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaController {
	@GetMapping("/user/mm")
	public String findAll() {
		return "1111111111";
	}
}
