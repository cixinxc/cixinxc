<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>此心闲处</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="shortcut icon" href="images/ico.jpg" type="image/x-icon" />
</head>

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
    <font size="8">
        <a href="/cixinxc/user/toLogin?url=user/login" style="text-decoration:none">
            此心闲处
        </a>
    </font>
</div>
<font color="white">
    <!-- 葬情之地 -->
</font>
</body>
</html>
