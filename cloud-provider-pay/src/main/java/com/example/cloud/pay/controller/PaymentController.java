package com.example.cloud.pay.controller;

import com.example.cloud.common.entity.Payment;
import com.example.cloud.common.entity.Result;
import com.example.cloud.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author bsfeng
 * @since 2020-08-13 12:08:41
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

	@Value("${server.port}")
	private int serverPort;

	/**
	 * 服务对象
	 */
	@Resource
	private PaymentService paymentService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("select/{id}")
	public Result selectOne(@PathVariable Long id) {
		Payment payment = this.paymentService.queryById(id);
		return payment != null
				? Result.ok().put("data", payment).put("port", serverPort)
				: Result.error();
	}

	/**
	 * 插入数据
	 *
	 * @param payment 待插入的对象
	 * @return 插入成功的状态或失败的状态
	 */
	@PostMapping("save")
	public Result save(@RequestBody Payment payment) {
		Payment insert = this.paymentService.insert(payment);
		return insert.getId() > 0
				? Result.ok()
				: Result.error();
	}

}