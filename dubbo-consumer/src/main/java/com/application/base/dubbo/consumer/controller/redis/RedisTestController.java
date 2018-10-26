package com.application.base.dubbo.consumer.controller.redis;

import com.application.base.cache.redis.jedis.factory.JedisSimpleSessionFactory;
import com.application.base.cache.redis.jedis.lock.DelegateDistributedLock;
import com.application.base.common.web.BaseCommController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc redis 集群测试.
 * @author 孤狼
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController extends BaseCommController {

    @Autowired
    private JedisSimpleSessionFactory sessionFactory;

    @Autowired
    private DelegateDistributedLock distributedLock;
    
    String testTag = "testTag";
    
    /**
     * 通过主键获得对象.
     */
    @RequestMapping(value = "/testData")
    public void testRedis() {
        String key = "data";
        String value = "test-";
        int count=5;
        for (int i=0; i<count;i++){
            sessionFactory.getRedisSession().setData(key,value+i);
            String tmpValue = sessionFactory.getRedisSession().getData(key);
            System.out.println(tmpValue);
        }
        value = sessionFactory.getRedisSession().getData(key);
        sessionFactory.getRedisSession().setData(key,"123456789");
        value = sessionFactory.getRedisSession().getData(key);
        System.out.println("value = " + value );
        sessionFactory.getRedisSession().setData(key,"123456789");
    }
    
    /**
     * 通过主键获得对象.
     */
    @RequestMapping(value = "/testDataLock")
    public void testRedisLock() {
        String tag = sessionFactory.getRedisSession().getData(testTag);
        if (tag==null || "".equals(tag)){
            boolean result =  distributedLock.tryLock(testTag);
            String key = "data";
            String value = "test-";
            int count=5;
            for (int i=0; i<count;i++){
                sessionFactory.getRedisSession().setData(key,value+i);
                String tmpValue = sessionFactory.getRedisSession().getData(key);
                System.out.println(tmpValue);
            }
            distributedLock.unLock(testTag);
        }else{
            System.out.println("该资源正在被锁在内存之中.");
        }
    }
}