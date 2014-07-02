<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通HTML Form文档添加 </title>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/My97DatePicker/WdatePicker.js">   </script>
</head>

<body>
     <form>

			<table width="700" align="center" border="1">
			<tr>
				<td>文档名称:</td>
				<td><input id="username" />
				</td>
			</tr>
			<tr>
				<td>用户密码:</td>
				<td><input type="password" id="password" />
				</td>
			</tr>
			<tr>
				<td>用户昵称:</td>
				<td>
				    <input id="nickname" />
				</td>
			</tr>
			<tr>
				<td>用户邮箱:</td>
				<td>
				    <input id="email" />
				</td>
			</tr>

			<tr>
				<td>用户邮箱:</td>
				<td><input class="Wdate" type="text" onClick="WdatePicker()" />
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
		
	</form>
</body>

</html>



