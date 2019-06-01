package com.liuning.mapper;

import java.util.List;

import com.liuning.pojo.Category;

public interface CategoryMapper {

	//根据cid查询Category信息
	public Category findCategoryByCid(Integer cid) throws Exception;
	
	//查询Category列表
	public List<Category> findCategoryList()throws Exception;
	
	//查询Category和CategorySecond（一级分类和二级分类）
	public List<Category> findCategoryAndCategorySecond() throws Exception;
	
}
