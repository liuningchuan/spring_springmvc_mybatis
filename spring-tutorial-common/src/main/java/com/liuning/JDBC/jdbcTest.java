package com.liuning.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTest {
	
	public static void main(String[] args) {
		
		//数据库连接
		Connection ct = null;
		//预编译的Statement，使用预编译的Statement提高数据库性能
		PreparedStatement ps = null;
		//结果集
		ResultSet rs = null;
		
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//通过驱动管理类获取数据库链接
			ct =  DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirst?characterEncoding=utf-8", 
													"root", "open123");
			//定义sql语句 ?表示占位符
			String sql = "select * from users where username = ?";
			//获取预处理statement
			ps = ct.prepareStatement(sql);
			//设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
			ps.setString(1, "liuning");
			//向数据库发出sql执行查询，查询出结果集
			rs =  ps.executeQuery();
			//遍历查询结果集
			while(rs.next()){
				System.out.println(rs.getString("id")+"  "+rs.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
