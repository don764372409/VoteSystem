package com.yuanmaxinxi.dao.role;
import com.yuanmaxinxi.domain.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface RoleDAO{
	int insert(Role obj);

	int update(Role obj);

	int delete(Long id);

	Role selectOneById(Long id);

	List<Role> selectAll();

}