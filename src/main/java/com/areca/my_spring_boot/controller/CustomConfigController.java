package com.areca.my_spring_boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.areca.my_spring_boot.config.MyConfig;
import com.areca.my_spring_boot.config.MyCustomConfig;

@Controller
public class CustomConfigController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MyCustomConfig customConfig;
	
	@Autowired
	MyConfig config;
	
	@ResponseBody
	@RequestMapping("/myCustomConfig")
	public String coustomInfo(){
		log.info("配置解析:{}",customConfig);
		return MyCustomConfig.info;
	}
	
	@ResponseBody
	@RequestMapping("/myconfig")
	public String info(){
		log.info("配置解析:{}",config);
		return MyConfig.info;
	}
	
}