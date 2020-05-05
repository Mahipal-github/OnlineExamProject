package com.cg.onlinetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="lpu_user")
@DynamicUpdate
@DynamicInsert
public class User {
	
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name", length=25)
	private String userName;
	@Column(name="password", length=20)
	private  String password;
	@Column(name="role", length=20)
	private String role;
	public User() {
		
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
