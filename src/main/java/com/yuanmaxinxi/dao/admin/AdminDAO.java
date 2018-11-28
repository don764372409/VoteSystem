package com.yuanmaxinxi.dao.admin;
import com.yuanmaxinxi.domain.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface AdminDAO{
	int insert(Admin obj);

	int update(Admin obj);

	int delete(Long id);

	Admin selectOneById(Long id);

	List<Admin> selectAll();

}