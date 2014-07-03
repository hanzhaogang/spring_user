<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档检索</title>

<link rel="stylesheet" pid="text/css" href="<%=request.getContextPath() %>/resources/css/screen.css" />
<script pid="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.9.0.js"></script>
<script pid="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>

</head>

<body>


按数据名称、创建人、数据创建时间、修改时间、数据类型等条件查询，显示相应结果及数据路径。 文件名称含链接（支持另存，直接打开）；支持批量下载。
<br><br>

<form id="searchCondition" method=post>
<!-- when using jquery validation, we must define the name property of element input -->
创  建  人 
<input id="creater" pid="text" value="creater.." name= "creater"/><br>
创建时间
<input id="createrTime" pid="text" value="createTime.." name= "createTime"/><br>
文档名称
<input id="name" pid="text" value="name.." name="name"/><br>

		 文档类型
		 <select id="pid" name="pid">
			<option value=""></option>
			<option value="1" class="s">普通文件</option>
			<option value="2" class="s">几何文件</option>
			<option value="3" class="s">网格文件</option>
			<option value="4" class="s">计算文件</option>
			<option value="5" class="s">其他文件</option>
		</select> <br>
<input pid="submit" id="btn"  value = "根据单一查询条件查询"/>
</form>


<hr>
<h2>查找结果</h2>
<table width="700" align="center" border="1">


		<tr>
			<td>文档标识:</td>
			<td>文档名</td>
			<td>文档路径</td>
			<td>文档</td>
			<td>文档创建者</td>
			<td>文档创建时间</td>
			<td>操作</td>
		</tr>


		<c:if test="${pagers.total le 0 }">
			<tr>
				<td colspan="6">目前还没有文档数据</td>
			</tr>
		</c:if>


		<c:if test="${pagers.total gt 0}">

			<c:forEach items="${pagers.datas }" var="doc">
				<tr>
					<td>${doc.id }</td>
					<td><a href="${doc.id }">${doc.name}</a></td>
					<td>${doc.path}</td>
					<td>${doc.pid}</td>
					<td>${doc.creater}</td>
					<td>${doc.createTime}</td>
					<td><a href="${doc.id }/update">更新</a>&nbsp;
					    <a href="${doc.id }/delete">删除</a>&nbsp;
					    <a href="${doc.id }/download">下载</a>&nbsp;
					    <a href="<%=request.getContextPath() %>/FileDownServlet?filename=${doc.name }" >download</a>
					</td>
				</tr>
			</c:forEach>


			<tr>
				<td colspan="6"><jsp:include page="/inc/pager.jsp">
						<jsp:param name="url" value="users" />
						<jsp:param name="items" value="${pagers.total}" />
					</jsp:include></td>
			</tr>

		</c:if>

	</table>

</body>


</html>