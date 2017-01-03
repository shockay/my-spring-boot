package com.areca.my_spring_boot.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCustomConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
//	@Value("${name}")
	private String name;
	
//	@Value("${my.age}")
	private Integer age;
	
//	@Value("${my-kongfu}")
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

//	@Value("${my.info}")
	public static void setInfo(String info) {
		MyCustomConfig.info = info;
	}

	@Override
	public String toString() {
		return "MyCustomConfig [name=" + name + ", age=" + age + ", kongfu=" + kongfu + "]";
	}

	public MyCustomConfig(String name, Integer age, String kongfu) {
		super();
		this.name = name;
		this.age = age;
		this.kongfu = kongfu;
	}

	public MyCustomConfig() {
	}
	
}
