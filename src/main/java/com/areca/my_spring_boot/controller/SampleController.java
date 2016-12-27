package com.areca.my_spring_boot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
public class SampleController {

	@RequestMapping("/")
	@ResponseBody
	public String hello(){
		return "hello world !";
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(SampleController.class, args);
		
	}
	
}
