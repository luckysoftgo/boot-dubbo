package com.application.base.dubbo.provider.common.serialization;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;

import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 孤狼
 * @desc: 注册被序列化类
 * @link:
 *      https://blog.csdn.net/moonpure/article/details/53175519
 */
public class DubboSerializationOptimizerImpl implements SerializationOptimizer {
	
	@Override
	public Collection<Class> getSerializableClasses() {
		List<Class> classes = new LinkedList<>();
		classes.add(InputStream.class);
		classes.add(String.class);
		return classes;
	}
	
}
