package com.application.base.dubbo.consumer.config.redis.single;

import com.application.base.cache.redis.jedis.factory.JedisSimpleSessionFactory;
import com.application.base.cache.redis.jedis.lock.DelegateDistributedLock;
import com.application.base.common.BaseStringUtil;
import com.application.base.dubbo.consumer.config.redis.RedisCommonPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @desc redis 单实例管理.
 * @author 孤狼
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "spring.redis")
public class SingleRedisInfoSettingConfig {
	/**
	 * 主机.
	 */
	private String host="127.0.0.1";
	/**
	 * 端口.
	 */
	private int port=6379;
	/**
	 * 密码.
	 */
	private String password="123456";
	/**
	 * 失效时间.
	 */
	private int timeout=50000;
	
	/**
	 * 公共配置属性.
	 */
	@Autowired
	private RedisCommonPoolConfig commonPoolConfig;
	
	/**
	 * 初始化 JedisPool 的实例.
	 * @return
	 */
	@Bean(name = "jedisPool")
	public JedisPool getSingleRedisJedisPool(){
		JedisPool pool = null;
		if (commonPoolConfig==null){
			return pool;
		}
		JedisPoolConfig config = commonPoolConfig.getJedisPoolConfig();
		if (config!=null){
			if (BaseStringUtil.isNotEmpty(password)){
				pool = new JedisPool(config,host,port,timeout,password);
			}else{
				pool = new JedisPool(config,host,port,timeout);
			}
		}
		return pool;
	}
	
	/**
	 * 获得 Redis 的实例.
	 * @return
	 */
	@Bean(name = "sessionFactory")
	public JedisSimpleSessionFactory getSingleRedisSessionFactory(){
		JedisPool pool = getSingleRedisJedisPool();
		JedisSimpleSessionFactory factory = null;
		if (pool!=null){
			factory = new JedisSimpleSessionFactory();
			factory.setPool(pool);
		}
		return factory;
	}
	
	/**
	 * 获得 Redis 分布式锁
	 * @return
	 */
	@Bean(name = "distributedLock")
	public DelegateDistributedLock getSingleRedisDistributedLock(){
		JedisSimpleSessionFactory factory = getSingleRedisSessionFactory();
		if (factory!=null){
			DelegateDistributedLock distributedLock = new DelegateDistributedLock();
			distributedLock.setFactory(factory);
			return distributedLock;
		}else{
			return null;
		}
	}
	
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
