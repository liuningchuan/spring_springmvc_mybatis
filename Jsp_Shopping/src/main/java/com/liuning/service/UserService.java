package com.liuning.service;

import com.liuning.JavaBeans.Users;
import com.liuning.tools.SqlHelper;

import java.util.ArrayList;

//处理和users相关的业务逻辑
public class UserService {

	//验证用户是否合法的方法
	public boolean checkUsers(Users user){
		
		String sql = "select * from users where id=? and pwd=?";
		String paras[] = {user.getId()+"",user.getPwd()};
		
		ArrayList<Object[]> arr = SqlHelper.executeQuery1(sql, paras);
		if(arr.size() == 0){
			return false;
		}else{
			Object[] objects = (Object[])arr.get(0);
			//把对象数组封装到Users对象
			user.setEmail((String)objects[3]);
			user.setUsername((String)objects[1]);
			user.setGrade(Integer.parseInt(objects[5].toString()));
			return true;
		}
		
	}
}
