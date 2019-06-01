package com.liuning.service;

import java.util.List;

import com.liuning.pojo.ItemsCustom;
import com.liuning.pojo.ItemsQueryVo;

public interface ItemsService {

	/**
	 * 商品查询列表
	 * @param itemsQueryVo
	 * @return List<ItemsCustom>
	 * @throws Exception
	 * @author LiuNing
	 */
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	/**
	 * 根据id查询商品信息
	 * @param id 商品的ID
	 * @return ItemsCustom
	 * @throws Exception
	 * @author LiuNing
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	/**
	 * 根据id修改商品信息
	 * @param id 商品的ID
	 * @param itemsCustom 修改的商品信息
	 * @throws Exception
	 * @author LiuNing
	 */
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
	
}
