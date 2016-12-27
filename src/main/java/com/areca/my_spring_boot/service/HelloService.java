package com.areca.my_spring_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areca.my_spring_boot.bean.HelloBean;
import com.areca.my_spring_boot.dao.Dao;

@Service
public class HelloService {

	@Autowired
	Dao dao;
	
	public List<HelloBean> queryHello(){
		List<HelloBean> hellos = dao.queryForList(HelloBean.class, "select * from hello");
		return hellos;
	}
	
	public HelloBean queryHello(Integer id){
		HelloBean hello = dao.queryForObject(HelloBean.class, "select * from hello where id = ? ", id);
		return hello;
	}
	
}
