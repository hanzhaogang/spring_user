<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/doc/show.css"/>
<script language="javascript">
    function delcfm() {
        if (!confirm("确认要删除？")) {
        return false;
        }else{
        }
    }
</script>
</head>

<body>
    <h1>文档[${document.name}]详细信息如下:</h1>
    <div>
	<table width="700" align="center" border="1">
		<tr>
			<td>文档标识:</td>
			<td>${document.id }</td>
		</tr>
		<tr>
			<td>文档名:</td>
			<td>${document.name }</td>
		</tr>
		<tr>
			<td>文档类型:</td>
			<td>${document.type}</td>
		</tr>
		<tr>
			<td>文档创建者:</td>
			<td>${document.creater}</td>
		</tr>
		<tr>
			<td>文档创建时间:</td>
			<td>${document.createTime}</td>
		</tr>
	</table>
    </div>
    <div id="operation">	
       <a href="${document.id }/update">更新</a>&nbsp;
       <a href="${document.id }/delete" onClick="return delcfm();">删除</a>&nbsp;
       <a href="<%=request.getContextPath() %>/FileDownServlet?filename=${document.name }" >下载</a>
    </div>
</body>

</html>