package contactSysService.impl;

import contactSysDao.IadminDao;
import contactSysDao.impl.AdminDao;
import contactSysEntity.Admin;
import contactSysService.IadminService;

public class AdminServlet implements IadminService{

	@Override
	public boolean login(Admin admin) {
		// TODO Auto-generated method stub
		IadminDao adDao=new AdminDao();
		if(adDao.query(admin)!=null){
			return true;
		}else{
			return false;
		}
	}

}
