package com.example.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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

}

