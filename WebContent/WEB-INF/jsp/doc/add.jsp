<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档添加</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/screen.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(function() {
		$("#name").validate({
			rules : {
				name : {
					required : true,
					minlength : 3
				},
				creater : {
					required : true,
					minlength : 3
				},
				createTime : "required",
				type : "required",
				path : "required",
			},
			messages : {
				name : {
					required : "必须输入文档名称",
					minlength : "文档名称长度不能小于3"
				},
				creater : {
					required : "必须输入文档创建者",
					minlength : "文档创建者姓名长度不能小于3"
				},
				createTime : "必须输入文档创建时间",
				type : "必须选择文档类型",
				path : "必须输入文档路径"
			}
		});
	});
</script>

</head>

<body>

    <!-- 此时没有写action,直接提交会提交给/add -->
	<sf:form id="name" method="post" modelAttribute="documentForm"  enctype="multipart/form-data">

		<table width="700" align="center" border="1">
			<tr>
				<td>文档名称:</td> <td><sf:input path="name" name="name"/> </td>
			</tr>

			<tr>
				<td>文档类型:</td>
				
				<td>
			<!--	<sf:input path="type" name="type"/>   -->
				</td>
				<td>
				<sf:select id="type" path="type"  style="width:150" name="state" value="$!{state}">
                      <OPTION value="-5" SELECTED>其他文件</OPTION>
                      <OPTION value="-4">普通文件</OPTION>
                      <OPTION value="-3" >计算结果文件</OPTION>
                      <OPTION value="-2">几何文件</OPTION>
                      <OPTION value="-1">构型文件</OPTION>
                </sf:select>   
</td>
			</tr>

			<tr>
				<td>文档路径:</td> <td> <sf:input path="path" name="path"/> </td>
			</tr>

			<tr>
				<td>文档创建者:</td> <td> <sf:hidden path="creater" name="creater" value= "${loginUser.username}" /> </td>
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
				<td colspan="2"> <input type="submit" value="文档添加" /> </td>
			</tr>
	
		</table>
		
	</sf:form>
</body>

</html>