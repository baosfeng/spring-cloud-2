package com.example.cloud.order.web;

import com.example.cloud.common.entity.Result;
import com.example.cloud.order.service.IPaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class HystrixController {

	@Resource
	private IPaymentHystrixService paymentHystrixService;

	@GetMapping("/consumer/hystrix/ok/{id}")
	public Result paymentInfoOK(@PathVariable("id") Integer id) {
		log.info("Hello");
		String result = paymentHystrixService.paymentInfoOK(id);
		return Result.ok().put("result", result);
	}

	@HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
			//1秒钟以内就是正常的业务逻辑
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
	})
	@GetMapping("/consumer/hystrix/timeout/{id}")
	public Result paymentInfoTimeOut(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfoTimeOut(id);
		return Result.ok().put("result", result);
	}


	public Result paymentInfoTimeOutHandler(Integer id) {
		return Result.error().put("message", "客户端系统繁忙，请稍候再试！");
	}
}
