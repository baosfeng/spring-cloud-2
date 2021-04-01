package xyz.bsfeng.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author bsfeng
 * @date 2021/4/1-13:55
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderNacosApplication.class, args);
	}
}
