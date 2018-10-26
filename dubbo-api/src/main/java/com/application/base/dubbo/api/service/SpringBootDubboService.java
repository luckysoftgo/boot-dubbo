package com.application.base.dubbo.api.service;

/**
 * @Author: 孤狼
 * @desc: 基于springboot + dubbo 的服务接口调用.
 *
 */
public interface SpringBootDubboService {
	
	/**
	 * 测试用例.
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
