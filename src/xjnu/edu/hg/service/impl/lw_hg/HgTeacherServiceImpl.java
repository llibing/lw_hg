package xjnu.edu.hg.service.impl.lw_hg;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xjnu.edu.hg.service.lw_hg.HgTeacherServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("hgTeacherService")
@Transactional
public class HgTeacherServiceImpl extends CommonServiceImpl implements HgTeacherServiceI {
	
}