package xyz.bsfeng.order.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.bsfeng.order.PayClient;

import javax.annotation.Resource;

/**
 * @author bsfeng
 * @date 2021/4/1-16:13
 */
@RestController
public class OrderController {

	@Resource
	private PayClient payClient;

	@GetMapping("/port")
	public String getPort() {
		return payClient.getPort();
	}
}
