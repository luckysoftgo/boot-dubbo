package com.application.base.dubbo.consumer.config.msg;

import com.application.base.common.result.ResultMessageContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc 全局消息配置
 * @author 孤狼
 */
@Configuration
@EnableAutoConfiguration
public class CommonMsgConfig {
	
	@Bean
	public ResultMessageContext getMsgContext(){
		ResultMessageContext context = new ResultMessageContext();
		//全局消息的配置,如果有多个消息,则在配置文件中用","分割开来.
		//message/demo1.xml;message/demo2.xml;
		context.setPaths("message/resultMessage.xml");
		context.init();
		return context;
	}

}
