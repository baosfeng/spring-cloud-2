package xyz.bsfeng.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.bsfeng.account.entity.Account;
import xyz.bsfeng.account.service.AccountService;

import javax.annotation.Resource;

/**
 * (Account)表控制层
 *
 * @author bsfeng
 * @since 2021-04-02 22:02:41
 */
@RestController
@RequestMapping("account")
public class AccountController {

	/**
	 * 服务对象
	 */
	@Resource
	private AccountService accountService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("selectOne")
	public Account selectOne(Long id) {
		return this.accountService.queryById(id);
	}

	@GetMapping("updateAccount")
	public Account updateAccount(@RequestParam Integer userId, @RequestParam Double money) {
		Account account = accountService.getOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId));
		account.setResidue(account.getResidue() - money);
		account.setUsed(account.getUsed() + money);
		return accountService.update(account);
	}

}
