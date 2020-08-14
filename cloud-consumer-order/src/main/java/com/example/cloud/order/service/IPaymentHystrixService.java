package com.example.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface IPaymentHystrixService {

	@GetMapping("/payment/hystrix/ok/{id}")
	String paymentInfoOK(@PathVariable("id") Integer id);

	@GetMapping("/payment/hystrix/timeout/{id}")
	String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
