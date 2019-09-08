package com.hyxy.service;

import java.util.List;

import com.hyxy.entity.Banner2;

public interface BannerService {
	public List<Banner2> selectAll(int begin,int number);
	public int selectCount();
	public void insert(Banner2 banner);
	public void delete(int id);
	public void update(Banner2 banner2);
	public Banner2 selectByid(int id);
}
