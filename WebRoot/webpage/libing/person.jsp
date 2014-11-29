<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'person.jsp' starting page</title>
    
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    
    
    
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
    
    <t:formvalid layout="table" dialog="true" formid="personForm" usePlugin="password" action="personController.do?save">
       <input type="hidden" name="id" value="${person.id }"/>
       <table class="formtable" cellpadding="0" cellspacing="1">
         <tr>
           <td align="right" width="15%" nowrap><label class="Validform_label"> 用户名: </label></td>
           <td class="value" width="85%">
              <input type="text" name="name" value="${person.name }"  datatype="*"/>
              <span class="Validform_checktip">用户名范围在2~10位字符</span>
          </td>
         </tr>
         <tr>
           <td align="right" nowrap><label class="Validform_label"> 密码： </label></td>
           <td class="value"><input type="password" name="pwd" value="${person.pwd }"/></td>
         </tr>
         
         <tr>
			<td align="right" nowrap><label class="Validform_label"> 手机号码: </label></td>
			<td class="value"><input class="inputxt" name="mobilePhone" value="${person.mobilePhone}" datatype="m" errormsg="手机号码不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 办公电话: </label></td>
			<td class="value"><input class="inputxt" name="officePhone" value="${person.officePhone}" datatype="n" errormsg="办公室电话不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 常用邮箱: </label></td>
			<td class="value"><input class="inputxt" name="email" value="${person.email}" datatype="e" errormsg="邮箱格式不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 年龄: </label></td>
			<td class="value"><input class="inputxt" name="age" value="${person.age}" datatype="n" errormsg="年龄格式不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 工资: </label></td>
			<td class="value"><input class="inputxt" name="salary" value="${person.salary}" datatype="d" errormsg="工资格式不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 生日: </label></td>
			<td class="value"><input name="birthday" class="Wdate" onClick="WdatePicker()" style="width: 150px" value="<fmt:formatDate value='${person.birthday }' type="date" pattern="yyyy-MM-dd"/>"
				errormsg="生日格式不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 创建日期: </label></td>
			<td class="value"><input name="createDate" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px"
				value="<fmt:formatDate value='${person.createDate }' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" errormsg="日期格式不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 性别: </label></td>
			<td class="value"><t:dictSelect field="sex" typeGroupCode="sex" hasLabel="false" defaultVal="${person.sex}"></t:dictSelect> <span class="Validform_checktip"></span></td>
		</tr>
		
       </table>
    </t:formvalid>
</html>
