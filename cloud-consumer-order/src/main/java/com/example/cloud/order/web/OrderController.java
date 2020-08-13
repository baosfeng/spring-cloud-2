package com.example.cloud.order.web;

import com.example.cloud.common.entity.Payment;
import com.example.cloud.common.entity.Result;
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

@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

	//动态获取地址
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private DiscoveryClient discoveryClient;

	@Resource
	private RestTemplate restTemplate;

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
	 * 获得所有的注册微服务信息
	 *
	 * @return 所有的微服务注册信息
	 */
	@GetMapping("/instance")
	public Result getInstance() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		Result result = new Result();
		ArrayList<HashMap> list = new ArrayList<>();
		instances.forEach(item -> {
			HashMap<String, Object> map = new HashMap<>();
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
