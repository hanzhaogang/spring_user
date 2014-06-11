<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加</title>
</head>

<body>
    <!-- 此时没有写action,直接提交会提交给/add -->
	<sf:form method="post" modelAttribute="user"  enctype="multipart/form-data">
		<table width="700" align="center" border="1">
			<tr>
				<td>用户名:</td>
				<td><sf:input path="username" />
					<sf:errors path="username" />
				</td>
			</tr>
			<tr>
				<td>用户密码:</td>
				<td><sf:password path="password" />
					<sf:errors path="password" />
				</td>
			</tr>
			<tr>
				<td>用户昵称:</td>
				<td>
				    <sf:input path="nickname" />
				</td>
			</tr>
			<tr>
				<td>用户邮箱:</td>
				<td>
				    <sf:input path="email" />
					<sf:errors path="email" />
				</td>
			</tr>
			<tr>
			<td>上传文件</td>
			<td>
		        <input type="file" name="attachs"/><br/>	
	            <input type="file" name="attachs"/><br/>	
	            <input type="file" name="attachs"/><br/>
			</td>
			</tr>
			
			<tr>
				<td colspan="2">
				    <input type="submit" value="用户添加" />
				</td>
			</tr>
		</table>
	</sf:form>
</body>

</html>