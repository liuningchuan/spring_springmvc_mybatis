<%@ page language="java"
         contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"
%>
<!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>JspShopping</title>
    </head>
    <body>
        <h1>登陆界面</h1>
        <form action="/GoHallUI" method="post">
            <table border="0">
                <tr>
                    <td>用户ID</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </body>
</html>