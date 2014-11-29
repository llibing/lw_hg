<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户</title>
<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
<!-- <link rel="stylesheet" type="text/css" href="plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">  -->
</head>

<body >
<t:formvalid formid="formobj" dialog="true" tiptype="1" usePlugin="password" layout="table"  action="driverController.do?save">
	<input id="id" name="id" type="hidden" value="${tdriveruser.id }">
	<table  cellpadding="0" cellspacing="1" class="formtable">

	    <tr>
	       <tr>
			<td align="right"><label class="Validform_label"> 图片: </label></td>
			<td class="value"><t:ckfinder name="image" uploadType="Images" value="${tdriveruser.image}" width="80" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder></td>
		    <td align="right"><label class="Validform_label"> 车辆类型: </label></td>
			<td class="value"><input type="text"  name="cartype" value="${tdriveruser.cartype }"   /></td>
		
		</tr>
	   
		
		<tr>
			<td align="right"><label class="Validform_label"> 用户名称: </label></td>
			<td class="value">
			<input type="text" datatype="*"  nullmsg="用户名不允许为空" errormsg="请输入中文名！" name="drivername" value="${tdriveruser.drivername }"   /></td>
			<td align="right"><label class="Validform_label"> 身份证号: </label></td>
			<td class="value"><input class="inputxt"  name="drivernum"  value="${tdriveruser.drivernum}" datatype="idcard" nullmsg="请正确填写身份证号码！" errormsg="您填写的身份证号码不对！"> </td>
		</tr>
		<tr>
	    <tr>
			 <td align="right" nowrap><label class="Validform_label"> 车牌号： </label></td>
             <td class="value"><input type="inputxt" name="driverpassword" value="${tdriveruser.driverpassword }"/></td>
			 <td align="right" nowrap><label class="Validform_label"> 手机号码: </label></td>
			 <td class="value"><input class="inputxt" name="drivertel" value="${tdriveruser.drivertel}" datatype="m" errormsg="手机号码不正确!" ignore="ignore"> <span class="Validform_checktip"></span></td>
		</tr>
		
		<tr>
			<td align="right"><label class="Validform_label"> 家庭住址: </label></td>
			<td class="value"><input class="inputxt" name="driveraddress" value="${tdriveruser.driveraddress}"  nullmsg="家庭住址不允许为空" datatype="*"> <span class="Validform_checktip"></span></td>
		    
		    <td align="right"><label class="Validform_label"> 号牌颜色: </label></td>
			<td class="value"><input class="inputxt" name="driverflapper" value="${tdriveruser.driverflapper}" > <span class="Validform_checktip"></span></td>
		 
		</tr>
		<tr>
		<td align="right"><label class="Validform_label"> 车身颜色: </label></td>
			<td class="value"><input class="inputxt" name="carcolor" value="${tdriveruser.carcolor}" > <span class="Validform_checktip"></span></td>
			
			<%-- <td align="right"><label class="Validform_label"> 备注: </label></td>
			<td class="value">
          
			<input class="inputxt"  name="remark" value="${tdriveruser.remark}" > <span class="Validform_checktip"></span></c:if></td> --%>
		     <td align="right"><label class="Validform_label"> 性别: </label></td>
			<td class="value"><t:dictSelect field="sex" typeGroupCode="sex" hasLabel="false" defaultVal="${tdriveruser.sex}"></t:dictSelect> <span class="Validform_checktip"></span></td>
             
		</tr>
		<tr>
			
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 出生日期: </label></td>
			<td class="value"><input name="driverbir" class="Wdate" onClick="WdatePicker()" style="width: 150px" value="<fmt:formatDate value='${tdriveruser.driverbir }' type="date" pattern="yyyy-MM-dd"/>"
				errormsg="生日格式不正确!" ignore="ignore"> <!-- <span class="Validform_checktip"></span> --></td>
				<td align="right"><label class="Validform_label"> 驾照号: </label></td>
			<td class="value"><input class="inputxt" name="driverlicencenum" value="${tdriveruser.driverlicencenum}" nullmsg="驾照号不允许为空" datatype="*" > <span class="Validform_checktip"></span></td>
		    
		    
		</tr>
	
	
		
	</table>
	<div style="width: auto; height: 200px;"><%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
	<div style="width: 690px; height: 1px;"></div>
	<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
		<t:tab href="driverController.do?illegalList&id=${tdriveruser.id}" icon="icon-search" title="罚单明细" id="Product"></t:tab>
	</t:tabs></div>
</t:formvalid>
<table style="display: none">
	<tbody id="add_jeecgStudent_table_template">
		<tr>
			      <td align="center"><input style="width: 15px;" type="checkbox" name="ck" /></td>
		<td align="left"><img name="TIllegals[0].image"  width="100" height="60" /></td>
			       <td align="left"><input name="TIllegals[#index#].illegalcode" nullmsg="请输入相应的违章代码！" datatype="*" errormsg="违章代码填写不正确"  maxlength="30" type="text"  style="width: 60px;"></td>
					
					<td align="left"><input name="TIllegals[#index#].illegalfine" nullmsg="请输入相应的罚款金额！" datatype="d" errormsg="罚款金额填写不正确" maxlength="20" type="text" style="width: 60px;"></td>
					<td align="left"><input name="TIllegals[#index#].score" nullmsg="请输入相应的违章扣分" datatype="n" errormsg="违章扣分格式不对！" maxlength="30" type="text" style="width:30px;"></td>
					<td align="left"><input name="TIllegals[#index#].illegalcontent" errormsg="订单产品明细的产品名称应该为2到40位" nullmsg="请输入用后违规内容！" datatype="s2-100" maxlength="200" type="text" style="width: 300px;"></td>
					<!--  <td align="left"><input name="TIllegals[#index#].illegaldate"  maxlength="50" type="text"  style="width: 100px;"></td>-->
					
				<td align="left"><input name="TIllegals[#index#].illegaldate" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 100px" 
				<%-- value="<fmt:formatDate  type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" --%>  
				errormsg="违章日期格式不正确!" ignore="ignore"> <!-- <span class="Validform_checktip"></span> --></td>
				
				
					<td align="left"><input name="TIllegals[#index#].illegaladdress" maxlength="100" type="text"  style="width: 100px;"></td>
					<td align="left"><input name="TIllegals[#index#].handle" maxlength="200" type="text"  style="width: 100px;"></td>
		</tr>
	</tbody>
</table>
</body>