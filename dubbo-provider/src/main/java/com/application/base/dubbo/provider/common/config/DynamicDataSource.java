package com.application.base.dubbo.provider.common.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 孤狼
 * @desc:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	
	static final Map<DatabaseType, List<String>> METHOD_TYPE_MAP = new HashMap<>();
	
	@Nullable
	@Override
	protected Object determineCurrentLookupKey() {
		DatabaseType operate = DatabaseContextHolder.getDatabaseType();
		logger.info("====================dynamic dataSource type ====================>>" + operate.getOperate());
		return operate;
	}
	
	void setMethodType(DatabaseType type, String content) {
		List<String> list = Arrays.asList(content.split(","));
		METHOD_TYPE_MAP.put(type, list);
	}
	
}
