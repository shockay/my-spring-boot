package com.areca.my_spring_boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "myconfig")
public class MyConfig {
	
	private String name;
	
	private Integer age;
	
	private String kongfu;
	
	public static String info;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getKongfu() {
		return kongfu;
	}

	public void setKongfu(String kongfu) {
		this.kongfu = kongfu;
	}

	public static String getInfo() {
		return info;
	}

	public static void setInfo(String info) {
		MyConfig.info = info;
	}

	@Override
	public String toString() {
		return "MyConfig [name=" + name + ", age=" + age + ", kongfu=" + kongfu + "]";
	}
	
}
