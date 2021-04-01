package xyz.bsfeng.order.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bsfeng
 * @date 2021/4/1-16:19
 */
@RestController
public class ConfigController {

	@Value("${config.name}")
	private String configName;

	@GetMapping("/config")
	public String getConfigName() {
		return configName;
	}
}
