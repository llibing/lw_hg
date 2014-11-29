<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>课题列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hgTitleController.do?save">
			<input id="id" name="id" type="hidden" value="${hgTitlePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							课题名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="titleName" name="titleName" ignore="ignore"
							   value="${hgTitlePage.titleName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							课题人数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="titleNum" name="titleNum" ignore="ignore"
							   value="${hgTitlePage.titleNum}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							导师:
						</label>
					</td>
					<%-- <td class="value">
						<input class="inputxt" id="teacherId" name="teacherId" ignore="ignore"
							   value="${hgTitlePage.teacherId}">
						<span class="Validform_checktip"></span>
					</td> --%>
					<td class="value"><select id="hgTeacherEntity.Id" name="hgTeacherEntity.Id" datatype="*">
				  <c:forEach items="${teacherEntityList}" var="teacherEntity">
					<option value="${teacherEntity.id }" <c:if test="${teacherEntity.id==hgTitlePage.hgTeacherEntity.id}">selected="selected"</c:if>>${teacherEntity.teacherName}</option>
				</c:forEach>
			    </select> <span class="Validform_checktip">请选择导师</span></td>
				</tr>
			</table>
		</t:formvalid>
 </body>