package com.hyxy.entity;

import java.util.List;

public class Role {
	private int id;
	private String role_name;
	private List<Role_function> r_f;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public List<Role_function> getR_f() {
		return r_f;
	}
	public void setR_f(List<Role_function> r_f) {
		this.r_f = r_f;
	}
}
