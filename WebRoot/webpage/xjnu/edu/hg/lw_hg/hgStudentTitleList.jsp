<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%-- <t:base type="jquery,easyui,tools,DatePicker"></t:base> --%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hgStudentTitleList" queryMode="group" title="学生选题信息" actionUrl="hgStudentTitleController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
    <t:dgCol title="学生" field="hgStudentEntity_Id" replace="${realnameReplace }" query="true"></t:dgCol>
   <t:dgCol title="课题名" field="hgTitleEntity_Id" replace="${titleNameReplace }" query="true"></t:dgCol>
   <t:dgCol title="课题导师" field="hgTitleEntity_hgTeacherEntity_Id" replace="${teacherNameReplace}" query="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hgStudentTitleController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hgStudentTitleController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hgStudentTitleController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hgStudentTitleController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>