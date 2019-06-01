package com.liuning.service;

import com.liuning.JavaBeans.Books;
import com.liuning.JavaBeans.Users;

import java.sql.*;
import java.util.ArrayList;

public class OrderService {

	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static Connection ct=null;
	
	private static final String sqlDriver="com.mysql.jdbc.Driver";
	private static final String url1="jdbc:mysql://localhost:3306/myjsp";
	private static final String url2="root";
	private static final String url3="open123";
	
	//下订单涉及到2张表
	public void submitOrder(MyCart myCart, Users users){
		
		String sql = "insert into orders values(null,?,?,now())";
		
		try {
			Class.forName(sqlDriver);
			ct=DriverManager.getConnection(url1,url2,url3);
			
			//为了保证我们的订单号是稳定的，所以将其事务隔离级别升级（可串行）
			ct.setAutoCommit(false);
			ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			ps = ct.prepareStatement(sql);
			ps.setInt(1, users.getId());
			ps.setInt(2, myCart.getTotalPrice());
			ps.executeUpdate();
			
			//如何得到刚刚插入的订单记录的订单号！！
			sql = "select max(id) from orders";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			int orderId = 0;
			if(rs.next()){
				orderId = rs.getInt(1);
			}
			
			//生成订单细节表
			ArrayList<Books> arr = myCart.showMyCart();
			for(int i =0; i < arr.size(); i++){
				Books book = arr.get(i);
				String sql1 = "insert into ordersitem values(null,?,?,?)";
				ps = ct.prepareStatement(sql1);
				ps.setInt(1, orderId);
				ps.setInt(2, book.getId());
				ps.setInt(3, book.getShoppingNumber());
				ps.executeUpdate();
			}
			
			//整体提交
			ct.commit();
				
		} catch (Exception e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			System.out.println("插如订单表");
		}
	}
}
