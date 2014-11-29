<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" src="<%=basePath%>/plug-in/lodop/LodopFuncs.js"></script>
<script type="text/javascript" charset="utf-8">
	/*
	 *	excel导入、导出
	 */
	function driverListExportXls() {
		JeecgExcelExport("driverController.do?exportXls","driverList");
	}
	
	/* function driverListImportXls() {
		openuploadwin('Excel导入', 'driverController.do?upload', "driverList");
	}
	function driverListExportXlsByT() {
		JeecgExcelExport("driverController.do?exportXlsByT","driverList");
	}
	function driverListExportXlsByTe() {
		JeecgExcelExport("driverController.do?exportXlsByTest","driverList");
	} */
</script>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;"><t:datagrid name="driverList" title="用户" actionUrl="driverController.do?datagrid" idField="id" fit="true" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="图片" field="image" imageSize="90,90"></t:dgCol>
	<t:dgCol title="用户名称" field="drivername" query="true" autocomplete="true"></t:dgCol>
	<t:dgCol title="车牌号" field="driverpassword" query="true" autocomplete="true"></t:dgCol>
	<t:dgCol title="身份证号" field="drivernum" query="true" autocomplete="true"></t:dgCol>
	<t:dgCol title="电话号码" sortable="false" field="drivertel" query="true"></t:dgCol>
	<t:dgCol title="性别" sortable="true" field="sex" dictionary="sex" query="true"></t:dgCol>
	<t:dgCol title="出生日期" field="driverbir" formatter="yyyy/MM/dd" query="true"></t:dgCol>
	<t:dgCol title="号牌颜色" field="driverflapper" query="true"></t:dgCol>
	<t:dgCol title="车身颜色" field="carcolor" query="true"></t:dgCol>
	<t:dgCol title="车辆类型" field="cartype" query="true"></t:dgCol>
	<t:dgCol title="驾照号" field="driverlicencenum" query="true"></t:dgCol>
	<t:dgCol title="家庭地址" field="driveraddress" query="true"></t:dgCol>
	<t:dgCol title="备注" field="remark" query="true"></t:dgCol>
	<t:dgCol title="违章次数" field="illegal" query="true"></t:dgCol>
	<t:dgCol title="状态" field="status" query="true" replace="未处理_0,已处理_1"></t:dgCol>
	
	
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgFunOpt exp="status#eq#0" operationCode="szqm" funname="szqm(id)" title="审核" />
	
	<t:dgDelOpt title="删除" url="driverController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="driverController.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="driverController.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="driverController.do?addorupdate" funname="detail"></t:dgToolBar>
	<t:dgToolBar title="导出Excel" icon="icon-putout" onclick="driverListExportXls();"></t:dgToolBar>
	
<t:dgToolBar  title="打印罚单" icon="icon-print"  funname="printf"></t:dgToolBar>
<t:dgToolBar  title="打印设计" icon="icon-print"  funname="designf"></t:dgToolBar>  
<%-- <t:dgToolBar  title="打印控件安装" icon="icon-print"  funname="Preview1"></t:dgToolBar>	 --%>
	</t:datagrid>

</div>
</div>



<script type="text/javascript">
  
         var LODOP; //声明为全局变量   
       
	
	function Preview2() {		
		CreateDataBill();
	  	LODOP.PREVIEW();		
	};			
	function Setup2() {		
		CreateDataBill();
		LODOP.PRINT_SETUP();		
	};
	function Design2() {	
		LODOP.PRINT_DESIGN();
	};	
	function RealPrint() {		
		CreateDataBill();
		if (LODOP.PRINTA()) 
		   alert("已发出实际打印命令！"); 
		else 
		   alert("放弃打印！"); 
	};	

	function CreateFullBill(carnumber,carcolor,driverflapper,cartype,crimaddress,score,content,crimetime) {
		LODOP=getLodop();  
		
LODOP.PRINT_INITA(2,1,762,648,"车 辆 违 章 处 理 通 知 单 发 票 全 样");
LODOP.SET_PRINT_STYLE("FontColor","#000000");
LODOP.ADD_PRINT_SHAPE(1,151,44,653,1,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(1,179,44,653,1,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(1,207,44,653,1,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(1,235,44,653,1,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(0,118,143,1,117,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(0,118,380,1,117,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(0,119,490,1,117,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(0,179,143,1,282,0,1,"#000000");
LODOP.ADD_PRINT_SHAPE(1,461,44,653,1,0,1,"#000000");
LODOP.ADD_PRINT_TEXT(48,182,408,30,"车 辆 违 章 处 理 通 知 单");
LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
LODOP.ADD_PRINT_TEXT(127,58,68,20,"车辆牌号");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
LODOP.ADD_PRINT_TEXT(157,58,68,20,"车身颜色");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
LODOP.ADD_PRINT_TEXT(126,390,68,20,"扣分");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(156,390,68,20,"号牌颜色");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(185,58,68,20,"车辆类型");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
LODOP.ADD_PRINT_TEXT(213,58,68,20,"违章地点");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
LODOP.ADD_PRINT_TEXT(185,390,88,20,"交通客服");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(213,391,99,20,"违章时间");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(90,570,50,20,"编号：");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
LODOP.ADD_PRINT_TEXT(129,150,100,20,carnumber);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(154,150,100,20,carcolor);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(183,150,100,20,cartype);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(211,150,133,20,crimaddress);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(128,510,99,20,score);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(289,76,35,110,"违章内容");
LODOP.SET_PRINT_STYLEA(0,"FontSize",17);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(155,510,103,20,driverflapper);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(186,510,103,20,"0991-5940588");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(212,510,139,20,crimetime);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(90,624,76,20,"06775516");
LODOP.SET_PRINT_STYLEA(0,"FontName","System");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_SHAPE(2,118,43,656,442,0,1,"#000000");
LODOP.ADD_PRINT_TEXT(267,154,158,26,"该机动车在上述时间、地点  ");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(268,327,100,20,content);
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.SET_PRINT_STYLEA(0,"Underline",1);
LODOP.ADD_PRINT_TEXT(268,444,244,22,"违反了《中华人民共和国道路交通安全法》");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(302,153,530,67,"的规定,已被交通技术监控设备记录。请收到本通知书后十五天内，持本通知书和身份证（或驾驶证，行驶证）原件及复印件，到 乌鲁木齐市沙依巴克区公安交通警察大队乌鲁木齐西虹西路932号接受处理。");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(375,153,529,66,"根据《中华人民共和国机动车登记规定》第三十四条的规定，对于道路交通安全违法未处理完毕的，将不予核发检验合格标志。");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(470,48,155,25,"交通警察：（签名或签章）");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(475,456,100,20,"通知地点：");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_TEXT(532,456,163,25,"时间：    年    月     日");
LODOP.SET_PRINT_STYLEA(0,"FontColor","#000000");
LODOP.ADD_PRINT_LINE(281,306,282,437,0,1);
		

};	


function printf(title,url,id){

	var rowData=$('#'+id).datagrid('getSelected');
	if(!rowData){
			tip('请选择项目');
			return;
	
	}
	url='&id='+rowData.id;
	console.log(url);

	$.ajax({
	type:"post",
	url:"driverController.do?datagr"+url,
	dataType:"json",
	success:/* function(data){
	console.log(data.obj);
	carnumber=data.obj.address;
	console.log(lod);	

	

	}, */

	  

	function carmess1(data){

	var carnumber=data.obj.driverpassword;
	var driverflapper=data.obj.driverflapper;
	var carcolor=data.obj.carcolor;
	var cartype=data.obj.cartype;
	var m=parseInt(data.msg);
	if(m<0){
			tip('对不起！该用户没有违章信息');
			return;
	
	}
	console.log(m);
    var crimaddress=(data.obj.tIllegals[m].illegaladdress);
    var score=(data.obj.tIllegals[m].score);
    var content=(data.obj.tIllegals[m].illegalcontent);
	var crimetime=(data.obj.tIllegals[m].illegaldate);
CreateFullBill(carnumber,carcolor,driverflapper,cartype,crimaddress,score,content,crimetime); 
 	LODOP.PREVIEW();	
	},
	
	});
	

}

function designf(title,url,id){

	var rowData=$('#'+id).datagrid('getSelected');
	if(!rowData){
			tip('请选择项目');
			return;
	
	}
	url='&id='+rowData.id;
	console.log(url);

	$.ajax({
	type:"post",
	url:"driverController.do?datagr"+url,
	dataType:"json",
	success:/* function(data){
	console.log(data.obj);
	carnumber=data.obj.address;
	console.log(lod);	

	

	}, */

	  

	function carmess1(data){

	var carnumber=data.obj.driverpassword;
	var driverflapper=data.obj.driverflapper;
	var carcolor=data.obj.carcolor;
	var cartype=data.obj.cartype;
	var m=parseInt(data.msg);
	if(m<0){
			tip('对不起！该用户没有违章信息');
			return;
	
	}
	console.log(m);
    var crimaddress=(data.obj.tIllegals[m].illegaladdress);
    var score=(data.obj.tIllegals[m].score);
    var content=(data.obj.tIllegals[m].illegalcontent);
	var crimetime=(data.obj.tIllegals[m].illegaldate);
CreateFullBill(carnumber,carcolor,driverflapper,cartype,crimaddress,score,content,crimetime); 
 LODOP.PRINT_DESIGN();	
	},
	
	});
	

}

</script>










<script type="text/javascript">
	function szqm(id) {
		createwindow('审核', 'driverController.do?doCheck&id=' + id);
	}
	function getListSelections(){
		var ids = '';
		var rows = $("#driverList").datagrid("getSelections");
		for(var i=0;i<rows.length;i++){
			ids+=rows[i].id;
			ids+=',';
		}
		ids = ids.substring(0,ids.length-1);
		return ids;
	}	
	$(document).ready(function(){
		$("input[name='createDate_begin']").attr("class","easyui-datebox");
		$("input[name='createDate_end']").attr("class","easyui-datebox");
		$("input[name='driverbir']").attr("class","easyui-datebox");
	});
</script>
