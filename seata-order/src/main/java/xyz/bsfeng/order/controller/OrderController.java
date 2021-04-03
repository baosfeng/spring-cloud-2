package xyz.bsfeng.order.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.bsfeng.order.client.AccountClient;
import xyz.bsfeng.order.client.StorageClient;
import xyz.bsfeng.order.entity.Account;
import xyz.bsfeng.order.entity.Order;
import xyz.bsfeng.order.entity.Storage;
import xyz.bsfeng.order.service.OrderService;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * (Order)表控制层
 *
 * @author bsfeng
 * @since 2021-04-02 11:07:14
 */
@RestController
@RequestMapping("order")
public class OrderController {

	@Resource
	private AccountClient accountClient;
	@Resource
	private StorageClient storageClient;
	/**
	 * 服务对象
	 */
	@Resource
	private OrderService orderService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("selectOne")
	public Order selectOne(Long id) {
		return this.orderService.queryById(id);
	}

	@GlobalTransactional(rollbackFor = Exception.class)
	@GetMapping("makeOrder")
	public HashMap<String, Object> makeOrder(@RequestParam Integer userId,
	                                         @RequestParam Double money,
	                                         @RequestParam Integer count,
	                                         @RequestParam Integer productId) {
		Order order = Order.builder()
				.count(count)
				.money(money)
				.productId(Long.valueOf(productId))
				.status(0)
				.userId(Long.valueOf(userId))
				.build();
		orderService.insert(order);

		Account account = accountClient.updateAccount(userId, money);
		Storage storage = storageClient.updateStorage(productId, count);

		order.setStatus(1);
		orderService.update(order);

		HashMap<String, Object> hashMap = new HashMap<>(4);
		hashMap.put("order", order);
		hashMap.put("account", account);
		hashMap.put("storage", storage);
		return hashMap;
	}

}
