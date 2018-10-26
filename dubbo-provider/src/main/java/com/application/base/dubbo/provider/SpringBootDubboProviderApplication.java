package com.application.base.dubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 孤狼
 * @desc: dubbo 生产者
 *
 * @read:
 * com.javabase.*.dao 必须要这样的写法;如果写成:com.*.dao 的话,是不能被加载的; 或者:com.javabase.*
 * https://blog.csdn.net/alinyua/article/details/80070890
 */
@MapperScan(basePackages = "com.application.base.dubbo.*.dao")
@SpringBootApplication
public class SpringBootDubboProviderApplication {
	
	/**
	 * springboot 启动入口.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboProviderApplication.class, args);
	}
	
}
