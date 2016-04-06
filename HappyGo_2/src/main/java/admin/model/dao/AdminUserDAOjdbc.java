package admin.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import admin.model.AdminUserDAO;
import admin.model.AdminUserDAObean;

public class AdminUserDAOjdbc implements AdminUserDAO {
	// private static final String URL =
	// "jdbc:sqlserver://localhost:1433;database=happygo";
	// private static final String USERNAME = "sa";
	// private static final String PASSWORD = "sa123456";
	private DataSource datasource;

	public static void main(String[] args) {
		AdminUserDAO dao = new AdminUserDAOjdbc();
		AdminUserDAObean bean = dao.select("A000000001");
		System.out.println(bean);
	}

	public AdminUserDAOjdbc() {

	}

	public AdminUserDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}

	private static final String SELECT_BY_USERID = "select * from HG_AdminUser where ADM_ID=?";
	private static final String SELECTALL = "select * from HG_AdminUser";

	@Override
	public AdminUserDAObean select(String userid) {
		AdminUserDAObean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_USERID);
			pst.setString(1, userid);
			rs = pst.executeQuery();
			System.out.println("AdminUserDAObean select process:"
					+ SELECT_BY_USERID);
			if (rs.next()) {
				result = new AdminUserDAObean();
				result.setADM_ID(rs.getString("ADM_ID"));
				result.setADM_PWD(rs.getString("ADM_PWD"));
				result.setADM_NAME(rs.getString("ADM_NAME"));
				result.setADM_ROLEID(rs.getString("ADM_ROLEID"));
				result.setADM_UPDATETIME(rs.getDate("ADM_UPDATETIME"));
				result.setADM_UPDATEUSER(rs.getString("ADM_UPDATEUSER"));//

				System.out.println(rs.getString("ADM_ID")
						+ rs.getString("ADM_PWD"));
			} else
				System.out.println("AdminUserDAObean select process errror:"
						+ userid);
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

	@Override
	public List<AdminUserDAObean> select() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<AdminUserDAObean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECTALL);
			rs = pst.executeQuery();
			result = new ArrayList<AdminUserDAObean>();
			while (rs.next()) {
				AdminUserDAObean bean = new AdminUserDAObean();
				bean.setADM_ID(rs.getString("ADM_ID"));
				bean.setADM_PWD(rs.getString("ADM_PWD"));
				bean.setADM_NAME(rs.getString("ADM_NAME"));
				bean.setADM_ROLEID(rs.getString("ADM_ROLEID"));
				bean.setADM_UPDATETIME(rs.getDate("ADM_UPDATETIME"));
				bean.setADM_UPDATEUSER(rs.getString("ADM_UPDATEUSER"));//
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

	private static final String UPDATE = "UPDATE HG_AdminUser  SET ADM_PWD = ? ,ADM_NAME = ?,ADM_ROLEID = ?,ADM_UPDATETIME =getdate(),ADM_UPDATEUSER =? WHERE ADM_ID = ?";

	@Override
	public AdminUserDAObean update(AdminUserDAObean bean) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(UPDATE);

			pst.setString(1, bean.getADM_PWD());
			pst.setString(2, bean.getADM_NAME());
			pst.setString(3, bean.getADM_ROLEID());
			pst.setString(4, bean.getADM_UPDATEUSER());
			pst.setString(5, bean.getADM_ID());

			int i = pst.executeUpdate();
			if (i == 1) {
				return bean;
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
		return null;
	}

	private static final String INSERT = "INSERT INTO HG_AdminUser (ADM_ID,ADM_PWD,ADM_NAME,ADM_ROLEID,ADM_UPDATETIME,ADM_UPDATEUSER)  VALUES  (?,?,?,?,?,getdate(),?)";

	@Override
	public AdminUserDAObean insert(AdminUserDAObean bean) {
		AdminUserDAObean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(INSERT);
			// ADM_ID,ADM_PWD,ADM_NAME,ADM_ROLEID,ADM_UPDATETIME,ADM_UPDATEUSER
			if (bean != null) {
				pst.setString(1, bean.getADM_ID());
				pst.setString(2, bean.getADM_PWD());
				pst.setString(3, bean.getADM_NAME());
				pst.setString(4, bean.getADM_ROLEID());
				pst.setString(5, bean.getADM_UPDATEUSER());
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
