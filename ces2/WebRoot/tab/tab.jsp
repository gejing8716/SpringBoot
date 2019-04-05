<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/tab/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

a {
	text-decoration: none;
}

body{
	font-size:12px; 
	color: #033D61;
}


.tableb {
	border-collapse: collapse;
	width: 100%;
}


.tableb th{
	border: 1px solid #33A9D0;
	height: 20px;
	text-align: center;
}

.tableb td{
	border: 1px solid #33A9D0;
	height: 10px;
	text-align: center;
	padding: 0px;
}
th{
	background-color: #E7F2FA;
}
</style>

</head>

<body>
<table style="background-color: #5DBAD9;width: 100%;height: 25px;">
	<tr>
		<td style="padding-right: 30px; text-align: right;"><a href="${rpath}/tab/toAdd.jsp"><img src="${rpath}/tab/images/22.gif"/>添加</a></td>
	</tr>
</table>
<table class="style1 tableb">
	<tr>
		<th>用户名</th>
		<th>密码</th>
		<th>性别</th>
		<th>生日</th>
		<th>住址</th>
		<th>工资</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.username }</td>
			<td>${user.password }</td>
			<td>
				<c:if test="${user.gender == 1}">男</c:if>
				<c:if test="${user.gender == 0}">女</c:if>
			</td>
			<td>${user.birthday }</td>
			<td>${user.address }</td>
			<td>${user.sal }</td>
			<td><a href="${rpath}/QuerySingleUser?userId=${user.userId }"><img src="${rpath}/tab/images/edt.gif"/>编辑</a>
				<a href="${rpath}/DeleteServlet?userId=${user.userId }"><img src="${rpath}/tab/images/del.gif"/>删除</a>
			 </td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>