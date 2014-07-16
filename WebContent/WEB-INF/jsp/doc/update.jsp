<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/doc/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/main.js"></script>
<title>文档更新</title>
</head>

<body>
        <div id="content">
    	<sf:form method="post" modelAttribute="document">
            <table width="600" cellspacing="0" cellPadding="0" id="listTable" >
                <sf:hidden path="name" />
           		<thead><tr><td colspan="2">修改文档-->${document.name}</td></tr></thead>
    			<!-- <tr>
    				<td>文档名:</td>
    				<td>${document.name}</td>
    			</tr>
 -->
    			<tr>
    				<td>文档路径:</td>
    				<td><sf:input path="path" /> <sf:errors path="path" /></td>
    			</tr>
    			<tr>
    				<td>文档类型：</td>
    				<td><sf:input path="type" /></td>
    			</tr>
    			<tr>
    				<td>文档创建者:</td>
    				<td><sf:input path="creater" /> <sf:errors path="creater" /></td>
    			</tr>
    			<tr>
    				<td>文档创建时间:</td>
    				<td><sf:input path="createTime" /> <sf:errors
    						path="createTime" /></td>
    			</tr>
    			<tr>
            		<td colspan="2" class="centerTd"> <input type="submit" value="修改文档" /> <input type="reset" /> </td>
    			</tr>
    		</table>
    	</sf:form>
        </div>
	<div id="upPage"><a href="javascript:history.go(-1)">返回上一页</a></div>
</body>
</html>