<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%-- <t:base type="jquery,easyui,tools,DatePicker"></t:base> --%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hgAchievementsList" queryMode="group" title="成果展示" actionUrl="hgAchievementsController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="图片" field="img" imageSize="90,90"></t:dgCol>
   <t:dgCol title="成果内容" field="descriptin" ></t:dgCol>
   <t:dgCol title="学生" field="hgStudentEntity_Id" replace="${realnameReplace }" query="true"></t:dgCol>
   <t:dgCol title="时间" field="time" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
   <%-- <t:dgCol title="图片" field="img" ></t:dgCol> --%>
   <t:dgCol title="成果名" field="achievementsName" query="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hgAchievementsController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hgAchievementsController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hgAchievementsController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hgAchievementsController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>