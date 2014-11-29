<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%-- <t:base type="jquery,easyui,tools,DatePicker"></t:base> --%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hgTitleList" title="课题列表" queryMode="group" actionUrl="hgTitleController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="课题名" field="titleName" query="true"></t:dgCol>
   <t:dgCol title="课题人数" field="titleNum" ></t:dgCol>
   <t:dgCol title="导师" field="hgTeacherEntity_Id" replace="${teacherNameReplace }" query="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hgTitleController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hgTitleController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hgTitleController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hgTitleController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>