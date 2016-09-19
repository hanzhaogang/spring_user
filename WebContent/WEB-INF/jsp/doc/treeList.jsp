<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/zTreeCss/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>script/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/zTreeJs/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/zTreeJs/jquery.ztree.core-3.5.js"></script>

<script type="text/javascript">
	$(function() {
		var setting = {
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pid",
					rootPId : -1,
				}
			},
			view : {
				selectedMulti : false
			},
			async : {
				enable : true,
				url : "treeAll",

			},
			callback : {
				onClick : function(event, treeId, treeNode) {
                    if (treeNode.id>0) {
					$("#showDetails").attr(
							"src",
							"http://localhost:8080/spring_user/doc/"
									+ treeNode.id);
                    }
				}
			}
		};
		$.fn.zTree.init($("#tree"), setting);
	});
</script>
</head>

<body>
	<div id="content">
		<h3 class="admin_link_bar"> </h3>
		<TABLE border=0 align=left height="200px">
			<TR>
				<TD width=150px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
					<ul id="tree" class="ztree" style="width: 150px; overflow: auto;"></ul>
				</TD>
				<TD width=850px align=left valign=top>
    				<IFRAME ID="showDetails" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100% height=300px></IFRAME>
				</TD>
			</TR>
		</TABLE>
	</div>

</body>

</html>
