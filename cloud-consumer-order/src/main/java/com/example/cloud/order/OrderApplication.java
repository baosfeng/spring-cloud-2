package com.example.cloud.order;

import com.example.cloud.rule.MyRoundRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//通过开启此服务，便可以实现微服务注册
@EnableEurekaClient
//通过开启此服务，就可以通过discoveryClient获得远程微服务信息
@EnableDiscoveryClient
//配置对指定的微服务使用自定义的规则
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRoundRule.class)
//开启Feign配置
@EnableFeignClients
//处理客户端自身熔断
@EnableHystrix
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}
