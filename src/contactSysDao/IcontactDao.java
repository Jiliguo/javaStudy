package contactSysDao;

import java.util.List;

import contactSysEntity.Contact;

public interface IcontactDao {
	public List<Contact> queryAll();
	public Contact query(String name);
	public void add(Contact contact);
	public void delete(Contact contact);
	public void update(Contact contact);
	
}
