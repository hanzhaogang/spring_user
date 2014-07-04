<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档列表</title>
</head>

<body>
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
					<td>${doc.type}</td>
					<td>${doc.creater}</td>
					<td>${doc.createTime}</td>
					<td><a href="${doc.id }/update">更新</a>&nbsp;
					    <a href="${doc.id }/delete">删除</a>&nbsp;
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
	
<a href="<%=request.getContextPath() %>/doc/add">文档添加</a>
<a href="<%=request.getContextPath() %>/doc/search">文档检索</a>

</body>

</html>