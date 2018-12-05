package com.yuanmaxinxi.dao.organize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.organize.Organize;
@Mapper
@Repository
public interface OrganizeDAO {
	int insert(Organize obj);

	int update(Organize obj);

	int delete(Long id);

	Organize selectOneById(Long id);

	List<Organize> selectAll();

	List<Organize> selectAllParents();

	List<Organize> selectChildrenByPId(Long pId);
}
