package com.hyxy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyxy.dao.Banner2Mapper;
import com.hyxy.entity.Banner2;

@Service
public class BannerServiceImp implements BannerService{
	@Resource
	public Banner2Mapper banner2Mapper;
	@Override
	public List<Banner2> selectAll(int begin,int number) {
		List<Banner2> list = banner2Mapper.selectAll(begin, number);
		return list;
	}
	@Override
	public int selectCount() {
		int count = banner2Mapper.selectCount();
		return count;
	}
	@Override
	public void insert(Banner2 banner) {
		banner2Mapper.insert(banner);
		
	}
	@Override
	public void delete(int id) {
		banner2Mapper.deleteByPrimaryKey(id);
	}
	@Override
	public void update(Banner2 banner2) {
		banner2Mapper.updateByPrimaryKey(banner2);
	}
	@Override
	public Banner2 selectByid(int id) {
		Banner2 banner2 = banner2Mapper.selectByPrimaryKey(id);
		return banner2;
	}
	

}
