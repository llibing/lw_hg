<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>成果展示</title>
<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hgAchievementsController.do?save">
			<input id="id" name="id" type="hidden" value="${hgAchievementsPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							学生:
						</label>
					</td>
					<%-- <td class="value">
						<input class="inputxt" id="studentId" name="studentId" ignore="ignore"
							   value="${hgAchievementsPage.studentId}">
						<span class="Validform_checktip"></span>
					</td> --%>
					<td class="value" ><select id="hgStudentEntity.Id" name="hgStudentEntity.Id" datatype="*">
				  <c:forEach items="${studentEntityList}" var="studentEntity">
					<option value="${studentEntity.id }" <c:if test="${studentEntity.id==hgAchievementsPage.hgStudentEntity.id}">selected="selected"</c:if>>${studentEntity.realname}</option>
				</c:forEach>
			    </select> <span class="Validform_checktip">请选择学生</span></td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="time" name="time" ignore="ignore"
							     value="<fmt:formatDate value='${hgAchievementsPage.time}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							图片:
						</label>
					</td>
					<td class="value">
					<t:ckfinder name="img" uploadType="Images" value="${hgAchievementsPage.img}" width="80" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
					</td>
					<%-- <td class="value">
						<input class="inputxt" id="img" name="img" ignore="ignore"
							   value="${hgAchievementsPage.img}">
						<span class="Validform_checktip"></span>
					</td> --%>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							成果名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="achievementsName" name="achievementsName" ignore="ignore"
							   value="${hgAchievementsPage.achievementsName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							成果内容:
						</label>
					</td>
					<td class="value" >
						<textarea style="width: 500px;" class="inputxt" id="descriptin" name="descriptin" ignore="ignore"
							   value="${hgAchievementsPage.descriptin}" rows="12" cols="200">${hgAchievementsPage.descriptin}</textarea>
						<span class="Validform_checktip"></span>
					</td>
					<%-- <td class="value">
						<input class="inputxt" id="descriptin" name="descriptin" ignore="ignore"
							   value="${hgAchievementsPage.descriptin}">
						<span class="Validform_checktip"></span>
					</td> --%>
				</tr>
			</table>
		</t:formvalid>
 </body>