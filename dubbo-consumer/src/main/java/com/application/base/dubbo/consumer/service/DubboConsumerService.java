package com.application.base.dubbo.consumer.service;

/**
 * @Author: 孤狼
 * @desc: 消费者服务提供.
 */
public interface DubboConsumerService {
	
	/**
	 * 测试用例
	 * @param name
	 * @return
	 */
	public String sayHello(String name);
	
	/**
	 * 获得版本.
	 * @param name
	 * @return
	 */
	public String getVersion(String name);
	
}
