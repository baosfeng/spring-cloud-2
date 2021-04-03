package xyz.bsfeng.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.bsfeng.order.entity.Storage;

/**
 * @author bsfeng
 * @date 2021/4/3-9:48
 */
@Component
@FeignClient("storage-service")
public interface StorageClient {

	@GetMapping("/storage/updateStorage")
	Storage updateStorage(@RequestParam Integer productId, @RequestParam Integer used);
}
