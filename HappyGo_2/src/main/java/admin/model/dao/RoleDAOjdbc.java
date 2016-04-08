package admin.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import admin.model.RoleDAO;
import admin.model.RoleDAOBean;

public class RoleDAOjdbc implements RoleDAO {
	private DataSource datasource;

	// private static final String URL =
	// "jdbc:sqlserver://localhost:1433;database=happygo";
	// private static final String USERNAME = "sa";
	// private static final String PASSWORD = "sa123456";

	public RoleDAOjdbc() {

	}

	public static void main(String[] args) {
		RoleDAO dao = new RoleDAOjdbc();
		List<RoleDAOBean> ss = dao.select();
		System.out.println(ss);
	}

	public RoleDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}

	private static final String SELECT_BY_ROLEID = "SELECT *  FROM HG_Role where ROL_ROLEID=? ";
	private static final String SELECTALL = "SELECT *  FROM HG_Role";

	/*
	 * (non-Javadoc)
	 * 
	 * @see admin.model.RoleDAO#select(java.lang.String)
	 */
	@Override
	public List<RoleDAOBean> select(String roleid) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<RoleDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_ROLEID);
			pst.setString(1, roleid);
			rs = pst.executeQuery();
			result = new ArrayList<RoleDAOBean>();
			while (rs.next()) {
				RoleDAOBean bean = new RoleDAOBean();
				bean.setROL_ROLEID(rs.getString("ROL_ROLEID"));
				bean.setROL_RIGHTID(rs.getString("ROL_RIGHTID"));
				bean.setROL_UPDATETIME(rs.getDate("ROL_UPDATETIME"));
				bean.setROL_UPDATEUSER(rs.getString("ROL_UPDATEUSER"));

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see admin.model.RoleDAO#select()
	 */
	@Override
	public List<RoleDAOBean> select() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<RoleDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECTALL);
			rs = pst.executeQuery();
			result = new ArrayList<RoleDAOBean>();
			while (rs.next()) {
				RoleDAOBean bean = new RoleDAOBean();
				bean.setROL_ROLEID(rs.getString("ROL_ROLEID"));
				bean.setROL_RIGHTID(rs.getString("ROL_RIGHTID"));
				bean.setROL_UPDATETIME(rs.getDate("ROL_UPDATETIME"));
				bean.setROL_UPDATEUSER(rs.getString("ROL_UPDATEUSER"));

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

	private static final String DELETE = "delete HG_Role  WHERE ROL_ROLEID = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see admin.model.RoleDAO#delete(admin.model.RoleDAOBean)
	 */
	@Override
	public boolean delete(RoleDAOBean bean) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean result = false;
		try {
			conn = datasource.getConnection();
			pst = conn.prepareStatement(DELETE);
			pst.setString(1, bean.getROL_ROLEID());
			System.out.println(DELETE);
			System.out.println(bean.getROL_ROLEID());
			int i = pst.executeUpdate();
			if (i >1) {
				result = true;
			}
			System.out.println("delete ok:"+i);
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

	private static final String INSERT = "INSERT INTO HG_Role (ROL_ROLEID,ROL_RIGHTID,ROL_UPDATETIME,ROL_UPDATEUSER)  VALUES (?,?,getdate(),?)";

	/*
	 * (non-Javadoc)
	 * 
	 * @see admin.model.RoleDAO#insert(java.util.List)
	 */
	@Override
	public boolean insert(List<RoleDAOBean> beans) {
		// DataProfileDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		boolean result = true;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(INSERT);
			// DAP_GROUP,DAP_ID,DAP_VALUE,DAP_DESC,DAP_UPDATEUSER
			if (beans != null) {
				for (RoleDAOBean bean : beans) {
					pst.setString(1, bean.getROL_ROLEID());
					pst.setString(2, bean.getROL_RIGHTID());
					pst.setString(3, bean.getROL_UPDATEUSER());
					int i = pst.executeUpdate();
					if (i != 1) {
						result = false;
					}
				}
			}
			if (!result)
				conn.rollback();
			else
				conn.commit();

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
