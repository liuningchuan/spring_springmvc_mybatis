package com.liuning.mapper;

import java.util.List;

import com.liuning.pojo.Product;

public interface ProductMapper {

	//查询热门Product列表
	public List<Product> findHotProductList() throws Exception;

	//查询最新Product列表
	public List<Product> findNewProductList() throws Exception;
	
	//根据pid查询Product
	public Product findProductById(Integer pid) throws Exception;

}
