<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/user/userList.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/main.js"></script>
<script type="text/javascript">
function delcfm() {
        if (!confirm("确认要删除？")) {
            return false;
        }
    }
</script>
</head>

<body>
    <div id= "content">
	<table width="800" cellspacing="0" cellPadding="0" id="listTable" >
		<thead>
	    	<tr>
	    		<td>用户标识:</td>
	    		<td>用户名</td>
	    		<td>用户昵称</td>
	    		<td>用户密码</td>
	    		<td>用户邮箱</td>
	    		<td>操作</td>
	    	</tr>
		</thead>
        
		<c:if test="${pagers.total le 0 }">
			<tr>
				<td colspan="6">目前还没有用户数据</td>
			</tr>
		</c:if>

		<c:if test="${pagers.total gt 0}">

			<c:forEach items="${pagers.datas }" var="u">
        <tbody>
				<tr>
					<td>${u.id }</td>
					<td>${u.username }</td>
					<td><a href="${u.id }">${u.nickname }</a></td>
					<td>${u.password }</td>
					<td>${u.email }</td>
					<td><a href="${u.id }/update">更新</a>&nbsp;
					    <a href="${u.id }/delete" onClick="return delcfm();">删除</a>
					</td>
				</tr>
            </tbody>
			</c:forEach>

			<tfoot>
			<tr>
				<td colspan="6">
				    <jsp:include page="/inc/pager.jsp">
						<jsp:param name="url" value="users" />
						<jsp:param name="items" value="${pagers.total}" />
					</jsp:include>
				</td>
			</tr>
			</tfoot>

		</c:if>
	</table>
    </div>
</body>

</html>