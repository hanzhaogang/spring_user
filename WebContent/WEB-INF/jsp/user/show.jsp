<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户[${user.nickname }]详细信息</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/user/show.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/main.js"></script>
</head>

<body>
	<div id="content">
	<table width="600" cellspacing="0" cellPadding="0" id="listTable" >
            <tbody>
        		<tr>
        			<td class="tableHeader">用户标识:</td>
        			<td>${user.id }</td>
        		</tr>
        		<tr>
        			<td class="tableHeader">用户名:</td>
        			<td>${user.username }</td>
        		</tr>
        		<tr>
        			<td class="tableHeader">用户密码:</td>
        			<td>${user.password }</td>
        		</tr>
        		<tr>
        			<td class="tableHeader">用户昵称:</td>
        			<td>${user.nickname }</td>
        		</tr>
        		<tr>
        			<td>用户邮箱:</td>
        			<td>${user.email }</td>
        		</tr>
            </tbody>
    	</table>	
	</div>
	<div id="upPage"><a href="javascript:history.go(-1)">返回上一页</a></div>
</body>
</html>