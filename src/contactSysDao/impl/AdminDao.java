package contactSysDao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import contactSysDao.IadminDao;
import contactSysEntity.Admin;
import contactSysUtil.JdbcUtil;

public class AdminDao implements IadminDao {
	
	private Admin ad=null;
	private QueryRunner qr=null;
	@Override
	public Admin query(Admin admin) {
		// TODO Auto-generated method stub
		try {
			String sql="select * from admin where name=? and password=?";
			String name=admin.getAdminName();
			String password=admin.getAdminPwd();
			
			qr=JdbcUtil.getQueryRunner();
			ad=qr.query(sql, new BeanHandler<Admin>(Admin.class),name,password );
			return ad;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
