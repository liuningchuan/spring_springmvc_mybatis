package com.liuning.controller;

import com.liuning.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 解决页面刷新问题
 */
@WebServlet("/GoShowMyCart")
public class GoShowMyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoShowMyCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
		//把要显示的数据放入request域中
		request.setAttribute("booklist", myCart.showMyCart());
		request.setAttribute("totalPrice", myCart.getTotalPrice());
		
		request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
