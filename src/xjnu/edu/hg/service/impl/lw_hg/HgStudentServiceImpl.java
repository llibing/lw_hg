package xjnu.edu.hg.service.impl.lw_hg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xjnu.edu.hg.service.lw_hg.HgStudentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("hgStudentService")
@Transactional
public class HgStudentServiceImpl extends CommonServiceImpl implements HgStudentServiceI {
	
}