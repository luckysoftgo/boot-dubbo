package com.application.base.dubbo.consumer.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@desc 属性设置
 *@author 孤狼
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	/**
	 * api 基础信息.
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Dubbo")
				.version("1.0.0")
				.description("SpringBoot2 和 Dubbo2.6.2 合并使用的Demo")
				.contact(new Contact("青云科技", null, "1577620678@qq.com"))
				.build();
	}
	
	/**
	 * demo controller 接口调用.
	 * @return
	 */
	@Bean
	public Docket createDemoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("demo接口API")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.application.base.dubbo.consumer.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
}
