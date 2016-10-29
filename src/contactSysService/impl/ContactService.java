package contactSysService.impl;

import java.util.List;

import contactSysDao.IcontactDao;
import contactSysDao.impl.ContactDao;
import contactSysEntity.Contact;
import contactSysService.IcontactService;

public class ContactService implements IcontactService {

	private IcontactDao condao=new ContactDao();
	@Override
	public void add(Contact con) {
		// TODO Auto-generated method stub
		condao.add(con);
	}

	@Override
	public void delete(Contact con) {
		// TODO Auto-generated method stub
		condao.delete(con);
	}

	@Override
	public void update(Contact con) {
		// TODO Auto-generated method stub
		condao.update(con);
	}

	@Override
	public List<Contact> queryAll() {
		// TODO Auto-generated method stub
		return condao.queryAll();
	}

	@Override
	public Contact query(String name) {
		// TODO Auto-generated method stub
		return condao.query(name);
	}



	

	

}
