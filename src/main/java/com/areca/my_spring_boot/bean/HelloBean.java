package com.areca.my_spring_boot.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author br2zz@sina.com
 *
 */
@XmlRootElement
public class HelloBean {

	private Integer id;
	private String msg;
	private Date date;
	
	@XmlElement
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@XmlElement
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@XmlElement
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public HelloBean(Integer id, String msg, Date date) {
		super();
		this.id = id;
		this.msg = msg;
		this.date = date;
	}
	
	public HelloBean() {
	}
	
	
}
