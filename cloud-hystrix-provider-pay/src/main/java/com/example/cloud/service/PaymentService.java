package com.example.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

	//成功
	public String paymentInfoOK(Integer id) {
		return "线程池：" + Thread.currentThread().getName() + "   paymentInfoOK,id：  " + id + "\t" + "哈哈哈";
	}

	//失败
	@HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
			//2秒钟以内就是正常的业务逻辑
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public String paymentInfoTimeOut(Integer id) {
		int timeNumber = 3;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "线程池：" + Thread.currentThread().getName() + "   paymentInfoTimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
	}

	public String paymentInfoTimeOutHandler(Integer id) {
		return "系统繁忙，当前处理的id为：" + id;
	}

	//服务熔断
	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
			//是否开启断路器
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
			//时间范围
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			//在指定的时间范围内达到请求次数便会熔断
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			//在指定的时间范围内失败率达到多少后跳闸
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
	})
	public String paymentCircuitBreaker(Integer id) {
		if (id < 0) {
			throw new RuntimeException("*****id 不能负数");
		}
		String serialNumber = UUID.randomUUID().toString().replace("-", "");
		return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
	}

	public String paymentCircuitBreaker_fallback(Integer id) {
		return "触发服务熔断，一段时间内不再进行响应，当前请求的id为" + id;
	}


}

