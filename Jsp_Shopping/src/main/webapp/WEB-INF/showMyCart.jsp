<%@ page language="java" 
		 import="java.util.*,com.liuning.JavaBeans.Books"
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>我的购物车</title>
		<link rel="stylesheet" type="text/css" href="css/comn.css">
	</head>
	<body>
		<h1 style="font: bolder;font-family: monospace;margin-left: 200px;">我的购物车</h1>
		<form action="/ShoppingHandleServlet?type=update" method="post">
			<table border="1" cellspacing="0" style="margin-left: 100px">
				<tr><td>bookId</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td><td>删除</td></tr>
				<%
					ArrayList<Books> arr = (ArrayList<Books>)request.getAttribute("booklist");
					for(int i = 0; i < arr.size(); i++){
						Books book = arr.get(i);
				%>
				<tr>
					<td><%=book.getId() 	%><input type="hidden" name="id" value="<%=book.getId() %>" /></td>
					<td><%=book.getName() 	%></td>
					<td><%=book.getPrice() 	%></td>
					<td><%=book.getPublishHouse() %></td>
					<td><input type="text" name="booknum" value="<%=book.getShoppingNumber() %>">本</td>
					<td><a href="/ShoppingHandleServlet?type=delete&id=<%=book.getId() %>">删除</a></td>
				</tr>
				<%
					}
				%>
				<tr><td colspan="6"><input type="submit" value="update"></td></tr>
				<tr><td colspan="6">购物车的总价格：<%=request.getAttribute("totalPrice") %> 元</td></tr>
			</table>
		</form>
		<a href="/GoHallUI">返回购物大厅</a>
		<a href="/GoMyOrderServlet">提交订单</a>
	</body>
</html>