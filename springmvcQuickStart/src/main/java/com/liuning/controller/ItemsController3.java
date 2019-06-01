package com.liuning.controller;
/**
 * Description:注解开发Handler
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liuning.JavaBeans.Items;

//使用Controller标识 它是一个控制器
@Controller
public class ItemsController3 {
	
	//@RequestMapping实现 对queryItems方法和url进行映射，一个方法对应一个url
	@RequestMapping("/queryItems4")
	public ModelAndView queryItems() throws Exception{
		
		List<Items> itemsList = new ArrayList<Items>();
		
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		
		return modelAndView;
		
	}
	
	//定义其它的方法
	//商品添加
	//商品修改

}
