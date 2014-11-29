package li.bing.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import li.bing.entity.MYAward;
import li.bing.entity.Studentlesson;
import li.bing.entity.Tuser;
import li.bing.service.MYAwardService;
import li.bing.service.MYstudentService;
@Controller
@RequestMapping("/mystudentController")
public class MYstudentController {
	private String message = null;
    private MYstudentService mystudentService;
    private MYAwardService myawardService;
    
    
	public MYAwardService getMyawardService() {
		return myawardService;
	}
	@Autowired
	public void setMyawardService(MYAwardService myawardService) {
		this.myawardService = myawardService;
	}
	
	
	
	public MYstudentService getMystudentService() {
		return mystudentService;
	}
@Autowired
	public void setMystudentService(MYstudentService mystudentService) {
		this.mystudentService = mystudentService;
	}
 @RequestMapping(params="delete")
public AjaxJson delete(Tuser user,HttpServletRequest request, HttpServletResponse response) {
	 AjaxJson j = new AjaxJson();
	 user=this.myawardService.getEntity(Tuser.class, user.getId());
	 List<MYAward> myAward = myawardService.findByProperty(MYAward.class, "Tuser.id", user.getId());	
			if (myAward.size()>0) {
				// 删除用户时先删除用户和角色关系表
				delUserAward(user);
				mystudentService.delete(user);
				message = "用户：" + user.getMYAwards()+ "删除成功";
				
			} else {
				mystudentService.delete(user);
				message = "用户：" + user.getMYAwards() + "删除成功";
			}
		

		j.setMsg(message);
		return j;
	}
//	 Set award=user.getMYAwards();
//	 Iterator it=award.iterator();
//	 while(it.hasNext()){
//		 this.mystudentService.delete(it.next());
//	 }
//	 this.mystudentService.delete(user);
// }
 public void delUserAward(Tuser user) {
		// 同步删除用户角色关联表
		List<MYAward> myAwardList = myawardService.findByProperty(MYAward.class, "Tuser.id", user.getId());
		if (myAwardList.size() >= 1) {
			for (MYAward tmyAward : myAwardList) {
			}
		}
	}
}
