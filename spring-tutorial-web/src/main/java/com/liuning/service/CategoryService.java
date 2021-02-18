package com.liuning.service;

import java.util.List;

import com.liuning.pojo.Category;

public interface CategoryService {

	//查询所有一级分类
	public List<Category> findAllCategoryList() throws Exception;
	
	//查询Category和CategorySecond（一级分类和二级分类）
	public List<Category> findCategoryAndCategorySecond() throws Exception;
	
	//根据Cid查询Category、CategorySecond、Product
	public Category findCategoryByCid(Integer cid) throws Exception;

}
