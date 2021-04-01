package xyz.bsfeng.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author bsfeng
 * @date 2021/4/1-13:41
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosPayApplication.class, args);
	}
}
