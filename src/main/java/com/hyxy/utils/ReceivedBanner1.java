package com.hyxy.utils;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.hyxy.entity.Banner2;
import com.hyxy.service.BannerService;

@Service
@RabbitListener(queues = "shop_banner1")
//使用 @RabbitListener 注解标记方法，当监听到队列 中有消息时则会进行接收并处理
public class ReceivedBanner1 {
	@Resource
	private BannerService bannerService;
	// @RabbitListener 标注在类上面表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，
	// 不同类型的消息使用不同的方法来处理
	@RabbitHandler
	public void receive(Banner2 banner) {
		System.out.println("接收到一个要修改的banner");
		bannerService.update(banner);
	}
}
