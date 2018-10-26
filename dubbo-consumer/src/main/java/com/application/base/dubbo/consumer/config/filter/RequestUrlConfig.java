package com.application.base.dubbo.consumer.config.filter;

import com.application.base.cache.redis.jedis.factory.JedisSimpleSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @desc filter 配置
 * @author  孤狼
 */
@Component
public class RequestUrlConfig {
	
	@Value("${isAuth}")
	private String isAuth;
	
	@Value("${nonAuthRequests}")
	private String nonAuthRequests;
	
	@Autowired
	private JedisSimpleSessionFactory factory;
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		RequestSessionSecurityFilter actionFilter = new RequestSessionSecurityFilter();
		actionFilter.setFactory(factory);
		actionFilter.setNonAuthRequests(nonAuthRequests);
		actionFilter.setIsAuth(isAuth);
		registrationBean.setFilter(actionFilter);
		return registrationBean;
	}
}
