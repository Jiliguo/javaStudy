package contactSysDao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import contactSysDao.IcontactDao;
import contactSysEntity.Contact;
import contactSysUtil.JdbcUtil;

public class ContactDao implements IcontactDao{
	private static QueryRunner qr=null;
	static{
		qr=JdbcUtil.getQueryRunner();
	}


	@Override
	public void add(Contact contact) {
		// TODO Auto-generated method stub
		String sql="insert into contacts(name,phone) values(?,?) ";
		try {
			qr.update(sql, contact.getName(),contact.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM contacts WHERE NAME=?";
		try {
			qr.update(sql, contact.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub
		String sql="UPDATE contacts SET phone=? WHERE NAME=? ";
		try {
			qr.update(sql, contact.getPhone(),contact.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> queryAll() {
		// TODO Auto-generated method stub
		List<Contact> list=null;
		try {
			String sql="select * from contacts";
			list=qr.query(sql, new BeanListHandler<Contact>(Contact.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}

	@Override
	public Contact query(String name) {
		// TODO Auto-generated method stub
		String sql="select * from contacts where name=?";
		Contact con=null;
		try {
			con=qr.query(sql, new BeanHandler<Contact>(Contact.class),name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
