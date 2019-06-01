<%@ page language="java" 
		 import="java.util.*,com.liuning.JavaBeans.*"
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			
			function goSubmitOrder() {
				window.location.href="/SubmitOrderServlet";
			}
		
		</script>
	</head>
	<body>
		<h1>我的订单</h1>
		<h1>我的个人信息</h1>
		<table style="border-collapse: collapse;" border="1">
			<tr><td colspan="2">用户个人信息</td></tr>
			<tr><td>用户名	</td><td><%=((Users)session.getAttribute("loginUser")).getUsername() %></td></tr>
			<tr><td>电子邮箱	</td><td><%=((Users)session.getAttribute("loginUser")).getEmail()    %></td></tr>
			<tr><td>用户级别	</td><td><%=((Users)session.getAttribute("loginUser")).getGrade()    %></td></tr>
		</table><br/>
		
		<table style="border-collapse: collapse;" border="1">
			<tr><td>bookId</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td></tr>
			<%
				//循环显示购物车的商品
				ArrayList<Books> arr = (ArrayList<Books>)request.getAttribute("orderinfo");
				for(int i = 0; i < arr.size(); i++){
					Books book = arr.get(i);
			%>
			<tr>
				<td><%=book.getId() 			%></td>
				<td><%=book.getName() 			%></td>
				<td><%=book.getPrice() 			%></td>
				<td><%=book.getPublishHouse() 	%></td>
				<td><%=book.getShoppingNumber()	%></td>
			</tr>
			<%
				}
			%>
			<tr><td colspan="5">总价：<%=request.getAttribute("totalPrice") %>元</td></tr>
		</table>
		
		<input type="button" value="确认订单" onclick="goSubmitOrder()">
	</body>
</html>