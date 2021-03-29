package com.example.cloud.web;

import com.example.cloud.common.entity.Result;
import com.example.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author bsfeng
 */
@Slf4j
@RestController
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@GetMapping("/payment/hystrix/ok/{id}")
	public Result paymentInfoSuccess(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfoSuccess(id);
		return Result.ok().put("result", result);
	}

	@GetMapping("/payment/hystrix/timeout/{id}")
	public Result paymentInfoTimeOut(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfoTimeOut(id);
		return Result.ok().put("result", result);
	}

	/**
	 * 服务熔断
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/payment/hystrix/circuit/{id}")
	public Result paymentCircuitBreaker(@PathVariable("id") Integer id) {
		String result = paymentService.paymentCircuitBreaker(id);
		return Result.ok().put("result", result);
	}

}


