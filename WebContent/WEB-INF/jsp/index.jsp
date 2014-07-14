<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库系统首页</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/login.css"/>
</head>

<body>

	<div align=center>
    	    <img src="<%=request.getContextPath() %>/resources/pic/logo1.png"/>
	</div>
	<div align=center>
		<h1>Welcome to the A.T. design database system</h1>
	</div>

    <div id ="mainFrame">
        <h1 id ="prompt">使用前请先登录：</h1>
    	<form id = "loginForm" method="post">
    		用户名:  <input type="text" name="username" /><br />
                                  用户密码: <input type="password" name="password" /><br /> 
    		       <input type="submit" value="用户登录" />
    	</form>
    <h2 id = "promption">${exception.message }</h2>
    </div>	
</body>

</html>

