package com.areca.my_spring_boot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.areca.my_spring_boot.bean.HelloBean;
import com.areca.my_spring_boot.service.HelloService;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model){
		
		model.addAttribute("msg", "你好");
		return "hello";
	}

	@ResponseBody
	@RequestMapping("/hello/json")
	public Object helloBean(){
		HelloBean hello = new HelloBean();
		hello.setId(123);
		hello.setMsg("你好");
		hello.setDate(new Date());
		return hello;
	}
	
	
	@Autowired
	HelloService service;
	
	@RequestMapping("/hello/list")
	public String list(Model model){
		model.addAttribute("list", service.queryHello());
		return "list";
	}
	
	@RequestMapping("/hello/info")
	public String info(Integer id,Model model){
		model.addAttribute("v",service.queryHello(id));
		return "info";
	}
	
	
	
}
