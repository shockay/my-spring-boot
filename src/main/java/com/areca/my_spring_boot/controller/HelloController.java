package com.areca.my_spring_boot.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.areca.my_spring_boot.bean.HelloBean;
import com.areca.my_spring_boot.service.HelloService;

@Controller
public class HelloController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HelloService service;
	
	@RequestMapping("/hello")
	public String hello(Model model){
		
		model.addAttribute("msg", "你好");
		return "hello";
	}

	@ResponseBody
	@RequestMapping(value = "/hello/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) //配置json的导航支持
	public Object helloBeanJson(){
//		HelloBean hello = new HelloBean();
//		hello.setId(123);
//		hello.setMsg("你好");
//		hello.setDate(new Date());
//		return hello;
		return new HelloBean(123,"你好",new Date());
	}
	
	@ResponseBody
	@RequestMapping(value = "/hello/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE) //配置xml的导航支持
	public Object helloBeanXml(){
		return new HelloBean(123,"你好",new Date());
	}
	
	@RequestMapping("/hello/list")
	public String list(Model model){
		log.info("访问了 {} 接口，现在时间为 {}","/hello/list",new Date());
		model.addAttribute("list", service.queryHello());
		return "list";
	}
	
	@RequestMapping("/hello/info")
	public String info(Integer id,Model model){
		model.addAttribute("v",service.queryHello(id));
		return "info";
	}
	
	
	
}
