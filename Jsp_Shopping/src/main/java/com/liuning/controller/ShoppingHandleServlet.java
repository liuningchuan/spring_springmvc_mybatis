package com.liuning.controller;

import com.liuning.service.BookService;
import com.liuning.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShoppingHandleServlet")
public class ShoppingHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShoppingHandleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//接收type值，区分用户的操作
		String type = request.getParameter("type");
		
		if(type.equals("delete")){
			
			String id = request.getParameter("id");
			
			MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
			myCart.deleteBook(id);
			
			//再次把要显示的商品信息放入request
			//因为request的生命周期很短，所以必须再次放入request域中
			request.setAttribute("booklist", myCart.showMyCart());
			
			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
			
		}else if(type.equals("add")){
			
			String id = request.getParameter("id");
			
			//什么时候创建购物车对象？？
			//当用户登录成功后为其创建一个购物车
			//取出购物车
			MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
			
			myCart.addBook(id, new BookService().getBooksById(id));
			
			//把要显示的数据放入request域中
			//request.setAttribute("booklist", myCart.showMyCart());
			//request.setAttribute("totalPrice", myCart.getTotalPrice());
			
			//request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
			response.sendRedirect("/GoShowMyCart");
		}else if(type.equals("update")){
			String[] bookIds = request.getParameterValues("id");
			String[] nums = request.getParameterValues("booknum");
			MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
			for(int i = 0;i < bookIds.length; i++){
				myCart.updataBook(bookIds[i], nums[i]);
			}
			
			//把要显示的数据放入request域中
			request.setAttribute("booklist", myCart.showMyCart());
			request.setAttribute("totalPrice", myCart.getTotalPrice());
			
			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
