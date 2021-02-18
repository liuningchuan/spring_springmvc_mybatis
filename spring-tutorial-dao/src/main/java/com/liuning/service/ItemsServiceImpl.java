package com.liuning.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.liuning.mapper.ItemsMapper;
import com.liuning.mapper.ItemsMapperCustom;
import com.liuning.pojo.Items;
import com.liuning.pojo.ItemsCustom;
import com.liuning.pojo.ItemsQueryVo;
import com.liuning.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		//通过ItemsMapperCustom查询数据库
		//从service层传到dao层？
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {

		Items items = itemsMapper.selectByPrimaryKey(id);
		//中间对商品进行业务处理
		//.....
		//返回ItemsCustom
		
		System.out.println("调用了ItemsServiceImpl.findItemsById");
		
		ItemsCustom itemsCustom = null;
		//将items的属性值拷贝到itemsCustom
		if(items != null){
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验 id是否为空，如果为空抛出异常
				
		//更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
		//updateByPrimaryKeyWithBLOBs要求必须转入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);		
	}

}
