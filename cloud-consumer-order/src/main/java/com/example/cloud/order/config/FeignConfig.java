package com.example.cloud.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

	/**
	 * 配置Feign的日志输出格式
	 * NONE,
	 * BASIC,
	 * HEADERS,
	 * FULL;
	 *
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}

