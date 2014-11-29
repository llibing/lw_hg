<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'personPrint.jsp' starting page</title>
    
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=basePath%>/plug-in/lodop/LodopFuncs.js"></script>


  </head>
 
  <body>
    
    <t:formvalid layout="table" dialog="true" formid="personForm" usePlugin="password" action="personController.do?save">
       <input type="hidden" name="id" value="${person.id }"/>
       <table class="formtable" cellpadding="0" cellspacing="1">
         <tr>
           <td align="right" width="15%" nowrap><label class="Validform_label"> 用户名: </label></td>
           <td class="value" width="85%">
              ${person.name }
              
          </td>
         </tr>
         
         <tr>
			<td align="right" nowrap><label class="Validform_label"> 手机号码: </label></td>
			<td class="value">${person.mobilePhone}</td>
		</tr>
         <tr>
			<td align="right"><label class="Validform_label"> 办公电话: </label></td>
			<td class="value">${person.officePhone}</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 常用邮箱: </label></td>
			<td class="value">${person.email}</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 年龄: </label></td>
			<td class="value">${person.age}</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 工资: </label></td>
			<td class="value">${person.salary}</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 生日: </label></td>
			<td class="value">${person.birthday }</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 创建日期: </label></td>
			<td class="value">${person.createDate }</td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 性别: </label></td>
			<td class="value">${sex}</td>
		</tr>

		
       </table>
    </t:formvalid>
    
    <a href="javascript:prn3_preview()">打印预览</a>
    
    <script language="javascript" type="text/javascript">   
        var LODOP; //声明为全局变量 
	function prn1_preview() {	
		CreateOneFormPage();	
		LODOP.PREVIEW();	
	};
	function prn1_print() {		
		CreateOneFormPage();
		LODOP.PRINT();	
	};
	function prn1_printA() {		
		CreateOneFormPage();
		LODOP.PRINTA(); 	
	};	
	function CreateOneFormPage(){
		LODOP=getLodop();  
		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
		LODOP.SET_PRINT_STYLE("FontSize",18);
		LODOP.SET_PRINT_STYLE("Bold",1);
		LODOP.ADD_PRINT_TEXT(50,231,260,39,"打印页面部分内容");
		LODOP.ADD_PRINT_HTM(88,200,350,600,document.getElementById("form1").innerHTML);
	};	                     
	function prn2_preview() {	
		CreateTwoFormPage();	
		LODOP.PREVIEW();	
	};
	function prn2_manage() {	
		CreateTwoFormPage();
		LODOP.PRINT_SETUP();	
	};	
	function CreateTwoFormPage(){
		LODOP=getLodop();  
		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单二");
		LODOP.ADD_PRINT_RECT(70,27,634,242,0,1);
		LODOP.ADD_PRINT_TEXT(29,236,279,38,"页面内容改变布局打印");
		LODOP.SET_PRINT_STYLEA(2,"FontSize",18);
		LODOP.SET_PRINT_STYLEA(2,"Bold",1);
		LODOP.ADD_PRINT_HTM(88,40,321,185,document.getElementById("form1").innerHTML);
		LODOP.ADD_PRINT_HTM(87,355,285,187,document.getElementById("form2").innerHTML);
		LODOP.ADD_PRINT_TEXT(319,58,500,30,"注：其中《表单一》按显示大小，《表单二》在程序控制宽度(285px)内自适应调整");
	};              
	function prn3_preview(){
		LODOP=getLodop();  
		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_全页");
		LODOP.ADD_PRINT_HTM(0,0,"100%","100%",document.documentElement.innerHTML);
		LODOP.PREVIEW();	
	};	
</script>
    
    
    
   
<p><a href="JavaScript:Preview1()">打印罚单</a></p>           

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
    
    
    </body>
</html>
