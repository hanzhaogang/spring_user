<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/user/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/user/update.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<title>用户更新</title>
</head>

<body>
    <div id="content">
    	<sf:form method="post" modelAttribute="user">
        	<table width="800" cellspacing="0" cellPadding="0" id="listTable" >
   				<sf:hidden path="username" />
        		<thead><tr><td colspan="2">修改用户-->${user.username}</td></tr></thead>
                <tbody>
                <!-- 
        			<tr>
        				<td>用户名:</td>
        				<td>${user.username }</td>
        			</tr> -->
        			<tr>
        				<td>用户密码:</td> <td><sf:password path="password" />  </td>
        			</tr>
        			<tr>
        				<td>用户昵称:</td> <td><sf:input path="nickname" /> </td>
        			</tr>
        			<tr>
        				<td>用户邮箱:</td> <td><sf:input path="email" /> </td>
        			</tr>
        			<tr>
        				<td colspan="2" class="centerTd"> <input type="submit" value="修改用户" /> <input type="reset" /> </td>
        			</tr>
    			</tbody>
    		</table>
    	</sf:form>
    </div>
	<div id="upPage"><a href="javascript:history.go(-1)">返回上一页</a></div>
</body>
</html>