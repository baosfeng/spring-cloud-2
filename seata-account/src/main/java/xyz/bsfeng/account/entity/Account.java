package xyz.bsfeng.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author bsfeng
 * @since 2021-04-02 22:02:36
 */
@TableName("t_account")
public class Account implements Serializable {

	private static final long serialVersionUID = -60496070754332045L;
	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 总额度
	 */
	private Double total;
	/**
	 * 已用余额
	 */
	private Double used;
	/**
	 * 剩余可用额度
	 */
	private Double residue;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getUsed() {
		return used;
	}

	public void setUsed(Double used) {
		this.used = used;
	}

	public Double getResidue() {
		return residue;
	}

	public void setResidue(Double residue) {
		this.residue = residue;
	}

}
