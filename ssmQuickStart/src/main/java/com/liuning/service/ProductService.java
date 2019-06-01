package com.liuning.service;

import java.util.List;

import com.liuning.pojo.Product;

public interface ProductService {

	//查询热门商品
	public List<Product> findHotProductList() throws Exception;

	//查询最新商品
	public List<Product> findNewProductList() throws Exception;

	//根据商品id查询商品
	public Product findProductById(Integer pid) throws Exception;

}
