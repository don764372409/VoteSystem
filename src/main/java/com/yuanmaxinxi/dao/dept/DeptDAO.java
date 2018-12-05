package com.yuanmaxinxi.dao.dept;
import com.yuanmaxinxi.domain.dept.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface DeptDAO{
	int insert(Dept obj);

	int update(Dept obj);

	int delete(Long id);

	Dept selectOneById(Long id);

	List<Dept> selectAll();

	List<Dept> selectAllByOrganizeId(Long orgId);

	Dept selectCurrentDeptByAdminId(Long adminId);

	List<Dept> selectAllByAdminIdToOrg(Long adminId);

}