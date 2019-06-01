package com.liuning.service;

import com.liuning.JavaBeans.Books;
import com.liuning.tools.SqlHelper;

import java.util.ArrayList;

public class BookService {
	
	//根据书的编号，返回一个Books实例
	public Books getBooksById(String id){
		
		String sql = "select * from books where id=?";
		String paras[] = {id};
		
		ArrayList<Object[]> arr = SqlHelper.executeQuery1(sql, paras);
		Books book = new Books();
		if(arr.size() == 1){
			Object obj[] = arr.get(0);
			
			
			book.setId(Integer.parseInt(obj[0].toString()));
			book.setName(obj[1].toString());
			book.setAuthor(obj[2].toString());
			book.setPublishHouse(obj[3].toString());
			book.setPrice(Integer.parseInt(obj[4].toString()));
			book.setNums(Integer.parseInt(obj[5].toString()));
			
		}
		return book;
	}

	//得到所有的书籍信息（分页）
	public ArrayList<Books> getAllBooks(){
		
		String sql = "select * from books where 1=?";
		String paras[] = {"1"};
		
		ArrayList<Object[]> arr = SqlHelper.executeQuery1(sql, paras);
		ArrayList<Books> bookArray = new ArrayList<Books>(); 
		for(int i = 0;i < arr.size(); i++){
			Object obj[] = arr.get(i);
			Books book = new Books();
			
			book.setId(Integer.parseInt(obj[0].toString()));
			book.setName(obj[1].toString());
			book.setAuthor(obj[2].toString());
			book.setPublishHouse(obj[3].toString());
			book.setPrice(Integer.parseInt(obj[4].toString()));
			book.setNums(Integer.parseInt(obj[5].toString()));
			
			bookArray.add(book);
		}
		return bookArray;
	}
}
