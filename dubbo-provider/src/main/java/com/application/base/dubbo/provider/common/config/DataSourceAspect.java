package com.application.base.dubbo.provider.common.config;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 孤狼
 * @desc: 动态处理数据源，根据命名区分
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {
	
	
	private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
	
	@Pointcut("execution(* com.application.base.dubbo.provider.dao.*.*(..))")
	public void aspect() {
		//切面使用到的点.
	}
	
	
	@Before("aspect()")
	public void before(JoinPoint point) {
		String className = point.getTarget().getClass().getName();
		String method = point.getSignature().getName();
		String args = StringUtils.join(point.getArgs(), ",");
		logger.info("className:{}, method:{}, args:{} ", className, method, args);
		try {
			for (DatabaseType type : DatabaseType.values()) {
				List<String> values = DynamicDataSource.METHOD_TYPE_MAP.get(type);
				for (String key : values) {
					if (method.startsWith(key)) {
						logger.info(">>方法:{},使用的方法开头为:{}<<", method, key);
						DatabaseContextHolder.setDatabaseType(type);
						DatabaseType operate = DatabaseContextHolder.getDatabaseType();
						logger.info(">>方法:{},使用的数据源为:{}<<", method, operate.getOperate());
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
}
