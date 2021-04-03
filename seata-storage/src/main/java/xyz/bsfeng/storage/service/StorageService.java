package xyz.bsfeng.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.bsfeng.storage.entity.Storage;

import java.util.List;

/**
 * (Storage)表服务接口
 *
 * @author bsfeng
 * @since 2021-04-02 21:56:55
 */
public interface StorageService extends IService<Storage> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	Storage queryById(Long id);

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	List<Storage> queryAllByLimit(int offset, int limit);

	/**
	 * 新增数据
	 *
	 * @param storage 实例对象
	 * @return 实例对象
	 */
	Storage insert(Storage storage);

	/**
	 * 修改数据
	 *
	 * @param storage 实例对象
	 * @return 实例对象
	 */
	Storage update(Storage storage);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
