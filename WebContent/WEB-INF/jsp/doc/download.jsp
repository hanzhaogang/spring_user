<%@ page language="java" import="java.util.*,zttc.itat.document.web.*" pageEncoding="gbk"%>
<jsp:directive.page import="zttc.itat.document.model.MessageBean;"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<base href="<%=basePath%>">

<title>My JSP 'book.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
 <link rel="stylesheet" type="text/css" href="styles.css">
 -->

</head>

<body>
	<%
// 		Vector vv=(Vector)session.getAttribute("document");
 //		for (int i = 0; i < vv.size(); i++) {
// 			MessageBean mb = (MessageBean) vv.get(i);
// 			out.println("<tr>");
// 			out.println("<td>" + mb.getSender() + "</td>");
// 			out.println("<td>" + mb.getMess_time() + "</td>");
// 			out.println("<td>" + mb.getGeter() + "</td>");
// 			out.println("<td>" + mb.getMess_content() + "</td>");

// 			String filename = null;
// 			session.setAttribute("java.rar", filename);
// 			//取得文件名
// 		    filename=mb.getFilePath().substring(mb.getFilePath().lastIndexOf("/")+1);
			
// 			//java.rar这个可以改成变量
// 			out.println("<td><a href=FileDownServlet?filename=java.rar>glx1.4.pdf</a></td>");
// 			out.println("</tr>");
 //		}
		%>
		
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
					    <a href="${doc.id }/delete">下载</a>&nbsp;
					</td>
				</tr>
		</c:forEach>
			
			
		<%
	    out.println("<tr>");
	    out.println("<td><a href=FileDownServlet?filename=glx1.4.pdf>5.1下载书--java</a></td>");//java.rar这个可以改成变量
	    out.println("<td><a href=FileDownServlet?filename=dos.rar>dos视频教程</a></td>");
	    out.println("<td><a href=FileDownServlet?filename=${doc.name}>常用DOS命令</a></td>");
	    out.println("</tr>");
	%>
</body>

</html>