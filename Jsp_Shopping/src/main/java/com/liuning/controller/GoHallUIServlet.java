package com.liuning.controller;

import com.liuning.JavaBeans.Books;
import com.liuning.JavaBeans.Users;
import com.liuning.service.BookService;
import com.liuning.service.MyCart;
import com.liuning.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GoHallUI")
public class GoHallUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoHallUIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//先判断用户是否登陆，如果已经登陆，直接跳转到购物大厅
		if(request.getSession().getAttribute("loginUser") != null){
			//给下一个界面hall.jsp准备要显示的数据
			BookService bookservice = new BookService();
			ArrayList<Books> arr = bookservice.getAllBooks();
			//把arr数据放入request域,request的生命周期最短
			request.setAttribute("books", arr);
			
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			
			return;
		}
		
		//得到从登陆页面传递的用户名和密码
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Users loginUser =new Users(Integer.parseInt(id),password);
		
		UserService loginService = new UserService();
		
		if(loginService.checkUsers(loginUser)){
			
			//把用户名和密码放入session中
			request.getSession().setAttribute("loginUser", loginUser);
			
			//给下一个界面hall.jsp准备要显示的数据
			BookService bookservice = new BookService();
			ArrayList<Books> arr = bookservice.getAllBooks();
			//把arr数据放入request域,request的生命周期最短
			request.setAttribute("books", arr);
			
			//创建一个购物车
			MyCart cart = new MyCart();
			request.getSession().setAttribute("myCart", cart);
			
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		doGet(request, response);
	}

}
