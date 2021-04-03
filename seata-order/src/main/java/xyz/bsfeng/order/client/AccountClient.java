package xyz.bsfeng.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.bsfeng.order.entity.Account;

/**
 * @author bsfeng
 * @date 2021/4/3-9:48
 */
@Component
@FeignClient("account-service")
public interface AccountClient {

	@GetMapping("/account/updateAccount")
	Account updateAccount(@RequestParam Integer userId, @RequestParam Double money);
}
