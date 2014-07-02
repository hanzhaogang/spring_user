<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="欢迎使用用户管理系统"/></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
<decorator:head/>


<script language="JavaScript">

function getOs()
{
    var OsObject = "";
   if(navigator.userAgent.indexOf("MSIE")>0) {
        return "MSIE";
   }
   if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){
        return "Firefox";
   }
   if(isSafari=navigator.userAgent.indexOf("Safari")>0) {
        return "Safari";
   } 
   if(isCamino=navigator.userAgent.indexOf("Camino")>0){
        return "Camino";
   }
   if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){
        return "Gecko";
   }
  
}
// alert("您的浏览器类型为:"+getOs());
</script> 


</head>


<body>
<h1><decorator:title/></h1>
<h2>
<a href="<%=request.getContextPath() %>/doc/docs">返回文档列表页面</a>
<a href="<%=request.getContextPath() %>/user/users">返回用户列表页面</a>
</h2>

<c:if test="${not empty loginUser}">
<a href="<%=request.getContextPath() %>/user/add">用户添加</a>
<a href="<%=request.getContextPath() %>/user/users">用户列表</a>
<a href="<%=request.getContextPath() %>/logout">退出系统</a>
当前用户:${loginUser.nickname }
</c:if>

<hr/>
<decorator:body/>

<div align="center" style="width:100%;border-top:1px solid; float:left;margin-top:10px;">
<p>版权所有　中国商飞北京民用飞机技术研究中心&nbsp;&nbsp;| <a href="/main/flsm/201210/23/t20121023_589003.shtml" target="_blank">法律声明</a> | <a href="/zxgk/lx/201210/22/t20121022_588656.shtml" target="_blank">联系我们</a> </p>

<p>地址：昌平区小汤山未来科技城&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编：102211</p>

<p><a href="http://www.comac.cc" target="_blank">中国商用飞机有限责任公司</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网址： <a href="http://www.comac.cc" target="_blank">http://www.comac.cc</a></p>

<p>技术支持：<a href="http://www.ce.cn" target="_blank">中国经济网</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网址： <a href="http://www.ce.cn" target="_blank">http://www.ce.cn</a></p>

<p><script src="http://s95.cnzz.com/stat.php?id=5354960&web_id=5354960&show=pic" language="JavaScript"></script>
	CopyRight By COMAC BASTRI@2012-2015<br/>
</div>

<p> 您正在使用类型为:<script type="text/javascript">getOs()</script>的浏览器浏览本站

</body>

</html>