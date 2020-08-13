package com.example.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

	//成功
	public String paymentInfoOK(Integer id) {
		return "线程池：" + Thread.currentThread().getName() + "   paymentInfoOK,id：  " + id + "\t" + "哈哈哈";
	}

	//失败
	public String paymentInfoTimeOut(Integer id) {
		int timeNumber = 3;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "线程池：" + Thread.currentThread().getName() + "   paymentInfoTimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
	}

}

