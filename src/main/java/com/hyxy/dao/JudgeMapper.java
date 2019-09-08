package com.hyxy.dao;

import com.hyxy.entity.Judge;
import com.hyxy.entity.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface JudgeMapper {
    
	Judge getByUserName(String username);
	int deleteByPrimaryKey(Integer id);

    int insert(Judge record);

    Judge selectByPrimaryKey(Integer id);

    List<Judge> selectAll();

    int updateByPrimaryKey(Judge record);
    List<Judge> select();
    Judge selectByid(int id);
    Judge login(Map<String, String> map);
	Set<String> getRoles(String userName);
	Set<String> getPermissions(String userName);
}