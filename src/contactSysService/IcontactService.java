package contactSysService;

import java.util.List;

import contactSysEntity.Contact;

public interface IcontactService {
	public void add(Contact con);
	public void delete(Contact con);
	public void update(Contact con);
	public Contact query(String name);
	public List<Contact> queryAll();
}
