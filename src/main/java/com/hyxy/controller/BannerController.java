package com.hyxy.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyxy.entity.Banner2;
import com.hyxy.service.BannerService;
import com.hyxy.utils.PageUtils;
import com.hyxy.utils.upload2;

@Controller
@RequestMapping("banner")
public class BannerController {
	@Autowired
    private AmqpTemplate rabbitTemplate;
	@Resource
	private BannerService bannerService;
	@RequestMapping("select")
	public String selectBanner(String currentPage,String pageSize,Map<String, Object> map) {
		int count = bannerService.selectCount();
		PageUtils pageUtils = new PageUtils(currentPage, count, pageSize);
		// 开始记录数,由工具类中计算得出
		int  begin = pageUtils.getPageRecord();
		//查几条记录
		int number = pageUtils.getPageSize();
		//前台页面分页模型（传入页面使用的html代码）
		String page =  pageUtils.getPage();
	    List<Banner2> list = bannerService.selectAll(begin, number);
		map.put("banner", list);
		map.put("page",page);
		map.put("number",number);
		return "banner";
	}
	@RequestMapping("add")
	public String add() {
		return "banner-add";
	}
	@ResponseBody
	@RequestMapping("add2")
	public List<String> add2(HttpServletRequest request,@RequestParam(value="img",required=false)MultipartFile[] img){
		upload2 upload2 = new upload2();
		List<String> list = upload2.uploadfile(request, img);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("add3")
	public String add3(@RequestParam(value="img",required=false) MultipartFile[] img,Banner2 banner2,HttpServletRequest request){
		rabbitTemplate.convertAndSend("shop_banner",banner2);
		
		return "forward:/banner/select";
	}
	@RequestMapping("delete")
	public String delete(int id) {
		bannerService.delete(id);
		return "forward:/banner/select";
	}
	@RequestMapping("update1")
	public String update(int id,Map<String, Object> map){
		Banner2 banner2 = bannerService.selectByid(id);
		map.put("banner", banner2);
		return "banner-edit";
	}
	@RequestMapping("update2")
	public String update2(Banner2 banner2){
		rabbitTemplate.convertAndSend("shop_banner1",banner2);
		
		return "forward:/banner/select";
	}
}
