package admin.model;

import org.springframework.stereotype.Service;

import admin.model.dao.AdminUserDAOjdbc;
import admin.model.dao.DBBackupDAOjdbc;

@Service(value = "dbBackupDAOservice")
public class DBBackupDAOservice {
	
	public DBBackupDAOservice() {

	}
	private DBBackupDAO dbBackupDAO= null;
	public void setDBBackupDAO(DBBackupDAO dbBackupDAO) {
		this.dbBackupDAO = dbBackupDAO;
	}
	public DBBackupDAOservice(DBBackupDAO dbBackupDAO) {
		this.dbBackupDAO = dbBackupDAO;
	}
	public static void main(String[] args) {
		DBBackupDAO dao = new DBBackupDAOjdbc();
		boolean bean = dao.execBackup();
		System.out.println(bean);
	}	
	
	public boolean execBackup() {
		boolean result=false;
		System.out.println("DBBackupDAOservice execBackup");
		result = dbBackupDAO.execBackup();
		return result;
	}
}
