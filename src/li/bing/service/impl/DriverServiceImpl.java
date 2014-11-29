package li.bing.service.impl;




import org.jeecgframework.core.common.service.impl.CommonServiceImpl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import li.bing.entity.TDriveruser;
import li.bing.entity.TIllegal;

import li.bing.service.DriverService;
@Service("driverService")
@Transactional
public class DriverServiceImpl extends CommonServiceImpl implements DriverService {

	@Override
	public void saveTdriver(TDriveruser tdriveruser) {
		// TODO Auto-generated method stub
		this.save(tdriveruser);
		for (TIllegal s :tdriveruser.getTIllegals()){
			s.setTDriveruser(tdriveruser);
		    this.save(s);
		}
//		this.batchSave(tdriveruser.getTIllegals());
		
		
			
		
	}




	@Override
	public void updateTIllegal(TDriveruser tdriveruser) {
		// TODO Auto-generated method stub
		for (TIllegal s :tdriveruser.getTIllegals()){
			s.setTDriveruser(tdriveruser);
			this.saveOrUpdate(s);
		}
//		this.batchSave(tdriveruser.getTIllegals());
	}

	






	

}
