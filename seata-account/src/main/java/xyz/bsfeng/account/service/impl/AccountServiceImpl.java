package xyz.bsfeng.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.bsfeng.account.dao.AccountDao;
import xyz.bsfeng.account.entity.Account;
import xyz.bsfeng.account.service.AccountService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Account)表服务实现类
 *
 * @author bsfeng
 * @since 2021-04-02 22:02:40
 */
@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

	@Resource
	private AccountDao accountDao;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public Account queryById(Long id) {
		return this.accountDao.queryById(id);
	}

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	@Override
	public List<Account> queryAllByLimit(int offset, int limit) {
		return this.accountDao.queryAllByLimit(offset, limit);
	}

	/**
	 * 新增数据
	 *
	 * @param account 实例对象
	 * @return 实例对象
	 */
	@Override
	public Account insert(Account account) {
		this.accountDao.insert(account);
		return account;
	}

	/**
	 * 修改数据
	 *
	 * @param account 实例对象
	 * @return 实例对象
	 */
	@Override
	public Account update(Account account) {
		this.accountDao.update(account);
		return this.queryById(account.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.accountDao.deleteById(id) > 0;
	}

}
