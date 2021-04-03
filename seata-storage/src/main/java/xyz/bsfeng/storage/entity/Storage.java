package xyz.bsfeng.storage.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Storage)实体类
 *
 * @author bsfeng
 * @since 2021-04-02 21:56:51
 */
@TableName("t_storage")
public class Storage implements Serializable {

	private static final long serialVersionUID = -11067644087344567L;

	private Long id;
	/**
	 * 产品id
	 */
	private Long productId;
	/**
	 * 总库存
	 */
	private Integer total;
	/**
	 * 已用库存
	 */
	private Integer used;
	/**
	 * 剩余库存
	 */
	private Integer residue;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Integer getResidue() {
		return residue;
	}

	public void setResidue(Integer residue) {
		this.residue = residue;
	}

}
