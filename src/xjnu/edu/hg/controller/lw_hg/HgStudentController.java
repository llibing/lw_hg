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

import xjnu.edu.hg.entity.lw_hg.HgStudentEntity;
import xjnu.edu.hg.service.lw_hg.HgStudentServiceI;

/**   
 * @Title: Controller
 * @Description: 学生列表
 * @author zhangdaihao
 * @date 2014-11-29 15:18:51
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/hgStudentController")
public class HgStudentController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HgStudentController.class);

	@Autowired
	private HgStudentServiceI hgStudentService;
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
	 * 学生列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hgStudent")
	public ModelAndView hgStudent(HttpServletRequest request) {
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgStudentList");
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
	public void datagrid(HgStudentEntity hgStudent,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HgStudentEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hgStudent, request.getParameterMap());
		this.hgStudentService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除学生列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HgStudentEntity hgStudent, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hgStudent = systemService.getEntity(HgStudentEntity.class, hgStudent.getId());
		message = "学生列表删除成功";
		hgStudentService.delete(hgStudent);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加学生列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HgStudentEntity hgStudent, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hgStudent.getId())) {
			message = "学生列表更新成功";
			HgStudentEntity t = hgStudentService.get(HgStudentEntity.class, hgStudent.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hgStudent, t);
				hgStudentService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "学生列表更新失败";
			}
		} else {
			message = "学生列表添加成功";
			hgStudentService.save(hgStudent);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 学生列表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HgStudentEntity hgStudent, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hgStudent.getId())) {
			hgStudent = hgStudentService.getEntity(HgStudentEntity.class, hgStudent.getId());
			req.setAttribute("hgStudentPage", hgStudent);
		}
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgStudent");
	}
}
