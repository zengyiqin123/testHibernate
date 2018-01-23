<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+
	request.getServerName()+":"+request.getServerPort()+path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="uc/islogin" method="post">
	<input type="text" name="loginname" value="lisi">
	<input type="password" name="loginpwd" value="123">
	<input type="submit" value="登录">
</form>
<a href="uc/checklogin">跳转至另外一种登录方式</a>
</body>
</html>