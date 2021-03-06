<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="欢迎使用气动设计数据管理系统" /></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/dataMain.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/getBrowserType.js"></script>
<decorator:head />

</head>

<body>
    <div id ="mainFrame">
    	<h1> <decorator:title /> </h1>
        <div id="hrefs">
        	<c:if test="${not empty loginUser}">
        		<span id="currentUser">
            		<a href="<%=request.getContextPath()%>/login">返回系统首页</a>
            		<a href="<%=request.getContextPath()%>/doc/add">文档添加</a>
            		<a href="<%=request.getContextPath()%>/doc/treeList">文档列表</a>
            		<a href="<%=request.getContextPath()%>/doc/search">文档检索</a>
        		</span>
                <span id="logout">
                                            当前用户:${loginUser.nickname }
            		<a href="<%=request.getContextPath()%>/logout">退出系统</a>
        		</span>
            </c:if>
        </div>
    	<hr/>
    	<decorator:body />
    </div>
    <%@ include file="bottom.jsp" %>

</body>

</html>