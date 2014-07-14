<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/user/userAdd.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/screen.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>

<script type="text/javascript">
	$(function() {
		$("#name").validate({
			rules : {
				username:{
					required:true,
					minlength:3,
					maxlength:12
				},
				password: {
					required:true,
					minlength:6,
					maxlength:20
				},
				confirm_password:{
					required:true,
					equalTo:"#password"
					},
				email:{
					email:true
				}
			},
			messages : {
            	username:{
            		required:"用户名称不能为空",
            	    minlength:"用户名长度必须在3到12之间",	
            	    maxlength:"用户名长度必须在3到12之间"	
            	},
            	password:{
            		required:"用户密码不能为空",
            	    minlength:"用户密码长度必须在6到20之间",	
            	    maxlength:"用户密码长度必须在6到20之间"	
            	},
            	confirm_password:{
                	required:"请确认您输入的密码",
                	equalTo:"您输入的密码不一致"
            	},
            	email:{
            		email:"用户邮件格式不正确"
            	}
			}
		});
	});
</script>
</head>

<body>
    <div>
	<!-- 此时没有写action,直接提交会提交给/add -->
    	<sf:form id="name" name="name" method="post" modelAttribute="user" >
    		<table width="700" align="center" border="1">
    			<tr>
    				<td>用户名:</td>
    				<td><sf:input name="username" path="username" />  </td>
    			</tr>
    			<tr>
    				<td>用户密码:</td>
    				<td><sf:password name="password" path="password" />  </td>
    			</tr>
    			<tr>
    				<td>确认用户密码:</td>
    				<td><input name="confirm_password" type="password" /> </td>
    			</tr>
    			<tr>
    				<td>用户昵称:</td>
    				<td><sf:input name="nickname" path="nickname" /></td>
    			</tr>
    			<tr>
    				<td>用户邮箱:</td>
    				<td><sf:input name="email" path="email" /> </td>
    			</tr>
    			<tr>
    				<td colspan="2"><input type="submit" value="用户添加" /></td>
    			</tr>
    		</table>
    	</sf:form>
        <h2 id = "promption">${exception.message }</h2>
    </div>
</body>

</html>