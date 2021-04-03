package xyz.bsfeng.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.bsfeng.storage.dao.StorageDao;
import xyz.bsfeng.storage.entity.Storage;
import xyz.bsfeng.storage.service.StorageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Storage)表服务实现类
 *
 * @author bsfeng
 * @since 2021-04-02 21:56:56
 */
@Service("storageService")
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements StorageService {

	@Resource
	private StorageDao storageDao;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public Storage queryById(Long id) {
		return this.storageDao.queryById(id);
	}

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	@Override
	public List<Storage> queryAllByLimit(int offset, int limit) {
		return this.storageDao.queryAllByLimit(offset, limit);
	}

	/**
	 * 新增数据
	 *
	 * @param storage 实例对象
	 * @return 实例对象
	 */
	@Override
	public Storage insert(Storage storage) {
		this.storageDao.insert(storage);
		return storage;
	}

	/**
	 * 修改数据
	 *
	 * @param storage 实例对象
	 * @return 实例对象
	 */
	@Override
	public Storage update(Storage storage) {
		this.storageDao.update(storage);
		return this.queryById(storage.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.storageDao.deleteById(id) > 0;
	}
}
