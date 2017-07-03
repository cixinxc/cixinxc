<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
HttpSession ssion = request.getSession(); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>showUser</title>  
  </head>  
    
  <body>  
	用户名:${user.userName}
	<br/>
	${message}
  </body>  
</html>  