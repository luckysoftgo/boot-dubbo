package com.application.base;

import redis.clients.jedis.Jedis;

/**
 * @Author: 孤狼.
 * @desc: redis 连接测试.
 */
public class RedisDoMain {
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("118.24.157.96", 26339);
		//jedis.auth("123456");
		//调用jedis对象的方法，方法名称和redis 的命令一致
		jedis.set("key", "jedis test");
		String string = jedis.get("key");
		System.out.println(string);
	}

}
