<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="欢迎使用用户管理系统" /></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/accountMain.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/getBrowserType.js"></script>
<!--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/bottom.css"/>  -->
<decorator:head />
</head>

<body>
    <div id ="mainFrame">
	<h1> <decorator:title /></h1>
    <div id="hrefs">
    	<c:if test="${not empty loginUser}">
    	<span id ="currentUser" >
    		<a href="<%=request.getContextPath()%>/login">返回系统首页</a>
    		<a href="<%=request.getContextPath()%>/user/add">用户添加</a>
    		<a href="<%=request.getContextPath()%>/user/users">用户列表</a>
        </span>
    	<span id="logout">当前用户:${loginUser.nickname } <a id="exit" href="<%=request.getContextPath()%>/logout">退出登录</a></span>
    	
        </c:if>
    </div>
	<hr/>
	<decorator:body />
    <%@ include file="bottom.jsp" %>
    </div>
</body>

</html>