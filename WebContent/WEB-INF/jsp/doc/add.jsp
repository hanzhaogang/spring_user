<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档添加</title>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/My97DatePicker/WdatePicker.js">   
</script>
</head>

<body>

    <!-- 此时没有写action,直接提交会提交给/add -->
	<sf:form method="post" modelAttribute="document"  enctype="multipart/form-data">

		<table width="700" align="center" border="1">

			<tr>
				<td>文档名称:</td>
				<td><sf:input path="name" />
					<sf:errors path="name" />
				</td>
			</tr>

			<tr>
				<td>文档类型:</td>
				<td><sf:input path="type" />
					<sf:errors path="type" />
				</td>
			</tr>

			<tr>
				<td>文档路径:</td>
				<td>
				    <sf:input path="path" />
				</td>
			</tr>

			<tr>
				<td>文档创建者:</td>
				<td>
				    <sf:input path="creater" />
					<sf:errors path="creater" />
				</td>
			</tr>
			
			<tr>
				<td>文档创建时间:</td>
				<td >
				     <sf:input class="Wdate" type="text" onClick="WdatePicker()" path="createTime"/> 
					 <sf:errors path="createTime" />
				</td>
			</tr>

			<tr>
				<td>上传文件</td>
				<td><input type="file" name="attachs" /><br /> 
				    <input type="file" name="attachs" /><br /> 
				    <input type="file" name="attachs" /><br />
				    <input type="file" name="attachs" /><br />
					<input type="file" name="attachs" /><br /> 
					<input type="file" name="attachs" /><br />
				    <input type="file" name="attachs" /><br />
					<input type="file" name="attachs" /><br /> 
					<input type="file" name="attachs" /><br /> 
					<input type="file" name="attachs" /><br />
				</td>
			</tr>

			<tr>
				<td colspan="2">
				    <input type="submit" value="文档添加" />
				</td>
			</tr>
	
		</table>
		
	</sf:form>
</body>

</html>