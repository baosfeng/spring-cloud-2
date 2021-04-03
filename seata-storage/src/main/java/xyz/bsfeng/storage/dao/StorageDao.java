package xyz.bsfeng.storage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import xyz.bsfeng.storage.entity.Storage;

import java.util.List;

/**
 * (Storage)表数据库访问层
 *
 * @author bsfeng
 * @since 2021-04-02 21:56:54
 */
public interface StorageDao extends BaseMapper<Storage> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	Storage queryById(Long id);

	/**
	 * 查询指定行数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	List<Storage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


	/**
	 * 通过实体作为筛选条件查询
	 *
	 * @param storage 实例对象
	 * @return 对象列表
	 */
	List<Storage> queryAll(Storage storage);

	/**
	 * 新增数据
	 *
	 * @param storage 实例对象
	 * @return 影响行数
	 */
	int insert(Storage storage);

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<Storage> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<Storage> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<Storage> 实例对象列表
	 * @return 影响行数
	 */
	int insertOrUpdateBatch(@Param("entities") List<Storage> entities);

	/**
	 * 修改数据
	 *
	 * @param storage 实例对象
	 * @return 影响行数
	 */
	int update(Storage storage);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 影响行数
	 */
	int deleteById(Long id);

}

