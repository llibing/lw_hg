<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%-- <t:base type="jquery,easyui,tools,DatePicker"></t:base> --%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hgStudentList" queryMode="group" title="学生列表" actionUrl="hgStudentController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="学号" field="studentid" query="true"></t:dgCol>
   <t:dgCol title="密码" field="password" ></t:dgCol>
   <t:dgCol title="真实姓名" field="realname" query="true"></t:dgCol>
   <t:dgCol title="导师姓名" field="teacherName" query="true"></t:dgCol>
   <t:dgCol title="身份证号" field="idcard" query="true"></t:dgCol>
   <t:dgCol title="身份" field="status" query="true"></t:dgCol>
   <t:dgCol title="系别" field="department" query="true"></t:dgCol>
   <t:dgCol title="手机" field="telphone" query="true"></t:dgCol>
   <t:dgCol title="电子邮件" field="email" query="true"></t:dgCol>
   <%-- <t:dgCol title="课题外键" field="titleId" query="true"></t:dgCol> --%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hgStudentController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hgStudentController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hgStudentController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hgStudentController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>