package com.areca.my_spring_boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.areca.my_spring_boot.bean.HelloBean;
import com.areca.my_spring_boot.dao.Dao;

@Service
@CacheConfig(cacheNames = "Hello")  //在service层增加缓存 
public class HelloService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Dao dao;
	
	@Cacheable
	public List<HelloBean> queryHellos(){
		log.info("查询了数据库");
		List<HelloBean> hellos = dao.queryForList(HelloBean.class, "select * from hello");
		return hellos;
	}
	
	public HelloBean queryHello(Integer id){
		HelloBean hello = dao.queryForObject(HelloBean.class, "select * from hello where id = ? ", id);
		return hello;
	}
	
}
