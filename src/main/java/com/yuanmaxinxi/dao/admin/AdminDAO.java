package com.yuanmaxinxi.dao.admin;
import com.yuanmaxinxi.domain.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface AdminDAO{
	int insert(Admin obj);

	int update(Admin obj);

	int delete(Long id);

	Admin selectOneById(Long id);

	List<Admin> selectAll();
	Admin selectOneByName(String name);

	int insertAdminAndRole(Map<String, Long> map);

	int deleteAdminAndRoleByAdminId(Long adminId);
}