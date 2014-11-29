<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>导师信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hgTeacherController.do?save">
			<input id="id" name="id" type="hidden" value="${hgTeacherPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							导师姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="teacherName" name="teacherName" ignore="ignore"
							   value="${hgTeacherPage.teacherName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							职称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="position" name="position" ignore="ignore"
							   value="${hgTeacherPage.position}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							简介:
						</label>
					</td>
					<td class="value" >
						<textarea style="width: 300px;" class="inputxt" id="description" name="description" ignore="ignore"
							   value="${hgTeacherPage.description}" rows="12" cols="200">${hgTeacherPage.description}</textarea>
						<span class="Validform_checktip"></span>
					</td>
					<%-- <td class="value">
						<input class="inputxt" id="description" name="description" ignore="ignore"
							   value="${hgTeacherPage.description}">
						<span class="Validform_checktip"></span>
					</td> --%>
				</tr>
			</table>
		</t:formvalid>
 </body>