package li.bing.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import li.bing.entity.TDriveruser;
import li.bing.entity.TIllegal;
import li.bing.service.DriverService;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.hibernate.SessionFactory;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExcelTitle;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/driverController")
public class DriverController extends BaseController {

	private static final Logger log = Logger.getLogger(TDriveruser.class);
	private DriverService driverService;
	private String message;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DriverService getDriverService() {
		return driverService;
	}

	@Autowired
	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

	@RequestMapping(params = "driverList")
	public ModelAndView course(HttpServletRequest request) {
		return new ModelAndView("driver/driverList");
	}

	@RequestMapping(params = "datagrid")
	public void datagrid(TDriveruser tdriveruser, HttpServletRequest request,
			HttpServletResponse response, DataGrid datagrid) {

		CriteriaQuery cq = new CriteriaQuery(TDriveruser.class, datagrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tdriveruser, request.getParameterMap());

		this.driverService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, datagrid);

	}

	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TDriveruser tdriveruser,
			HttpServletRequest req) {

		if (StringUtil.isNotEmpty(tdriveruser.getId())) {
			tdriveruser = driverService.getEntity(TDriveruser.class,
					tdriveruser.getId());

			req.setAttribute("tdriveruser", tdriveruser);
		}
		return new ModelAndView("driver/driveruser");
	}

	@RequestMapping(params = "illegalList")
	public ModelAndView studentsList(TDriveruser tdriveruser,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tdriveruser.getId())) {
			tdriveruser = driverService.getEntity(TDriveruser.class,
					tdriveruser.getId());
			req.setAttribute("illegalList", tdriveruser.getTIllegals());
		}
		return new ModelAndView("driver/illegalList");
	}

	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TDriveruser tdriveruser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tdriveruser.getId())) {
			message = "用户更新成功";
			try {
				tdriveruser.setIllegal(tdriveruser.getTIllegals().size() + "");
				tdriveruser.setStatus("0");
				driverService.updateEntitie(tdriveruser);
				List<TIllegal> tillegal = driverService.findByProperty(
						TIllegal.class, "TDriveruser.id", tdriveruser.getId());
				driverService.deleteAllEntitie(tillegal);
				driverService.updateTIllegal(tdriveruser);
			} catch (Exception e) {
				e.printStackTrace();
				message = "用户更新失败";
			}

		} else {
			message = "用户添加成功";
			tdriveruser.setStatus("0");
			tdriveruser.setIllegal(tdriveruser.getTIllegals().size() + "");
			driverService.saveTdriver(tdriveruser);

		}
		j.setMsg(message);
		return j;
	}

	/*
	 * @RequestMapping(params = "save1")
	 * 
	 * @ResponseBody public AjaxJson save1(TDriveruser tdriveruser,
	 * HttpServletRequest request) { AjaxJson j = new AjaxJson(); if
	 * (StringUtil.isNotEmpty(tdriveruser.getId())) { message = "用户更新成功"; try {
	 * tdriveruser.setIllegal(tdriveruser.getTIllegals().size() + "");
	 * 
	 * driverService.updateTIllegal(tdriveruser); } catch (Exception e) {
	 * e.printStackTrace(); message = "用户更新失败"; }
	 * 
	 * } else { message = "用户添加成功"; tdriveruser.setStatus("0");
	 * tdriveruser.setIllegal(tdriveruser.getTIllegals().size() + "");
	 * driverService.saveTdriver(tdriveruser);
	 * 
	 * } j.setMsg(message); return j; }
	 */

	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TDriveruser tdriveruser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tdriveruser = driverService.getEntity(TDriveruser.class,
				tdriveruser.getId());
		message = "用户删除成功";
		delRoleUser(tdriveruser);
		driverService.delete(tdriveruser);

		j.setMsg(message);
		return j;
	}

	public void delRoleUser(TDriveruser tdriveruser) {
		// 同步删除用户角色关联表
		List<TIllegal> tillegalList = driverService.findByProperty(
				TIllegal.class, "TDriveruser.id", tdriveruser.getId());
		if (tillegalList.size() >= 1) {
			for (TIllegal tillegal : tillegalList) {
				driverService.delete(tillegal);
			}
		}
	}

	@RequestMapping(params = "saveAuthor")
	@ResponseBody
	public AjaxJson saveAuthor(TDriveruser tdriveruser,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tdriveruser.getId())) {
			j.setMsg("用户审核成功");
			TDriveruser t = driverService.get(TDriveruser.class,
					tdriveruser.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tdriveruser, t);
				t.setStatus("1");
				driverService.saveOrUpdate(t);
				j.setMsg("用户审核成功");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return j;
	}

	@RequestMapping(params = "doCheck")
	public String doCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		if (StringUtil.isNotEmpty(id)) {
			TDriveruser tdriveruser = driverService.getEntity(
					TDriveruser.class, id);
			request.setAttribute("tdriveruser", tdriveruser);
		}
		return "driver/driver_check";
	}

	@RequestMapping(params = "datagr")
	public void datagr(TDriveruser tdriveruser, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		AjaxJson j = new AjaxJson();
		TDriveruser tdriver;
		String id=request.getParameter("id");
		
		if(StringUtil.isNotEmpty(id)){
	
			tdriver=driverService.getEntity(TDriveruser.class,
					id);
			j.setMsg(tdriver.getTIllegals().size()-1+"");
		}else{
			String driver = request.getParameter("driver");
		System.out.println(driver + "sdfdfsgfdfffffffffffffffffffffffff");
		tdriver = driverService.findUniqueByProperty(
				TDriveruser.class, "driverpassword", driver);
		}
		
		if(tdriver!=null){
		   j.setObj(tdriver);
		}
		/*else{
			j.setMsg("没有查到");
		}*/
		// response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("sddddd"+j.getJsonStr());
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(j.getJsonStr());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(TDriveruser tdriveruser, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "用户信息";
			// 根据浏览器进行转码，使其支持中文文件名
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			CriteriaQuery cq = new CriteriaQuery(TDriveruser.class, dataGrid);

			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
					.installHql(cq, tdriveruser, request.getParameterMap());

			List<TDriveruser> tdriveruser1 = this.driverService
					.getListByCriteriaQuery(cq, false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("用户违章信息列表",
					"", "导出信息"), TDriveruser.class, tdriveruser1);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}

	@RequestMapping(params = "addillegal")
	public ModelAndView addillegal(TDriveruser tdriveruser, TIllegal tillegal,
			HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		String driver = request.getParameter("driver");

		TDriveruser tdriver = driverService.findUniqueByProperty(
				TDriveruser.class, "driverpassword", driver);
		System.out.println(driver);

		/*
		 * tillegal = driverService.getEntity(TIllegal.class, tillegal.getId());
		 */
		request.setAttribute("tillegal", tillegal);

		request.setAttribute("id", tdriver.getId());

		System.out.println(tdriver.getId() + "sdfgsfdgsfdgsfdg");

		return new ModelAndView("driver/addillegal");
	}

	/*
	 * @RequestMapping(params = "saveillegal")
	 * 
	 * @ResponseBody public AjaxJson save( HttpServletRequest req,TIllegal
	 * tillegal) {
	 * 
	 * AjaxJson j = new AjaxJson();
	 * 
	 * String carid=req.getParameter("carid"); TDriveruser
	 * carmess=driverService.getEntity(TDriveruser.class,carid);
	 * tillegal.setTDriveruser(carmess); this.driverService.save(tillegal); //
	 * System.out.println(tillegal.getImage()); j.setMsg("成功");
	 * 
	 * return j; }
	 */

	@RequestMapping(params = "qqsaveillegal", method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request,
			HttpServletResponse response, TIllegal tillegal, ModelMap model)
			throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		// ** 构建文件保存的目录* *//*
		String logoPathDir = "/userfiles/images/"
				+ dateformat.format(new Date());
		// ** 得到文件保存目录的真实路径* *//*
		String logoRealPathDir = request.getSession().getServletContext()
				.getRealPath(logoPathDir);
		// ** 根据真实路径创建目录* *//*
		File logoSaveFile = new File(logoRealPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();
		// ** 页面控件的文件流* *//*
		MultipartFile multipartFile = multipartRequest.getFile("image1");
		// ** 获取文件的后缀* *//*
		String suffix = multipartFile.getOriginalFilename().substring(
				multipartFile.getOriginalFilename().lastIndexOf("."));
		// ** 使用UUID生成文件名称* *//*
		String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
		// ** 拼成完整的文件保存路径加文件* *//*
		String fileName = logoRealPathDir + File.separator + logImageName;
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ** 打印出上传到服务器的文件的绝对路径* *//*
		System.out.println("****************" + fileName + "**************");
		String path = "http://218.195.213.187:8080" + request.getContextPath()
				+ "/userfiles/images/" + dateformat.format(new Date()) + "/"
				+ logImageName;
		model.addAttribute("fileUrl", path);
		// request.setAttribute("fileUrl",
		// request.getContextPath()+"/userfiles/images/"+logImageName);
		String carid = request.getParameter("carid");
		TDriveruser carmess = driverService.getEntity(TDriveruser.class, carid);
		tillegal.setTDriveruser(carmess);
		tillegal.setImage(path);
		System.out.println("+++++++++++++++++" + path);
		this.driverService.save(tillegal);
		// j.setMsg("成功");
		return "/driver/result";
	}

}
