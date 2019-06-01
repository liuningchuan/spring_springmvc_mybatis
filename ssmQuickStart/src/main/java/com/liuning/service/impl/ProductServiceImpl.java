package com.liuning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.liuning.mapper.ProductMapper;
import com.liuning.pojo.Product;
import com.liuning.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> findHotProductList() throws Exception {
		// TODO Auto-generated method stub
		return productMapper.findHotProductList();
	}

	@Override
	public List<Product> findNewProductList() throws Exception {
		// TODO Auto-generated method stub
		return productMapper.findNewProductList();
	}

	@Override
	public Product findProductById(Integer pid) throws Exception {
		// TODO Auto-generated method stub
		return productMapper.findProductById(pid);
	}
	
}
