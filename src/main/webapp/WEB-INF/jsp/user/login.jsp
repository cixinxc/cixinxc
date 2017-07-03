<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script language="javascript">
  	function login(){
  		var userName = document.getElementById("userName");
  		var password = document.getElementById("password");
  	//	if(userName.value==""){
  	//		alert("用户名不能为空!");
  	//	}else if(userName.value.length<6){
  	//		alert("用户名长度不能小于6位!");
  	//	}else if(pssword.value==""){
  	//		alert("密码不能为空!");
  	//	}else{
  			return true;
  	//	}
	//  return false;
  	}
  	function reset(){
  		document.getElementById("userName").text="";
  		document.getElementById("password").text="";
  	}
  </script>
  <style type="text/css"> 
  	 body { font-size:12px;font-family:tahoma;}
	 div {
		position: absolute;
		left: 40%;
		top: 35%;
	 }
  </style>
  <body>
 	 用户名:${user.userName}
    <div class="wrap">
		<form method="post" id="loginForm" action="user/login">
  			用户名:<input type="text" id="userName" name="userName"/>
  			<br/><br/>
  			密&nbsp;&nbsp;&nbsp;码:<input type="password" id="password" name="password"/>
			<br/><br/>
			<a href="#">忘记密码?</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/cixinxc/user/toLogin?url=user/register">马上注册!</a>
			<br/><br/>
			<input type="submit" id="loginButton" value="登录" onclick="return login()"/>
			<input type="button" id="resetButton" value="清空" onclick="reset()"/>
  		</form>
  	</div>
  </body>
</html>
