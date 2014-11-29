package li.bing.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.annotation.config.AutoMenuOperation;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.demo.entity.test.JeecgDemo;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import li.bing.entity.Person;
import li.bing.entity.Tuser;
import li.bing.service.PersonService;

@Controller
@RequestMapping("/personController")
public class PersonController extends BaseController {
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(params = "personlist")
	public String personlist() {
		return "libing/personlist";
	}

	@RequestMapping(params = "datagrid")
	public void datagrid(Tuser user, HttpServletRequest request,
			HttpServletResponse response, DataGrid datagrid) {
		CriteriaQuery cq = new CriteriaQuery(Tuser.class, datagrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				user, request.getParameterMap());
		String total_salary = String.valueOf(personService.findOneForJdbc(
				"select sum(salary) as ssum from tuser").get("ssum"));
		/*
		 * 说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
		 */
		datagrid.setFooter("salary:"
				+ (total_salary.equalsIgnoreCase("null") ? "0.0" : total_salary)
				+ ",age,email:合计");
		this.personService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, datagrid);
	}

	@RequestMapping(params = "addorupdate")
	public String addorupdate(Tuser tuser, HttpServletRequest request) {

		if (tuser.getId() != null) {
			tuser = this.personService.get(Tuser.class, tuser.getId());
			request.setAttribute("person", tuser);
		}
		return "libing/person";
	}
	
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(Tuser tuser) {
		AjaxJson j = new AjaxJson();

		if (StringUtils.isNotEmpty(tuser.getId())) {

			j.setMsg("更新成功！！");
			this.personService.updateEntitie(tuser);

		} else {
			try{
				
			tuser.setStatus("0");
			this.personService.save(tuser);
			j.setMsg("添加成功！！！");
			}catch (Exception e) {
				e.printStackTrace();
				j.setMsg("对不起！用户名已存在！！！");
			}
		}
		return j;
	}

	@RequestMapping(params = "doCheck")
	public String doCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		if (StringUtil.isNotEmpty(id)) {
			Tuser tuser = personService.getEntity(Tuser.class, id);
			request.setAttribute("tuser", tuser);
		}
		return "libing/person_check";
	}

	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(Tuser tuser) {
		AjaxJson j = new AjaxJson();
		if (StringUtils.isNotEmpty(tuser.getId())) {
			this.personService.delete(tuser);
			j.setMsg("删除成功！！");
		}
		return j;
	}
	
	
	
	@RequestMapping(params = "print")
	public ModelAndView print(Tuser tuser, HttpServletRequest req) {
		
		if (tuser.getId() != null) {
			tuser = this.personService.get(Tuser.class, tuser.getId());
			req.setAttribute("person", tuser);
	
			if ("0".equals(tuser.getSex()))
				req.setAttribute("sex", "男");
			if ("1".equals(tuser.getSex()))
				req.setAttribute("sex", "女");
		}
		return new ModelAndView("libing/personPrint");
	}
	
	@RequestMapping(params = "printfadan")
	public ModelAndView printfadan(Tuser tuser, HttpServletRequest req) {
		return new ModelAndView("libing/personPrintfadan");
	}
	
	@RequestMapping(params = "saveAuthor")
	@ResponseBody
	public AjaxJson saveAuthor(Tuser tuser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tuser.getId())) {
			j.setMsg("测试-用户申请成功");
			Tuser t = personService.get(Tuser.class, tuser.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tuser, t);
				t.setStatus("1");
				personService.saveOrUpdate(t);
				j.setMsg("测试-用户申请成功");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return j;
	}

}
