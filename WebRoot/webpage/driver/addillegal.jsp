<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/context/mytags.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'addillegal.jsp' starting page</title>
    <t:base type="jquery,easyui,tools"></t:base>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
<!-- <link rel="stylesheet" type="text/css" href="plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css"> -->
  </head>
  
  <body>
   <form action="http://218.195.213.187:8080/jeecgv343/driverController.do?qqsaveillegal" method="post" enctype="multipart/form-data">
   <!-- <form layout="table" dialog="true" formid="formobj" action="driverController.do?saveillegal"> -->
		
		<input type="hidden" name="id" >
		<input type="hidden" name="carid" value="${id }"> 
		<!-- <input type="hidden" name="image" > -->
		<table>
		
		<tr>
   			<td>图片</td>
   			<td>
   				<input type="file" name="image1">
   			</td>
		</tr> 
		
			<tr>
			<td> 违章地址：</td>
				<td><input type="text"  name="illegaladdress" ></td>
				</tr>
				
		     <tr>
			<td>违章内容：</td>
				<td ><input type="text"  name="illegalcontent" >
				</tr>
	
				
				
					<tr>
			<td> 违章代码：</td>
				<td ><input type="text"   name="illegalcode" ></td>
				</tr>
				<tr>
			<td> 违章分数 </td>
				<td ><input type="text"  name="score" ></td>
				</tr>
				
				<tr>
			    <td>处理结果 </td>
				<td ><input type="text"  name="handle" ></td>
				</tr>
				
				<tr>
			     <td> 罚款 </td>
				<td ><input type="text"  name="illegalfine" ></td>
				</tr>
				
			<tr>
			     <td> 违章日期： </td>
				<td class="value"><input  class="Wdate" name="illegaldate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"    ></td>
				</tr>
			 
				<tr>
			     <td></td>
				<td><input type="submit"></td>
				</tr> 
		</table>
		
    </form>


  </body>
</html>
