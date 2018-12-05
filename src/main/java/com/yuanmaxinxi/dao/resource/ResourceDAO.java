package com.yuanmaxinxi.dao.resource;
import com.yuanmaxinxi.domain.resource.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface ResourceDAO{
	int insert(Resource obj);

	int update(Resource obj);

	int delete(Long id);

	Resource selectOneById(Long id);

	List<Resource> selectAll();
	/**
	 * 根据id得到权限  3级子查询
	 * @param id
	 * @return
	 */
	List<Resource> selectAllParentsByAdminId(Long id);
	/**
	 * 根据父级ID和管理员id得到自己资源
	 * @param map
	 * @return
	 */
	List<Resource> selectChildrenByParentIdAndAdminId(Map<String, Long> map);

	List<Resource> selectAllParents();

	List<Resource> selectChildrenByParentId(Long pId);

	List<Long> getAllResourceByRole(Long roleId);

	List<Resource> selectAllByAdminId(Long adminId);


}