package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import admin.model.SyslogDAO;
import admin.model.SyslogDAOBean;

public class SyslogDAOjdbc implements SyslogDAO {
	private DataSource datasource;

	public SyslogDAOjdbc() {

	}

	public SyslogDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}

	private static final String SELECT_BY_USERID = "SELECT *  FROM HG_SysLog where LOG_USERID=? ";
	private static final String SELECTALL = "SELECT *  FROM HG_SysLog";

	/* (non-Javadoc)
	 * @see admin.model.dao.SyslogDAO#select()
	 */
	@Override
	public List<SyslogDAOBean> select() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<SyslogDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECTALL);
			rs = pst.executeQuery();
			result = new ArrayList<SyslogDAOBean>();
			while (rs.next()) {
				SyslogDAOBean bean = new SyslogDAOBean();
				bean.setLOG_NO(rs.getString("LOG_NO"));
				bean.setLOG_TYPE(rs.getString("LOG_TYPE"));
				bean.setLOG_DESC(rs.getString("LOG_DESC"));
				bean.setLOG_USERID(rs.getString("LOG_USERID"));
			    bean.setLOG_UPDATETIME(rs.getDate("LOG_UPDATETIME"));
				bean.setLOG_UPDATEUSER(rs.getString("LOG_UPDATEUSER"));
				result.add(bean);
			}
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
	
	/* (non-Javadoc)
	 * @see admin.model.dao.SyslogDAO#select(admin.model.SyslogDAOBean)
	 */
	@Override
	public List<SyslogDAOBean> select(SyslogDAOBean orgbean) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<SyslogDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECTALL);
			pst.setString(1, orgbean.getLOG_USERID());
			rs = pst.executeQuery();
			result = new ArrayList<SyslogDAOBean>();
			while (rs.next()) {
				SyslogDAOBean bean = new SyslogDAOBean();
				bean.setLOG_NO(rs.getString("LOG_NO"));
				bean.setLOG_TYPE(rs.getString("LOG_TYPE"));
				bean.setLOG_DESC(rs.getString("LOG_DESC"));
				bean.setLOG_USERID(rs.getString("LOG_USERID"));
				bean.setLOG_UPDATETIME(rs.getDate("LOG_UPDATETIME"));
				bean.setLOG_UPDATEUSER(rs.getString("LOG_UPDATEUSER"));
				result.add(bean);
			}
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
	
	private static final String INSERT = "INSERT INTO HG_SysLog (LOG_NO,LOG_USERID,LOG_TYPE,LOG_DESC,LOG_UPDATETIME,LOG_UPDATEUSER) VALUES (?,?,?,?,getdate(),?)";

	
	/* (non-Javadoc)
	 * @see admin.model.dao.SyslogDAO#insert(admin.model.SyslogDAOBean)
	 */
	@Override
	public SyslogDAOBean insert(SyslogDAOBean bean) {
		SyslogDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(INSERT);
			// DAP_GROUP,DAP_ID,DAP_VALUE,DAP_DESC,DAP_UPDATEUSER
			if (bean != null) {
				pst.setString(1, bean.getLOG_NO());
				pst.setString(2, bean.getLOG_USERID());
				pst.setString(3, bean.getLOG_TYPE());
				pst.setString(4, bean.getLOG_DESC());
				pst.setString(5, bean.getLOG_UPDATEUSER());				
				
				int i = pst.executeUpdate();
				if (i == 1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
