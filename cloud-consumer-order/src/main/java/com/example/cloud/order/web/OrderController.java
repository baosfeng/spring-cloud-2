package com.example.cloud.order.web;

import com.example.cloud.common.entity.Payment;
import com.example.cloud.common.entity.Result;
import com.example.cloud.order.config.LoadBalance;
import com.example.cloud.order.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bsfeng
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

	/**
	 * 动态获取地址
	 */
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private DiscoveryClient discoveryClient;

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private LoadBalance loadBalance;

	@Resource
	private IPaymentService paymentService;

	@GetMapping("/save")
	public Result create(Payment payment) {
		//写操作
		return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, Result.class);
	}

	@GetMapping("/select/{id}")
	public Result getPayment(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/select/" + id, Result.class);
	}

	/**
	 * 自定义轮询访问
	 *
	 * @param id 带查询的id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Result get(@PathVariable("id") Long id) {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		ServiceInstance instance = loadBalance.instance(instances);
		if (instance == null) {
			return Result.error();
		}
		return restTemplate.getForObject(instance.getUri() + "/payment/select/" + id, Result.class);
	}

	/**
	 * 通过feign进行远程接口的调取
	 * 默认feign自带负载均衡配置器
	 *
	 * @param id 带查询的id
	 * @return
	 */
	@GetMapping("/feign/{id}")
	public Result getByFeign(@PathVariable("id") Long id) {
		return paymentService.selectOne(id);
	}


	@GetMapping("/feign/timeout")
	public Result timeout() {
		return paymentService.timeout();
	}

	/**
	 * 获得所有的注册微服务信息
	 *
	 * @return 所有的微服务注册信息
	 */
	@GetMapping("/instance")
	public Result getInstance() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		Result result = new Result();
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		instances.forEach(item -> {
			HashMap<String, Object> map = new HashMap<>(16);
			map.put("host", item.getHost());
			map.put("port", item.getPort());
			map.put("Metadata", item.getMetadata());
			map.put("InstanceId", item.getInstanceId());
			map.put("Scheme", item.getScheme());
			map.put("ServiceId", item.getServiceId());
			map.put("Uri", item.getUri());
			list.add(map);
		});
		result.put("Instances", list);
		List<String> services = discoveryClient.getServices();
		result.put("services", services);

		return result;
	}
}
