package com.application.base.dubbo.consumer.config.filter;

/**
 * @Author: 孤狼
 * @desc: 常量设置.
 */
public class BaseConstant {
	
	/**
	 * redis失效时间
	 */
	public static final int TIME_OUT = 48 * 60 * 60;
	
	/**
	 * 字典的类型
	 */
	public interface LoginType {
		/**
		 * app登录.
		 */
		String APP = "1";
		/**
		 * p端平台登录.
		 */
		String PLATFORM = "2";
	}
	
	/**
	 * 公共字段
	 */
	public interface CommonWord {
		String TOKEN = "token";
		String TYPE = "type";
	}
	
	/**
	 * 是否的校验
	 */
	public interface YesOrNo {
		String YES = "YES";
		String NO = "NO";
	}
	
	/**
	 * 或非的描述.
	 */
	public interface NumberTag {
		int ZERO = 0;
		int ONE = 1;
		int TEN = 10;
		int MAP_MIN_SIZE = 16;
		int MAP_MAX_SIZE = 160;
		
	}
	
	/**
	 * 级联标识
	 */
	public interface RegionTag {
		String PROVINCE_TAG = "regions:province:";
		String CITY_TAG = "regions:city:";
		String DISTRCT_TAG = "regions:distrct:";
		
		String PROVINCE = "PROVINCE";
		String CITY = "CITY";
		String DISTRCT = "DISTRCT";
	}
}
