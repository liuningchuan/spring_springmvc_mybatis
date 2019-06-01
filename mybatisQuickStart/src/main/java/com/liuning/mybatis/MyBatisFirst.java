package com.liuning.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.liuning.JavaBeans.User;

public class MyBatisFirst {
	
	public static void main(String[] args) throws IOException {
		
		MyBatisFirst test = new MyBatisFirst();
		test.findUserById();
		//test.insertUser();
		//test.updateUserById();
		//test.deleteUserById();
		
	}

	public void findUserById() throws IOException {
		
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
		// selectOne查询出一条记录
		User user = sqlSession.selectOne("test.findUserById", 26);
		System.out.println(user);

		// 释放资源
		sqlSession.close();
	}
	
	public void insertUser() throws IOException {
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("况天佑");
		user.setSex("男");
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		user.setBirthday(date);
		user.setAddress("香港");
		
		sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit();

		sqlSession.close();
	}
	
	public void deleteUserById() throws IOException {
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUserById", 28);
		
		sqlSession.commit();

		sqlSession.close();
	}
	
	public void updateUserById() throws IOException {
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setId(27);
		user.setUsername("况天佑");
		user.setSex("男");
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		user.setBirthday(date);
		user.setAddress("香港");
		
		sqlSession.update("test.updateUserById", user);
		
		sqlSession.commit();

		sqlSession.close();
	}
	
}
