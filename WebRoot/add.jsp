<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加联系人</title>
    
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
  <form action="${pageContext.request.contextPath}/add">
  <table align="center" width="300px" border="1">
    <tr>
    	<td>用户名</td><td><input type="text" name="name" "></td>
    </tr>
    <tr>
    	<td>联系方式</td><td><input type="text" name="phone"></td>
    </tr>
     <tr>
    	<td colspan="2" align="center"><input type="submit" value="添加"></td>
    </tr>
    
  </table>
  </form>
  </body>
</html>
