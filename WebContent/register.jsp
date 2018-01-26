<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
   <center><h1>会员注册</h1>
   <form action="<%=request.getContextPath() %>/RegisterServlet" method="post">
   <table border="2">
         <tr>
             <td>用户名</td>
             <td><input type="text" name="username"></td>
         </tr>
         <tr>
             <td>密码</td>
             <td><input type="password" name="password"></td>
         </tr>
         <tr>
             <td>确定密码</td>
             <td><input type="password" name="surepassword"></td>
         </tr>
         <tr>
             <td>邮箱</td>
             <td><input type="text" name="email"></td>
         </tr>
         <tr align="center">
             <td colspan="2"><input type="submit" value="确定"></td>
         </tr>
   </form>
</body>
</html>