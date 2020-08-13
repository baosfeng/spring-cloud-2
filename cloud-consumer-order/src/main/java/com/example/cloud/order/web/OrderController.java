package com.example.cloud.order.web;

import com.example.cloud.order.entity.Payment;
import com.example.cloud.order.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

	public static final String PAYMENT_URL = "http://localhost:8001";

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
}
