package admin.model.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import admin.model.DBBackupDAO;

public class DBBackupDAOjdbc implements DBBackupDAO {
	private DataSource datasource;
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";

	public static void main(String[] args) {
		DBBackupDAO dao = new DBBackupDAOjdbc();
		boolean bean;

		bean = dao.execBackup();
		System.out.println("exec:" + bean);
	}

	public DBBackupDAOjdbc() {

	}

	public DBBackupDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}

	// private String backupcommand =
	// "BACKUP DATABASE happygo TO DISK = '%s' WITH FORMAT, MEDIANAME = 'Z_SQLServerBackups', NAME = 'Full Backup of happygo'";

	/*
	 * (non-Javadoc)
	 * 
	 * @see admin.model.dao.DBBackupDAO#execBackup()
	 */
	@Override
	public boolean execBackup() {
		System.out.println("DBBackupDAOjdbc execBackup");
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		// List<SyslogDAOBean> result = null;
		try {

			String backupcommand = "BACKUP DATABASE happygo TO DISK = '%s' WITH FORMAT, MEDIANAME = 'Z_SQLServerBackups', NAME = 'Full Backup of happygo'";
			String sFIleName = "c:\\dbbackup\\db%s.bak";
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmSS");
			Date date = new Date();
			sFIleName = String.format(sFIleName, dateFormat.format(date)
					.toString());

			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();			
			File newFile = new File(sFIleName);
			newFile.getName();

			forceMkdir(newFile, true);
			backupcommand = String.format(backupcommand, newFile);
			pst = conn.prepareStatement(backupcommand);
			pst.execute();
			result = true;
			System.out.println("result:" + result);

		} catch (IOException e) {
			result = false;
			e.printStackTrace();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	public static void forceMkdir(File directory, boolean isFile)
			throws IOException {
		File directoryTemp = directory;

		if (directoryTemp.exists()) {
			if (directoryTemp.isFile()) {
				String message = "File " + directory + " exists and is "
						+ "not a directory. Unable to create directory.";
				throw new IOException(message);
			}
		} else {
			if (isFile) {
				directoryTemp = new File(directory.getParent());
				directoryTemp.mkdirs();
				FileOutputStream file = new FileOutputStream(directory);
				file.write("aaa".getBytes());
				file.close();
			} else {
				directoryTemp.mkdirs();
			}
		}
	}
}
