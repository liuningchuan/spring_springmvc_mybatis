
package com.liuning.tools;

import java.sql.*;
import java.util.ArrayList;

public class SqlHelper {

	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static Connection ct=null;
	
	private static final String sqlDriver="com.mysql.jdbc.Driver";
	private static final String url1="jdbc:mysql://localhost:3306/myjsp?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	private static final String url2="root";
	private static final String url3="open123";
	
	public static void connectDatabase(){
		try {
			Class.forName(sqlDriver);
			ct=DriverManager.getConnection(url1,url2,url3);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("成功连接到数据库");
		}
	}
	
	//把对数据库的增，删，改写成一个函数
	public static boolean executeUpdate(String sql,String[] paras){
		
		connectDatabase();
		
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	
	//数据库的查询操作
	public static ResultSet executeQuery(String sql,String[] paras){
		
		connectDatabase();
		
		try {	
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(){
		try {
			if(rs!=null){	rs.close();	}
			if(ps!=null){	ps.close();	}
			if(ct!=null){	ct.close();	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/******对SqlHelper类进行改进********/	
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection ct){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ct != null){
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static ArrayList<Object[]> executeQuery1(String sql,String[] paras){
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet res = null;
		
		ArrayList<Object[]> arr = new ArrayList<Object[]>();
		
		try {
			Class.forName(sqlDriver);
			conn=DriverManager.getConnection(url1,url2,url3);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("成功连接到数据库");
		}
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			if(paras != null && !paras.equals("")){
				for(int i = 0;i < paras.length; i++){
					pstmt.setString(i+1, paras[i]);
				}
			}
			res = pstmt.executeQuery();
			
			
			ResultSetMetaData rsmd = res.getMetaData();
			int column = rsmd.getColumnCount();
			
			while(res.next()){
				Object[] obj = new Object[column];
				for(int i = 1; i <= column; i++){
					obj[i-1] = res.getObject(i);
				}
				arr.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(res, pstmt, conn);
		}
		
		return arr;
	}
	
}
