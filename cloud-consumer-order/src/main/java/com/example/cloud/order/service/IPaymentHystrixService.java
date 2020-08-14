package com.example.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 异常统一交给实现类进行处理
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixServiceImpl.class)
public interface IPaymentHystrixService {

	@GetMapping("/payment/hystrix/ok/{id}")
	String paymentInfoOK(@PathVariable("id") Integer id);

	@GetMapping("/payment/hystrix/timeout/{id}")
	String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
