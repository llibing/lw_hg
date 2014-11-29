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
import xjnu.edu.hg.entity.lw_hg.HgStudentTitleEntity;
import xjnu.edu.hg.entity.lw_hg.HgTeacherEntity;
import xjnu.edu.hg.entity.lw_hg.HgTitleEntity;
import xjnu.edu.hg.service.lw_hg.HgStudentTitleServiceI;

/**   
 * @Title: Controller
 * @Description: 学生选题信息
 * @author zhangdaihao
 * @date 2014-11-29 16:16:08
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/hgStudentTitleController")
public class HgStudentTitleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HgStudentTitleController.class);

	@Autowired
	private HgStudentTitleServiceI hgStudentTitleService;
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
	 * 学生选题信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hgStudentTitle")
	public ModelAndView hgStudentTitle(HttpServletRequest request) {
		 // 给学生外键查询条件中的下拉框准备数据
		List<HgStudentEntity> hgStudentEntityList = systemService.getList(HgStudentEntity.class);
		String realname=RoletoJson.listToReplaceStr(hgStudentEntityList, "realname", "id");
		if(!realname.equals("")){
			request.setAttribute("realnameReplace", realname);
		}else{
			request.setAttribute("realnameReplace", " _0");
		}
		// 给课题外键查询条件中的下拉框准备数据
		List<HgTitleEntity> hgTitleEntityList = systemService.getList(HgTitleEntity.class);
		String titleName=RoletoJson.listToReplaceStr(hgTitleEntityList, "titleName", "id");
		if(!titleName.equals("")){
			request.setAttribute("titleNameReplace", titleName);
		}else{
			request.setAttribute("titleNameReplace", " _0");
		}
		 // 给导师外键查询条件中的下拉框准备数据
		List<HgTeacherEntity> hgTeacherEntityList = systemService.getList(HgTeacherEntity.class);
		String teacherName=RoletoJson.listToReplaceStr(hgTeacherEntityList, "teacherName", "id");
		if(!teacherName.equals("")){
			request.setAttribute("teacherNameReplace", teacherName);
		}else{
			request.setAttribute("teacherNameReplace", " _0");
		}
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgStudentTitleList");
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
	public void datagrid(HgStudentTitleEntity hgStudentTitle,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HgStudentTitleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hgStudentTitle, request.getParameterMap());
		this.hgStudentTitleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除学生选题信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HgStudentTitleEntity hgStudentTitle, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hgStudentTitle = systemService.getEntity(HgStudentTitleEntity.class, hgStudentTitle.getId());
		message = "学生选题信息删除成功";
		hgStudentTitleService.delete(hgStudentTitle);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加学生选题信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HgStudentTitleEntity hgStudentTitle, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hgStudentTitle.getId())) {
			message = "学生选题信息更新成功";
			HgStudentTitleEntity t = hgStudentTitleService.get(HgStudentTitleEntity.class, hgStudentTitle.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hgStudentTitle, t);
				hgStudentTitleService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "学生选题信息更新失败";
			}
		} else {
			message = "学生选题信息添加成功";
			hgStudentTitleService.save(hgStudentTitle);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 学生选题信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HgStudentTitleEntity hgStudentTitle, HttpServletRequest req) {
		//传入学生的信息
	    List<HgStudentEntity> studentEntityList = new ArrayList<HgStudentEntity>();
	    studentEntityList.addAll((List)systemService.getList(HgStudentEntity.class));
	    req.setAttribute("studentEntityList", studentEntityList);
	    //传入课题的信息
	    List<HgTitleEntity> titleEntityList = new ArrayList<HgTitleEntity>();
	    titleEntityList.addAll((List)systemService.getList(HgTitleEntity.class));
	    req.setAttribute("titleEntityList", titleEntityList);
		if (StringUtil.isNotEmpty(hgStudentTitle.getId())) {
			hgStudentTitle = hgStudentTitleService.getEntity(HgStudentTitleEntity.class, hgStudentTitle.getId());
			req.setAttribute("hgStudentTitlePage", hgStudentTitle);
		}
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgStudentTitle");
	}
}
