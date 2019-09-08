package com.hyxy.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyxy.dao.JudgeMapper;

import com.hyxy.entity.Judge;
@Service
public class LoginServiceImp implements LoginService{
	@Resource
	private JudgeMapper judgeMapper;

	@Override
	public List<Judge> selectAll() {
		List<Judge> list = judgeMapper.selectAll();
		return list;
	}

	public int selectRoleid(int id) {
		int roleid = judgeMapper.selectByPrimaryKey(id).getRoleId();
		return roleid;
	}

	public List<Judge> select() {
		List<Judge> list = judgeMapper.select();
		return list;
	}

	@Override
	public void insert(Judge judge) {
		judgeMapper.insert(judge);
		
	}

	@Override
	public Judge selectByid(int id) {
		Judge judge = judgeMapper.selectByid(id);
		return judge;
	}

	@Override
	public void update(Judge judge) {
		judgeMapper.updateByPrimaryKey(judge);
		
	}

	@Override
	public void delete(int id) {
		judgeMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Judge login(Map<String, String> map) {
		Judge judge = judgeMapper.login(map);
		return judge;
	}

	@Override
	public Judge getByUserName(String username) {
		Judge judge = judgeMapper.getByUserName(username);
		return judge;
	}

	@Override
	public Set<String> getRoles(String userName) {
		Set<String> set = judgeMapper.getRoles(userName);
		return set;
	}

	@Override
	public Set<String> getPermissions(String userName) {
		Set<String> set = judgeMapper.getPermissions(userName);
		return set;
	}

}
