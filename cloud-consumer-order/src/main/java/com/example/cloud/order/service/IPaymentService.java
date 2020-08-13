package com.example.cloud.order.service;

import com.example.cloud.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface IPaymentService {

	@GetMapping("/payment/select/{id}")
	Result selectOne(@PathVariable Long id);
}
