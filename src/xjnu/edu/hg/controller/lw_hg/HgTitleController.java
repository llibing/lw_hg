package xjnu.edu.hg.controller.lw_hg;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import xjnu.edu.hg.entity.lw_hg.HgStudentEntity;
import xjnu.edu.hg.entity.lw_hg.HgTeacherEntity;
import xjnu.edu.hg.entity.lw_hg.HgTitleEntity;
import xjnu.edu.hg.service.lw_hg.HgTitleServiceI;

/**   
 * @Title: Controller
 * @Description: 课题列表
 * @author zhangdaihao
 * @date 2014-11-29 15:20:26
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/hgTitleController")
public class HgTitleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HgTitleController.class);

	@Autowired
	private HgTitleServiceI hgTitleService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 课题列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hgTitle")
	public ModelAndView hgTitle(HttpServletRequest request) {
		 // 给导师外键查询条件中的下拉框准备数据
		List<HgTeacherEntity> hgTeacherEntityList = systemService.getList(HgTeacherEntity.class);
		String teacherName=RoletoJson.listToReplaceStr(hgTeacherEntityList, "teacherName", "id");
		if(!teacherName.equals("")){
			request.setAttribute("teacherNameReplace", teacherName);
		}else{
			request.setAttribute("teacherNameReplace", " _0");
		}
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgTitleList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(HgTitleEntity hgTitle,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HgTitleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hgTitle, request.getParameterMap());
		this.hgTitleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除课题列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HgTitleEntity hgTitle, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hgTitle = systemService.getEntity(HgTitleEntity.class, hgTitle.getId());
		message = "课题列表删除成功";
		hgTitleService.delete(hgTitle);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加课题列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HgTitleEntity hgTitle, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hgTitle.getId())) {
			message = "课题列表更新成功";
			HgTitleEntity t = hgTitleService.get(HgTitleEntity.class, hgTitle.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hgTitle, t);
				hgTitleService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "课题列表更新失败";
			}
		} else {
			message = "课题列表添加成功";
			hgTitleService.save(hgTitle);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 课题列表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HgTitleEntity hgTitle, HttpServletRequest req) {
		//传入学生的信息
	    List<HgTeacherEntity> teacherEntityList = new ArrayList<HgTeacherEntity>();
	    teacherEntityList.addAll((List)systemService.getList(HgTeacherEntity.class));
	    req.setAttribute("teacherEntityList", teacherEntityList);
		
		if (StringUtil.isNotEmpty(hgTitle.getId())) {
			hgTitle = hgTitleService.getEntity(HgTitleEntity.class, hgTitle.getId());
			req.setAttribute("hgTitlePage", hgTitle);
		}
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgTitle");
	}
}
