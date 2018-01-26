<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员登录</title>
</head>
<body>
<center><h1>会员登录</h1><br>
  <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
     <table border="1">
     <tr>
         <td>登录名</td>
         <td><input type="text" name="username"></td>
     </tr>
     <tr>
         <td>密码</td>
         <td><input type="password" name="password"></td>
     </tr>
     <tr align="center">
         <td colspan="1"><input type="submit" value="登录"></td>
         <td colspan="1"><a href="register.jsp">注册</a></td>
     </tr>
     
     
  </form>
</body>
</html>