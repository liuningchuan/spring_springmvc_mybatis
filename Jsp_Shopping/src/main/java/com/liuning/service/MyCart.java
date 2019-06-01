package com.liuning.service;

import com.liuning.JavaBeans.Books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MyCart {

	HashMap<String,Books> hm = new HashMap<String,Books>();
	
	//添加书 更有效的一种方法
	public void addBook2(String id){
		if(hm.containsKey(id)){
			Books book = hm.get(id);
			//shoppingNumber+1
			int shoppingNmu = book.getShoppingNumber();
			book.setShoppingNumber(shoppingNmu+1);
		}else{
			hm.put(id, new BookService().getBooksById(id));
		}
	}
	
	//添加书
	public void addBook(String id,Books book){
		if(hm.containsKey(id)){
			book = hm.get(id);
			//shoppingNumber+1
			int shoppingNmu = book.getShoppingNumber();
			book.setShoppingNumber(shoppingNmu+1);
			hm.put(id, book);
		}else{
			hm.put(id, book);
		}
	}
	
	//删除书
	public void deleteBook(String id){
		hm.remove(id);
	}
	
	
	//更新书
	public void updataBook(String id,String nums){
		Books book = hm.get(id);
		book.setShoppingNumber(Integer.parseInt(nums));
	}
	
	
	//清空书
	public void clearBook(){
		hm.clear();
	}
	
	//显示该购物车中的所有商品信息
	public ArrayList<Books> showMyCart(){
		ArrayList<Books> arr = new ArrayList<Books>();
		//遍历HashMap
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			String id = it.next();
			Books book = hm.get(id);
			arr.add(book);
		}
		return arr;
	}
	
	
	//计算购物车的总价
	public int getTotalPrice(){
		
		int totalPrice = 0;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			String bookId = it.next();
			Books book = hm.get(bookId);
			totalPrice += book.getPrice() * book.getShoppingNumber();
		}
		
		return totalPrice;
	}
	
}
