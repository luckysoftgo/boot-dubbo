package com.application.base.dubbo.consumer.config.filter;

/**
 * @desc redis 缓存key设置.
 * @author 孤狼
 */
public class RedisKeyUtil {
    
    public static String testAccount() {
        return "test:account";
    }

    public static String testAuthCode() {
        return "test:authCode";
    }

    public static String platformSession() {
        return "sessions:platforms:";
    }
    
    public static String appSession() {
        return "sessions:apps:";
    }

}

