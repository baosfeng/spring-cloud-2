package com.example.cloud.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

	/**
	 * 赋予RestTemplate负载平衡支持
	 * 同时可以直接通过查找服务名称获得对应的服务地址
	 *
	 * @return
	 */
	@Bean
	// @LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
