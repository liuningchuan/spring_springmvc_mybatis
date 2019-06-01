<%@ page language="java" 
		 import="java.util.*,com.liuning.JavaBeans.Books"
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>欢迎访问购物大厅</h1>
		<table border="1" cellpadding="1" cellspacing="0" >
			<tr><td>书名</td><td>价格</td><td>出版社</td><td>购买</td></tr>
			<%
				ArrayList<Books> array = (ArrayList<Books>)request.getAttribute("books");
				//request.getAttribute("***")得到的是一个默认为Object的类型，当把他们转成List<***>时，
				//编译器认为有可能会出错，所以提示这个类型安全
				for(int i = 0;i < array.size(); i++){
					Books book = (Books)array.get(i);
					%>
					<tr>
						<td><%=book.getName() %></td>
						<td><%=book.getPrice() %></td>
						<td><%=book.getPublishHouse() %></td>
						<td><a href="/ShoppingHandleServlet?type=add&id=<%=book.getId() %>">购买</a></td>
					</tr>
					<%
				}
			%>
			<tr><td colspan="3"><input type="button" value="查看购物车"></td><td><input type="button" value="结算"></td></tr>	
		</table>
		
		<a href="/index.jsp">返回重新登陆</a>
	</body>
</html>