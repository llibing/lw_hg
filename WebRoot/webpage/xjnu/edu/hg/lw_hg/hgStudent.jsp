<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>学生列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hgStudentController.do?save">
			<input id="id" name="id" type="hidden" value="${hgStudentPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							学号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="studentid" name="studentid" ignore="ignore"
							   value="${hgStudentPage.studentid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							密码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="password" name="password" ignore="ignore"
							   value="${hgStudentPage.password}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							真实姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="realname" name="realname" ignore="ignore"
							   value="${hgStudentPage.realname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							导师姓名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="teacherName" name="teacherName" ignore="ignore"
							   value="${hgStudentPage.teacherName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="idcard" name="idcard" ignore="ignore"
							   value="${hgStudentPage.idcard}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							身份:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="status" name="status" ignore="ignore"
							   value="${hgStudentPage.status}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							系别:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="department" name="department" ignore="ignore"
							   value="${hgStudentPage.department}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							手机:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="telphone" name="telphone" ignore="ignore"
							   value="${hgStudentPage.telphone}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							电子邮件:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="email" name="email" ignore="ignore"
							   value="${hgStudentPage.email}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<%-- <tr>
					<td align="right">
						<label class="Validform_label">
							课题外键:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="titleId" name="titleId" ignore="ignore"
							   value="${hgStudentPage.titleId}">
						<span class="Validform_checktip"></span>
					</td>
				</tr> --%>
			</table>
		</t:formvalid>
 </body>