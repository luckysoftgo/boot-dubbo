package com.application.base.dubbo.consumer.controller;

import com.application.base.dubbo.consumer.service.DubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @Author: 孤狼
 * @desc: 访问入口
 */


@RestController
@RequestMapping("/api/test")
public class SpringBootDubboRestController {

	@Autowired
	DubboConsumerService dubboConsumerService;
	
	@RequestMapping("/sayHello")
	public String sayHello(String name) {
		return dubboConsumerService.sayHello(name);
	}
	
	@Path("getVersion")
	@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
	public String getVersion(String name) {
		return dubboConsumerService.getVersion(name);
	}
	
}
