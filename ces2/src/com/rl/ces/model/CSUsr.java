package com.rl.ces.model;

import java.math.BigDecimal;
import java.util.Date;
/**
 * javaBean：java简单对象对应这数据库中的一张表
 * @author renliang
 *
 */
public class CSUsr {
	//数据库中的字段多个单词使用"_"来分隔，在java代码中使用驼峰模式
	private Integer userId;
	
	private String username;
	
	private String password;
	
	private Integer gender;
	
	private Date birthday;
	
	private String address;
	
	private BigDecimal sal;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "CSUsr [address=" + address + ", birthday=" + birthday
				+ ", gender=" + gender + ", password=" + password + ", sal="
				+ sal + ", userId=" + userId + ", username=" + username + "]";
	}
	
	

}
