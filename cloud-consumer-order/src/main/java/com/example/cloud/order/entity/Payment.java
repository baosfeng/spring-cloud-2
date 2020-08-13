package com.example.cloud.order.entity;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author bsfeng
 * @since 2020-08-13 12:08:36
 */
public class Payment implements Serializable {

	private static final long serialVersionUID = 754736088924581815L;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 支付流水号
	 */
	private String serial;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

}