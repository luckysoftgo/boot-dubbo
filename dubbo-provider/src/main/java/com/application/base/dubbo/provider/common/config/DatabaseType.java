package com.application.base.dubbo.provider.common.config;

/**
 * @Author: 孤狼
 * @desc:
 */
public enum DatabaseType {
	
	/**
	 *写库的主要操作.
	 */
	MASTER("write"),
	
	/**
	 * 读库的主要操作.
	 */
	SLAVE("read");
	
	private String operate;
	
	DatabaseType(String operate) {
		this.operate = operate;
	}
	
	public String getOperate() {
		return operate;
	}
	
	public void setOperate(String operate) {
		this.operate = operate;
	}
	
	@Override
	public String toString() {
		return "DatabaseType {" +"name='" + operate + '\'' +'}';
	}
}
