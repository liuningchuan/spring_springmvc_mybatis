package com.liuning.mapper;

import java.util.List;

import com.liuning.pojo.ItemsCustom;
import com.liuning.pojo.ItemsQueryVo;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
}