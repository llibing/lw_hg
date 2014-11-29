<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="../../plug-in/jquery/jquery-1.8.3.min.js"></script>
  
  
  <script type="text/javascript" src="../../plug-in/easyui/jquery.easyui.min.js"></script>
  <link rel="stylesheet" href="../../plug-in/datatables/default/datatables_style.css" type="text/css"></link>
  <link rel="stylesheet" href="../../plug-in/datatables/thems/black/css/demo.css" type="text/css"></link>
  </head>
  
  <body>
  
   
   

  
  
           你好啊！<br>
    ${per.id}<br>
    ${per.username}<br>
    ${per.password}<br>
 <form action="firstController.do?saveper" method="post">
         用户姓名:<input type="text" name="id"><br>
         用户姓名:<input type="text" name="username"><br>
        用户密码:<input type="password" name="password"><br>
    <input type="submit" value="提交"><br>
  </form>

  </body>
</html>
