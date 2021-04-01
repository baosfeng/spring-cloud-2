package xyz.bsfeng.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author bsfeng
 * @date 2021/4/1-13:58
 */
@FeignClient(value = "nacos-payment-provider")
public interface PayClient {

	@GetMapping("/port")
	public String getPort();
}
