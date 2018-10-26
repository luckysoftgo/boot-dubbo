package com.application.base.dubbo.consumer.controller;

import com.application.base.dubbo.consumer.service.DubboConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孤狼
 * @desc: 访问入口
 */
@Api("Swagger2测试使用")
@RestController
@RequestMapping("/api/test")
public class SpringBootDubboController {

	@Autowired
	DubboConsumerService dubboConsumerService;
	
	/**
	 * swagger2使用
	 *
	 * @param name
	 * @return
	 */
	@ApiOperation(value="测试dubbo和springboot2的使用", notes="测试dubbo和springboot2的dubbo方式使用")
	@ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String")
	@RequestMapping(value="/sayHello",method = { RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String sayHello(String name) {
		return dubboConsumerService.sayHello(name);
	}
	
	@RequestMapping(value="/getVersion",method = { RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public String getVersion(String name) {
		return dubboConsumerService.getVersion(name);
	}
	
}
