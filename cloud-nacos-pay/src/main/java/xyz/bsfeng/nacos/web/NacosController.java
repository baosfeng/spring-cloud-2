package xyz.bsfeng.nacos.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bsfeng
 * @date 2021/4/1-13:45
 */
@RestController
public class NacosController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/")
	public String getPort() {
		return port;
	}
}
