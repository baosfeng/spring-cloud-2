package com.example.cloud.order.service;

import org.springframework.stereotype.Service;
/**
 * @author bsfeng
 */
@Service
public class PaymentHystrixServiceImpl implements IPaymentHystrixService {

	@Override
	public String paymentInfoSuccess(Integer id) {
		return "paymentInfoOK 的错误处理";
	}

	@Override
	public String paymentInfoTimeOut(Integer id) {
		return "paymentInfoTimeOut 的错误处理";
	}
}
