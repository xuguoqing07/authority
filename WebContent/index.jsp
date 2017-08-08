<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 静态包含 --%>
<%@ include file="/common/include/page.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		导航页面
		<table width="80%" border="1">
			<tr>
				<td>名称</td>
				<td>链接</td>
			</tr>
			<tr>
				<td>管理员列表</td>
				<td><a href="${rootPath }/head/admins/adminsList.html" target="_blank">管理员列表</a></td>
			</tr>
			<tr>
				<td>登陆</td>
				<td><a href="${rootPath }/login.html" target="_blank">登陆</a></td>
			</tr>
		</table>
	</body>
</html>