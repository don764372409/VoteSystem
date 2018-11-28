package com.yuanmaxinxi.dao.resource;
import com.yuanmaxinxi.domain.resource.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface ResourceDAO{
	int insert(Resource obj);

	int update(Resource obj);

	int delete(Long id);

	Resource selectOneById(Long id);

	List<Resource> selectAll();

}