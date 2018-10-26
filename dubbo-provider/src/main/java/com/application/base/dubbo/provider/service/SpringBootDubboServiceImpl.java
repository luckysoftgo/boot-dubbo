package com.application.base.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.application.base.dubbo.api.service.SpringBootDubboService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 孤狼
 * @desc: dubbo 实现.
 */

@Service(version = "${dubbo.provider.version}",
		application = "${dubbo.application.id}",
		protocol = "${dubbo.protocol.id}",
		registry = "${dubbo.registry.id}")
@Slf4j
public class SpringBootDubboServiceImpl implements SpringBootDubboService {
	
	@Override
	public String sayHello(String name) {
		return "Hello,"+name+" for Spring-Boot .";
	}
	
	@Override
	public String getVersion(String name) {
		return "Hello,"+name+" 当前java版本是: 1.8 ";
	}
}
