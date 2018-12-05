package com.yuanmaxinxi.dao.role;
import com.yuanmaxinxi.domain.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface RoleDAO{
	int insert(Role obj);

	int update(Role obj);

	int delete(Long id);

	Role selectOneById(Long id);

	List<Role> selectAll();

	int insertRoleAndResource(Map<String, Long> map);

	void deleteRoleAndResourceByRoleId(Long roleId);

	List<Role> selectAllByAdminId(Long adminId);
}