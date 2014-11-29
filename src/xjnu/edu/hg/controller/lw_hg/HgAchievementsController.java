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
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import xjnu.edu.hg.entity.lw_hg.HgAchievementsEntity;
import xjnu.edu.hg.entity.lw_hg.HgStudentEntity;
import xjnu.edu.hg.service.lw_hg.HgAchievementsServiceI;

/**   
 * @Title: Controller
 * @Description: 成果展示
 * @author zhangdaihao
 * @date 2014-11-29 15:17:14
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/hgAchievementsController")
public class HgAchievementsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HgAchievementsController.class);

	@Autowired
	private HgAchievementsServiceI hgAchievementsService;
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
	 * 成果展示列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hgAchievements")
	public ModelAndView hgAchievements(HttpServletRequest request) {
		 // 给学生外键查询条件中的下拉框准备数据
		List<HgStudentEntity> hgStudentEntityList = systemService.getList(HgStudentEntity.class);
		String realname=RoletoJson.listToReplaceStr(hgStudentEntityList, "realname", "id");
		if(!realname.equals("")){
			request.setAttribute("realnameReplace", realname);
		}else{
			request.setAttribute("realnameReplace", " _0");
		}
		
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgAchievementsList");
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
	public void datagrid(HgAchievementsEntity hgAchievements,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HgAchievementsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hgAchievements, request.getParameterMap());
		this.hgAchievementsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除成果展示
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HgAchievementsEntity hgAchievements, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hgAchievements = systemService.getEntity(HgAchievementsEntity.class, hgAchievements.getId());
		message = "成果展示删除成功";
		hgAchievementsService.delete(hgAchievements);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加成果展示
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HgAchievementsEntity hgAchievements, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hgAchievements.getId())) {
			message = "成果展示更新成功";
			HgAchievementsEntity t = hgAchievementsService.get(HgAchievementsEntity.class, hgAchievements.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hgAchievements, t);
				hgAchievementsService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "成果展示更新失败";
			}
		} else {
			message = "成果展示添加成功";
			hgAchievementsService.save(hgAchievements);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 成果展示列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HgAchievementsEntity hgAchievements, HttpServletRequest req) {
		//传入学生的信息
	    List<HgStudentEntity> studentEntityList = new ArrayList<HgStudentEntity>();
	    studentEntityList.addAll((List)systemService.getList(HgStudentEntity.class));
	    req.setAttribute("studentEntityList", studentEntityList);
	   
	    
		if (StringUtil.isNotEmpty(hgAchievements.getId())) {
			hgAchievements = hgAchievementsService.getEntity(HgAchievementsEntity.class, hgAchievements.getId());
			req.setAttribute("hgAchievementsPage", hgAchievements);
		}
		return new ModelAndView("xjnu/edu/hg/lw_hg/hgAchievements");
	}
}
