package xyz.bsfeng.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author bsfeng
 * @date 2021/4/2-22:02
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("xyz.bsfeng.account.dao")
public class SeataAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataAccountApplication.class, args);
	}
}