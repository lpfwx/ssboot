package com.hyxy.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	 //声明队列名称
	   private final static String QUEUE_NAME = "shop_banner"; 
	   private final static String QUEUE_NAME1 = "shop_banner1";
	   //声明交换机
	   private final static String exchange = "fanout_exchange";
	   @Bean
	    public Queue queue() {
	        return new Queue(RabbitMQConfig.QUEUE_NAME);
	 }
	   @Bean
	    public Queue queue1() {
	        return new Queue(RabbitMQConfig.QUEUE_NAME1);
	 }
     /**
     **创建一个fanout类型的交换机,fanout--不处理路由键
     */
    @Bean
    FanoutExchange fanoutExchange() {
         return new FanoutExchange(exchange);
    }
    @Bean
    Binding bindingExchangeA() {
         return BindingBuilder.bind(queue()).to(fanoutExchange());
         }  
    @Bean
    Binding bindingExchangeB() {
         return BindingBuilder.bind(queue1()).to(fanoutExchange());
         } 
}
