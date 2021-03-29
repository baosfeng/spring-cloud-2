package com.example.cloud.order;

import com.example.cloud.rule.MyRoundRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableEurekaClient 通过开启此服务，便可以实现微服务注册
 * EnableDiscoveryClient 通过开启此服务，就可以通过discoveryClient获得远程微服务信息
 * RibbonClient 配置对指定的微服务使用自定义的规则
 * EnableFeignClients 开启Feign配置
 * EnableHystrix 处理客户端自身降级
 *
 * @author bsfeng
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRoundRule.class)
@EnableFeignClients
@EnableHystrix
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}
