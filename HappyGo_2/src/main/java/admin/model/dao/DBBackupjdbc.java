package admin.model.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DBBackupjdbc {
	private DataSource datasource;

	public DBBackupjdbc() {

	}

	public DBBackupjdbc(DataSource datasource) {
		this.datasource = datasource;
	}

	private String backupcommand = "BACKUP DATABASE happygo TO DISK = '%s' WITH FORMAT, MEDIANAME = 'Z_SQLServerBackups', NAME = 'Full Backup of happygo'";

	public boolean execBackup() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		// List<SyslogDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			/**
			 * 新建檔
			 * 
			 * @param filePathAndNameString
			 *            檔路徑及名稱 如c:/fqf.txt
			 * @param fileContent
			 *            String檔內容
			 * @return boolean
			 */

			backupcommand = String.format(backupcommand,
					"c:\\happygo2016dayutest.Bak");
			pst = conn.prepareStatement(backupcommand);
			result = pst.execute();
			// result = new ArrayList<SyslogDAOBean>();

			System.out.println(result);
		} catch (SQLException e) {
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

	/**
	 * 新建檔
	 * 
	 * @param filePathAndNameString
	 *            檔路徑及名稱 如c:/fqf.txt
	 * @param fileContent
	 *            String檔內容
	 * @return boolean
	 */
	public void newFile(String filePathAndName, String fileContent) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();

		} catch (Exception e) {
			System.out.println("新建目錄操作出錯");
			e.printStackTrace();

		}

	}
}
