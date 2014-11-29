package xjnu.edu.hg.controller.lw_hg;
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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import xjnu.edu.hg.entity.lw_hg.HgTeacherEntity;
import xjnu.edu.hg.service.lw_hg.HgTeacherServiceI;

/**   
 * @Title: Controller
 * @Description: 导师信息
 * @author zhangdaihao
 * @date 2014-11-29 15:19:38
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/hgTeacherController")
public class HgTeacherController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HgTeacherController.class);

	@Autowired
	private HgTeacherServiceI hgTeacherService;
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
	 * 导师信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hgTeacher")
	public ModelAndView hgTeacher(HttpServletRequest request) {
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgTeacherList");
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
	public void datagrid(HgTeacherEntity hgTeacher,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HgTeacherEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hgTeacher, request.getParameterMap());
		this.hgTeacherService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除导师信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HgTeacherEntity hgTeacher, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hgTeacher = systemService.getEntity(HgTeacherEntity.class, hgTeacher.getId());
		message = "导师信息删除成功";
		hgTeacherService.delete(hgTeacher);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加导师信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HgTeacherEntity hgTeacher, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hgTeacher.getId())) {
			message = "导师信息更新成功";
			HgTeacherEntity t = hgTeacherService.get(HgTeacherEntity.class, hgTeacher.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hgTeacher, t);
				hgTeacherService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "导师信息更新失败";
			}
		} else {
			message = "导师信息添加成功";
			hgTeacherService.save(hgTeacher);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 导师信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HgTeacherEntity hgTeacher, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hgTeacher.getId())) {
			hgTeacher = hgTeacherService.getEntity(HgTeacherEntity.class, hgTeacher.getId());
			req.setAttribute("hgTeacherPage", hgTeacher);
		}
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgTeacher");
	}
}
