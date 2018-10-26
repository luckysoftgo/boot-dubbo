package com.application.base.dubbo.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.application.base.dubbo.api.service.SpringBootDubboService;
import com.application.base.dubbo.consumer.service.DubboConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 孤狼
 * @desc:
 */
@Service
@Slf4j
public class DubboConsumerServiceImpl implements DubboConsumerService {
	
	@Reference(version = "${dubbo.consumer.version}",
			application = "${dubbo.application.id}")
	private SpringBootDubboService springBootDubboService;
	
	@Override
	public String sayHello(String name) {
		log.debug("消费者接到的名称是:name="+name);
		return springBootDubboService.sayHello(name);
	}
	
	@Override
	public String getVersion(String name) {
		log.debug("要获取对象的名称是:name="+name);
		return springBootDubboService.getVersion(name);
	}
}
