package com.example.cloud.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bsfeng
 */
@Configuration
public class MyRoundRule {

	@Bean
	public IRule rule() {
		return new RandomRule();
	}
}
