<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档更新</title>
</head>

<body>
	<sf:form method="post" modelAttribute="document">
		<table width="700" align="center" border="1">
			<tr>
				<td>文档名:</td>
				<td>${document.name}<sf:hidden path="name" /></td>
			</tr>
			<tr>
				<td>文档路径:</td>
				<td><sf:input path="path" />
					<sf:errors path="path" /></td>
			</tr>
			<tr>
				<td>文档类型：</td>
				<td><sf:input path="type" /></td>
			</tr>
			<tr>
				<td>文档创建者:</td>
				<td><sf:input path="creater" />
					<sf:errors path="creater" /></td>
			</tr>
			<tr>
				<td>文档创建时间:</td>
				<td><sf:input path="createTime" />
					<sf:errors path="createTime" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="文档更新" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>