package com.liuning.controller;

import com.liuning.JavaBeans.Books;
import com.liuning.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GoMyOrderServlet")
public class GoMyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoMyOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
		
		ArrayList<Books> arr = myCart.showMyCart();
		int totalPrice = myCart.getTotalPrice();
		
		request.setAttribute("orderinfo", arr);
		request.setAttribute("totalPrice", totalPrice);
		
		request.getRequestDispatcher("/WEB-INF/showMyOrder.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		doGet(request, response);
	}

}
