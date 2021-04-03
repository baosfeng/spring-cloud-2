package xyz.bsfeng.storage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.bsfeng.storage.entity.Storage;
import xyz.bsfeng.storage.service.StorageService;

import javax.annotation.Resource;

/**
 * (Storage)表控制层
 *
 * @author bsfeng
 * @since 2021-04-02 21:56:58
 */
@RestController
@RequestMapping("storage")
public class StorageController {

	/**
	 * 服务对象
	 */
	@Resource
	private StorageService storageService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("selectOne")
	public Storage selectOne(Long id) {
		return this.storageService.queryById(id);
	}

	@GetMapping("updateStorage")
	public Storage updateStorage(@RequestParam Integer productId, @RequestParam Integer used) {
		Storage storage = storageService.getOne(new LambdaQueryWrapper<Storage>().eq(Storage::getProductId, productId));
		storage.setResidue(storage.getResidue() - used);
		storage.setUsed(storage.getUsed() + used);
		return storageService.update(storage);
	}
}
