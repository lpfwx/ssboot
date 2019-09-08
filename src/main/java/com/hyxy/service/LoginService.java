package com.hyxy.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hyxy.entity.Judge;

public interface LoginService {
	public List<Judge> selectAll();
	public int selectRoleid(int id);
	public List<Judge> select();
	public void insert(Judge judge);
	public Judge selectByid(int id);
	public void update(Judge judge);
	public void delete(int id);
	public Judge login(Map<String, String> map);
	public Judge getByUserName(String username);
	public Set<String> getRoles(String userName);
	public Set<String> getPermissions(String userName);
}
