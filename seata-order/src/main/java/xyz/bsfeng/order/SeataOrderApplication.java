package xyz.bsfeng.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author bsfeng
 * @date 2021/4/2-11:00
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("xyz.bsfeng.order.dao")
public class SeataOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataOrderApplication.class, args);
	}
}
