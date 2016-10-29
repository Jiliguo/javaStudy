<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联系人列表</title>
    
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
  	<table border="1" align="center" width="400px" cellpadding="0" cellspacing="0px">
    <tr><th>序号</th><th>姓名</th><th>联系方式</th><th>操作</th></tr>
    
    <c:forEach var="contact" items="${requestScope.list}" varStatus="vs" >
    	<tr>
    		<td align="center">${vs.count}</td>
    		<td align="center">${contact.name}</td>
    		<td align="center">${contact.phone}</td>
    		<td align="center"><a href="${pageContext.request.contextPath }/delete?name=${contact.name}">删除</a>
    		&nbsp<a href="${pageContext.request.contextPath }/update?name=${contact.name}">修改</a></td>
    	</tr>
    </c:forEach>
  	<tr><a href="${pageContext.request.contextPath }/add.jsp">添加联系人</a></tr>
  	</table>
  </body>
</html>
