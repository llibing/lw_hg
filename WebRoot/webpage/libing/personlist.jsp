
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/context/mytags.jsp" %>
<script type="text/javascript" src="<%=basePath%>/plug-in/lodop/LodopFuncs.js"></script>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
    <t:datagrid actionUrl="personController.do?datagrid" name="personList" queryMode="group" autoLoadData="true"
    sortName="name" fitColumns="true"
	idField="id" fit="true" checkbox="true">
      <t:dgCol field="id" hidden="false" title=""></t:dgCol>
      <t:dgCol field="name" title="姓名"  query="true" frozenColumn="true"></t:dgCol>
      <t:dgCol field="pwd" title="密码" query="true"></t:dgCol>
     
	<t:dgCol title="电话号码" sortable="false" field="mobilePhone" query="true"></t:dgCol>
	<t:dgCol title="办公电话" field="officePhone" query="true"></t:dgCol>
	<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" query="true" queryMode="group"></t:dgCol>
	<t:dgCol title="邮箱" field="email" query="true"></t:dgCol>
	<t:dgCol title="年龄" sortable="true" field="age" query="true"></t:dgCol>
	<t:dgCol title="工资" field="salary" query="true"></t:dgCol>
	<t:dgCol title="生日" field="birthday" formatter="yyyy/MM/dd" query="true"></t:dgCol>
	<t:dgCol title="性别" sortable="true" field="sex" dictionary="sex" query="true"></t:dgCol>
	<t:dgCol title="状态" field="status" query="true" replace="未处理_0,已处理_1"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgFunOpt exp="status#eq#0" operationCode="szqm" funname="szqm(id)" title="审核" />
	
	  <t:dgDelOpt title="删除" url="personController.do?del&id={id}" />
      <t:dgToolBar title="人物录入" icon="icon-add" url="personController.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="人物编辑" icon="icon-edit" url="personController.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar operationCode="print" title="打印" icon="icon-print" url="personController.do?print" funname="detail"></t:dgToolBar>
	
   
	<t:dgToolBar operationCode="print" title="打印罚单" icon="icon-print"  funname="Preview1()"></t:dgToolBar>
	
    </t:datagrid>
 </div>
</div>
<script type="text/javascript">
	function szqm(id) {
		createwindow('审核', 'personController.do?doCheck&id=' + id);
	}
	function getListSelections(){
		var ids = '';
		var rows = $("#personList").datagrid("getSelections");
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
		$("input[name='birthday']").attr("class","easyui-datebox");
	});
</script>
   

<script language="javascript" type="text/javascript">
        var LODOP; //声明为全局变量   
	function Preview1() {		
		CreateFullBill();
	  	LODOP.PREVIEW();		
	};
	function Design1() {		
		CreateFullBill();
//		LODOP.SET_SHOW_MODE("HIDE_ITEM_LIST",true);//设置对象列表默认处于关闭状态
//		LODOP.SET_SHOW_MODE("TEXT_SHOW_BORDER",1); //设置字符编辑框默认为single	
		LODOP.PRINT_DESIGN();		
	};
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

	function CreateFullBill() {
		LODOP=getLodop();  
		LODOP.PRINT_INITA(10,10,762,533,"打印控件功能演示_Lodop功能_移动公司发票全样");
		LODOP.SET_PRINT_STYLE("FontColor","#0000FF");
		LODOP.ADD_PRINT_SHAPE(2,116,43,655,373,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(1,144,44,653,1,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(1,172,44,653,1,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,116,143,1,56,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,116,488,1,56,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,116,574,1,372,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,172,166,1,282,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,172,415,1,282,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(1,454,44,653,1,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,454,130,1,34,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,454,483,1,34,0,1,"#800000");
		LODOP.ADD_PRINT_SHAPE(0,64,62,120,1,0,1,"#0000FF");
		LODOP.ADD_PRINT_SHAPE(3,29,62,32,32,0,4,"#0000FF");
		LODOP.ADD_PRINT_SHAPE(3,21,300,147,75,0,3,"#FF0000");
		LODOP.ADD_PRINT_SHAPE(3,26,307,132,65,0,1,"#FF0000");
		LODOP.ADD_PRINT_TEXT(33,192,408,30,"中国移动通信集团北京有限公司专用发票");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(68,326,100,25,"发 票 联");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(29,98,84,35,"中国移动通信CHINA MOBILE");
		LODOP.ADD_PRINT_SHAPE(2,37,69,18,15,0,1,"#0000FF");
		LODOP.ADD_PRINT_SHAPE(2,40,73,10,9,0,1,"#0000FF");
		LODOP.ADD_PRINT_TEXT(70,64,117,20,"移 动 信 息 专 家");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",8);
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(124,58,68,20,"客户名称");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(152,58,68,20,"手机号码");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(124,497,68,20,"受理类别");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(152,497,68,20,"合 同 号");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(465,54,68,20,"大写金额");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(465,495,104,20,"小写金额    ￥: ");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(98,56,47,20,"编号：");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(98,259,48,20,"日期：");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(97,500,71,20,"发票号码：");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(496,54,83,20,"话费帐期：");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(496,321,83,20,"营业员工号：");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(496,480,93,20,"收款单位名称：");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(226,703,27,121,"第二联发票联");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(203,21,17,195,"京地税准印八九号五百万份");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",8);
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
		LODOP.ADD_PRINT_TEXT(126,150,100,20,"郭德强");
		LODOP.ADD_PRINT_TEXT(151,150,100,20,"13954885188");
		LODOP.ADD_PRINT_TEXT(125,584,99,20,"发票打印(第1次)");
		LODOP.ADD_PRINT_TEXT(465,140,198,20,"陆百柒拾捌元叁角零分");
		LODOP.ADD_PRINT_TEXT(465,599,70,20,"678.30");
		LODOP.ADD_PRINT_TEXT(496,408,59,20,"H112063");
		LODOP.ADD_PRINT_TEXT(191,58,100,20,"国内漫游通话");
		LODOP.ADD_PRINT_TEXT(191,217,100,20,"584.00");
		LODOP.ADD_PRINT_TEXT(222,58,100,20,"增值业务费");
		LODOP.ADD_PRINT_TEXT(222,217,100,20,"48.30");
		LODOP.ADD_PRINT_TEXT(251,58,100,20,"代收费");
		LODOP.ADD_PRINT_TEXT(251,217,100,20,"50.00");
		LODOP.ADD_PRINT_TEXT(280,58,100,20,"优惠费");
		LODOP.ADD_PRINT_TEXT(280,217,100,20,"4.00");
		LODOP.ADD_PRINT_TEXT(98,101,150,20,"101081005747319387");
		LODOP.ADD_PRINT_TEXT(97,307,150,20,"2008年10月19日 10:28:38");
		LODOP.ADD_PRINT_TEXT(152,584,103,20,"138860016786");
		LODOP.ADD_PRINT_TEXT(95,571,112,20,"06775516");
		LODOP.SET_PRINT_STYLEA(0,"FontName","System");
		LODOP.ADD_PRINT_TEXT(76,500,71,20,"发票代码：");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#800000");
		LODOP.SET_PRINT_STYLEA(0,"Alignment",3);
		LODOP.ADD_PRINT_TEXT(74,571,112,20,"237090742401");
		LODOP.SET_PRINT_STYLEA(0,"FontName","System");
		LODOP.SET_PRINT_STYLEA(0,"FontColor","#FF0000");
		LODOP.ADD_PRINT_TEXT(496,135,183,20,"2008年09月(20080901-20080930)");
		LODOP.ADD_PRINT_TEXT(496,572,112,20,"-王府井中心店营");
		LODOP.ADD_PRINT_TEXT(311,217,100,20,"678.30");
		LODOP.ADD_PRINT_TEXT(311,58,100,20,"费用合计");

};	
function CreateDataBill() {
		LODOP=getLodop();  
		LODOP.PRINT_INITA(10,10,762,533,"打印控件功能演示_Lodop功能_移动公司发票套打");
		LODOP.SET_PRINT_STYLE("FontColor","#0000FF");
		LODOP.ADD_PRINT_TEXT(126,150,100,20,"郭德强");
		LODOP.ADD_PRINT_TEXT(151,150,100,20,"13954885188");
		LODOP.ADD_PRINT_TEXT(125,584,99,20,"发票打印(第1次)");
		LODOP.ADD_PRINT_TEXT(465,140,198,20,"陆百柒拾捌元叁角零分");
		LODOP.ADD_PRINT_TEXT(465,599,70,20,"678.30");
		LODOP.ADD_PRINT_TEXT(496,408,59,20,"H112063");
		LODOP.ADD_PRINT_TEXT(191,58,100,20,"国内漫游通话");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
		LODOP.ADD_PRINT_TEXT(191,217,100,20,"584.00");
		LODOP.ADD_PRINT_TEXT(222,58,100,20,"增值业务费");
		LODOP.ADD_PRINT_TEXT(222,217,100,20,"48.30");
		LODOP.ADD_PRINT_TEXT(251,58,100,20,"代收费");
		LODOP.ADD_PRINT_TEXT(251,217,100,20,"50.00");
		LODOP.ADD_PRINT_TEXT(280,58,100,20,"优惠费");
		LODOP.ADD_PRINT_TEXT(280,217,100,20,"4.00");
		LODOP.ADD_PRINT_TEXT(98,101,150,20,"101081005747319387");
		LODOP.ADD_PRINT_TEXT(97,307,150,20,"2008年10月19日 10:28:38");
		LODOP.ADD_PRINT_TEXT(152,584,103,20,"138860016786");
		LODOP.ADD_PRINT_TEXT(95,571,112,20,"06775516");
		LODOP.SET_PRINT_STYLEA(0,"FontName","System");
		LODOP.ADD_PRINT_TEXT(496,135,183,20,"2008年09月(20080901-20080930)");
		LODOP.ADD_PRINT_TEXT(496,572,112,20,"-王府井中心店营");
		LODOP.ADD_PRINT_TEXT(311,217,100,20,"678.30");
		LODOP.ADD_PRINT_TEXT(311,58,100,20,"费用合计");
}
</script> 



