package com.application.base.dubbo.provider.common.config;

/**
 * @Author: 孤狼
 * @desc: DB Holder
 */
public class DatabaseContextHolder {
	
	private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();
	
	public static void setDatabaseType(DatabaseType type) {
		contextHolder.set(type);
	}
	
	public static DatabaseType getDatabaseType() {
		return contextHolder.get();
	}
}
