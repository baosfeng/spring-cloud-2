package xyz.bsfeng.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author bsfeng
 * @date 2021/4/2-21:58
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("xyz.bsfeng.storage.dao")
public class SeataStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataStorageApplication.class, args);
	}
}
