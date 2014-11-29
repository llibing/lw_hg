<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#printCustomBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	});
	$('#prinCustomBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	});
	
	
	$('#addCustomBtn').bind('click', function(){   
 		 var tr =  $("#add_jeecgStudent_table_template tr").clone();
	 	 $("#add_jeecgStudent_table").append(tr);
	 	 resetTrNum('add_jeecgStudent_table');
    });  
	$('#delCustomBtn').bind('click', function(){   
      	$("#add_jeecgStudent_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_jeecgStudent_table'); 
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    });
   function resetTrNum(tableId) {
		$tbody = $("#"+tableId+"");
		$tbody.find('>tr').each(function(i){
			$(':input, select', this).each(function(){
				var $this = $(this), name = $this.attr('name'), val = $this.val();
				if(name!=null){
					if (name.indexOf("#index#") >= 0){
						$this.attr("name",name.replace('#index#',i));
					}else{
						var s = name.indexOf("[");
						var e = name.indexOf("]");
						var new_name = name.substring(s+1,e);
						$this.attr("name",name.replace(new_name,i));
					}
				}
			});
		});
	} 
</script>

<script type="text/javascript" src="<%=basePath%>/plug-in/jquery/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="<%=basePath%>/plug-in/jquery/js/content_zoom.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/plug-in/jquery/js/commom.css">
<script type="text/javascript">
	$(document).ready(function() {
		$('div.small_pic a').fancyZoom({scaleImg: true, closeOnClick: true});
		/* $('#zoom_word_1').fancyZoom({width:400, height:200});
		$('#zoom_word_2').fancyZoom();
		$('#zoom_flash').fancyZoom(); */
	});
</script>

<style type="text/css">

.small_pic{display:inline-block; width:30%;   text-align:center; *display:inline; zoom:1; vertical-align:middle;}
.small_pic img{padding:3px; background:#ffffff; border:1px solid #cccccc; vertical-align:middle;}
</style>


<div style="padding: 3px; height: 25px; width: auto;" class="datagrid-toolbar"><a id="addCustomBtn" href="#">添加</a> <a id="delCustomBtn" href="#">删除</a></div>
<div style="width: auto; height: 300px; overflow-y: auto; overflow-x: scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="jeecgOrderCustom_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="left" bgcolor="#EEEEEE">现场图片</td>
		<td align="left" bgcolor="#EEEEEE">违章代码</td>
		<td align="left" bgcolor="#EEEEEE">罚款</td>
		<td align="left" bgcolor="#EEEEEE">分数</td>
		<td align="left" bgcolor="#EEEEEE">违法内容</td>
		<td align="left" bgcolor="#EEEEEE">违法日期</td>
		
		
		<td align="left" bgcolor="#EEEEEE">违章地址</td>
		<td align="left" bgcolor="#EEEEEE">处理结果</td>
		
		
	</tr>
	<tbody id="add_jeecgStudent_table">
		<c:if test="${fn:length(illegalList)  <= 0 }">
	
			<tr>
				<td align="center"><input style="width: 15px;" type="checkbox" name="ck" /></td>
				<td align="left"><img name="TIllegals[0].image"  width="80" height="60"  /></td>
				<td align="left"><input name="TIllegals[0].illegalcode" nullmsg="请输入相应的违章代码！" datatype="*" errormsg="违章代码填写不正确" maxlength="30" type="text" style="width: 60px;" ></td>
				
				
				
<%-- <t:ckfinder name="image" uploadType="Images" value="${jeecgDemoCkfinderPage.image}" width="100" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
 --%>
				
				<td align="left"><input name="TIllegals[0].illegalfine" nullmsg="请输入相应的罚款金额！" datatype="d" errormsg="罚款金额填写不正确" maxlength="20" type="text" style="width: 60px;"></td>
			    <td align="left"><input name="TIllegals[0].score" nullmsg="请输入相应的违章扣分" datatype="n" errormsg="违章扣分格式不对！" maxlength="30" type="text" style="width: 30px;"></td>
			    <td align="left"><input name="TIllegals[0].illegalcontent" errormsg="违规内容应该为2到100位" datatype="s2-100" nullmsg="请输入违规内容！" maxlength="200" type="text" style="width: 300px;"></td>
			    <!-- <td align="left"><input name="TIllegals[0].illegaldate" maxlength="20" type="text" style="width: 100px;"></td>-->
			    
			    <td align="left"><input name="TIllegals[0].illegaldate" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 100px" 
				<%-- value="<fmt:formatDate type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" --%>
				errormsg="生日格式不正确!" ignore="ignore"><!--   <span class="Validform_checktip"></span>--></td>
			    
			    <td align="left"><input name="TIllegals[0].illegaladdress" maxlength="100" type="text" style="width: 100px;"></td>
			    <td align="left"><input name="TIllegals[0].handle" maxlength="200" type="text" style="width: 100px;"></td>
			</tr>
		</c:if>
		<c:if test="${fn:length(illegalList)  > 0 }">
			<c:forEach items="${illegalList}" var="poVal" varStatus="stuts">
				<tr>
				    <input type="hidden" name="TIllegals[${stuts.index }].image"  value="${poVal.image}"  >
					<td align="center"><input style="width: 20px;" type="checkbox" name="ck" /></td>
					
					<td align="left" class="value">
					<div class="small_pic">
                        <a href="#xinxi_${stuts.index }">
					  <img src="${poVal.image}"   width="80" height="60" />
					    </a>
                    </div>
					</td>
					
					<div id="xinxi_${stuts.index }" style="display:none;"><img src="${poVal.image}" width="460" height="460"/></div>
					
					
					<td align="left"><input name="TIllegals[${stuts.index }].illegalcode" nullmsg="请输入相应的违章代码！" datatype="*" errormsg="违章代码填写不正确" maxlength="30" type="text" value="${poVal.illegalcode }" style="width: 60px;" ></td>
					
					<td align="left"><input name="TIllegals[${stuts.index }].illegalfine" nullmsg="请输入相应的罚款金额！" datatype="d" errormsg="罚款金额填写不正确" maxlength="20" type="text" value="${poVal.illegalfine }" style="width: 60px;"></td>
					<td align="left"><input name="TIllegals[${stuts.index }].score" nullmsg="请输入相应的违章扣分" datatype="n" errormsg="违章扣分格式不对！" maxlength="30" type="text" value="${poVal.score }" style="width: 30px;"></td>
					<td align="left"><input name="TIllegals[${stuts.index }].illegalcontent" errormsg="违规内容应该为2到100位" datatype="s2-100" nullmsg="请输入违规内容！" maxlength="200" type="text" value="${poVal.illegalcontent }" style="width: 300px;"></td>
					<!-- <td align="left"><input name="TIllegals[${stuts.index }].illegaldate" maxlength="50" type="text" value="${poVal.illegaldate }" style="width: 100px;"></td> -->
					
					<td align="left"><input name="TIllegals[${stuts.index }].illegaldate" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 100px" value="${poVal.illegaldate }" 
				errormsg="生日格式不正确!" ignore="ignore"></td>
					
					
					<td align="left"><input name="TIllegals[${stuts.index }].illegaladdress" maxlength="100" type="text" value="${poVal.illegaladdress }" style="width: 100px;"></td>
					<td align="left"><input name="TIllegals[${stuts.index }].handle" maxlength="200" type="text" value="${poVal.handle }" style="width: 100px;"></td>
					
					
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>

</div>



