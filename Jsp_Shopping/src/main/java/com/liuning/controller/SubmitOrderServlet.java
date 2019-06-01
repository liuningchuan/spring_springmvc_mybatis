package com.liuning.controller;

import com.liuning.JavaBeans.Users;
import com.liuning.service.MyCart;
import com.liuning.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubmitOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		try {
			OrderService order = new OrderService();
			
			MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
			Users users = (Users) request.getSession().getAttribute("loginUser");
			
			order.submitOrder(myCart, users);

			request.getRequestDispatcher("/WEB-INF/orderOk.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
