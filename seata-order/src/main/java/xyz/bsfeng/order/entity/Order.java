package xyz.bsfeng.order.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author bsfeng
 * @since 2021-04-02 11:07:10
 */
@Data
@Builder
public class Order implements Serializable {

	private static final long serialVersionUID = 946520008401803497L;

	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 产品id
	 */
	private Long productId;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 金额
	 */
	private Double money;
	/**
	 * 订单状态：0：创建中; 1：已完结
	 */
	private Integer status;

}
