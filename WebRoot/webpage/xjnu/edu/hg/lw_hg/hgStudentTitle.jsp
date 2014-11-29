<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>学生选题信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hgStudentTitleController.do?save">
			<input id="id" name="id" type="hidden" value="${hgStudentTitlePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							学生:
						</label>
					</td>
					<%-- <td class="value">
						<input class="inputxt" id="studentId" name="studentId" ignore="ignore"
							   value="${hgStudentTitlePage.studentId}">
						<span class="Validform_checktip"></span>
					</td> --%>
					<td class="value"><select id="hgStudentEntity.Id" name="hgStudentEntity.Id" datatype="*">
				  <c:forEach items="${studentEntityList}" var="studentEntity">
					<option value="${studentEntity.id }" <c:if test="${studentEntity.id==hgStudentTitlePage.hgStudentEntity.id}">selected="selected"</c:if>>${studentEntity.realname}</option>
				</c:forEach>
			    </select> <span class="Validform_checktip">请选择学生</span></td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							课题名:
						</label>
					</td>
					<%-- <td class="value">
						<input class="inputxt" id="titleId" name="titleId" ignore="ignore"
							   value="${hgStudentTitlePage.titleId}">
						<span class="Validform_checktip"></span>
					</td> --%>
					<td class="value"><select id="hgTitleEntity.Id" name="hgTitleEntity.Id" datatype="*">
				  <c:forEach items="${titleEntityList}" var="titleEntity">
					<option value="${titleEntity.id }" <c:if test="${titleEntity.id==hgStudentTitlePage.hgTitleEntity.id}">selected="selected"</c:if>>${titleEntity.titleName}</option>
				</c:forEach>
			    </select> <span class="Validform_checktip">请选择课题</span></td>
				</tr>
			</table>
		</t:formvalid>
 </body>