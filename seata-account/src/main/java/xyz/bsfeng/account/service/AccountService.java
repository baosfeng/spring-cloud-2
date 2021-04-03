package xyz.bsfeng.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.bsfeng.account.entity.Account;

import java.util.List;

/**
 * (Account)表服务接口
 *
 * @author bsfeng
 * @since 2021-04-02 22:02:39
 */
public interface AccountService extends IService<Account> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	Account queryById(Long id);

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	List<Account> queryAllByLimit(int offset, int limit);

	/**
	 * 新增数据
	 *
	 * @param account 实例对象
	 * @return 实例对象
	 */
	Account insert(Account account);

	/**
	 * 修改数据
	 *
	 * @param account 实例对象
	 * @return 实例对象
	 */
	Account update(Account account);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
