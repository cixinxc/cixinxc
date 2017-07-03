<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
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
  	function register(){
  		var userName = document.getElementById("userName");
  		var password = document.getElementById("password");
  		var passwordR = document.getElementById("passwordR");
  	//	if(userName.value==""){
  	//		alert("用户名不能为空!");
  	//	}else if(userName.value.length<6){
  	//		alert("用户名长度不能小于6位!");
  	//	}else if(pssword.value==""){
  	//		alert("密码不能为空!");
  	//	}else if(password.value!=passwordR.value){
  	//		alert("两次输入的密码必须一致!");	
  	//	}else{
  			return true;
  	//	}
	//  return false;
  	}
  	function reset(){
  		document.getElementById("userName").text="";
  		document.getElementById("password").text="";
  		document.getElementById("passwordR").text="";
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
		<form method="post" id="registerForm" action="user/register">
  			用户名:<input type="text" id="userName" name="userName"/>
  			<br/><br/>
  			密&nbsp;&nbsp;&nbsp;码:<input type="password" id="password" name="password"/>
			<br/><br/>
			重复密码:<input type="password" id="passwordR" name="passwordR"/>
			<br/><br/>
			<input type="submit" id="loginButton" value="注册" onclick="return register()"/>
			<input type="button" id="resetButton" value="清空" onclick="reset()"/>
  		</form>
  	</div>
  </body>
</html>
