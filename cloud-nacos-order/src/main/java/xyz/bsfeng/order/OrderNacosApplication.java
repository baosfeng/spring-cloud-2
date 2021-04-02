package xyz.bsfeng.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author bsfeng
 * @date 2021/4/1-13:55
 */
@Slf4j
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"xyz.bsfeng"})
public class OrderNacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderNacosApplication.class, args);
	}
}
