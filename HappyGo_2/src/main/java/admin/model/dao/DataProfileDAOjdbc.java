package admin.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import admin.model.DataProfileDAO;
import admin.model.DataProfileDAOBean;

public class DataProfileDAOjdbc implements DataProfileDAO {
	// private static final String URL =
	// "jdbc:sqlserver://localhost:1433;database=happygo";
	// private static final String USERNAME = "sa";
	// private static final String PASSWORD = "sa123456";
	private DataSource datasource;

	public DataProfileDAOjdbc() {

	}

	public static void main(String[] args) {
		DataProfileDAO dao = new DataProfileDAOjdbc();
		String ss = dao.selectitem("ROLEID    ", "01");
		System.out.println(ss);
	}

	public DataProfileDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}

	private static final String SELECT_BY_GROUP = "select * from HG_DataProfile where DAP_GROUP=? ";
	private static final String SELECT_BY_GROUP_ID = "select * from HG_DataProfile where DAP_GROUP=? and DAP_ID=?";
	private static final String SELECTALL = "select * from HG_DataProfile";

	/*
	 * (non-Javadoc)
	 * 
	 * @see admin.model.dao.DataProfileDAO#selectitem(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String selectitem(String group, String id) {
		String result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_GROUP_ID);
			pst.setString(1, group);
			pst.setString(2, id);
			rs = pst.executeQuery();
			System.out.println("AdminUserDAObean select process:"
					+ SELECT_BY_GROUP_ID);
			if (rs.next()) {
				result = rs.getString("DAP_VALUE");
				System.out.println(rs.getString("DAP_GROUP")
						+ rs.getString("DAP_ID"));
			} else
				System.out.println("DataProfileDAOBean select process errror:"
						+ group + "," + id);
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
	 * @see admin.model.dao.DataProfileDAO#select(java.lang.String)
	 */
	@Override
	public List<DataProfileDAOBean> select(String group) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<DataProfileDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_GROUP);
			pst.setString(1, group);
			rs = pst.executeQuery();
			result = new ArrayList<DataProfileDAOBean>();
			while (rs.next()) {
				DataProfileDAOBean bean = new DataProfileDAOBean();
				bean.setDAP_GROUP(rs.getString("DAP_GROUP"));
				bean.setDAP_ID(rs.getString("DAP_ID"));
				bean.setDAP_DESC(rs.getString("DAP_DESC"));
				bean.setDAP_VALUE(rs.getString("DAP_VALUE"));
				bean.setDAP_UPDATETIME(rs.getDate("DAP_UPDATETIME"));
				bean.setDAP_UPDATEUSER(rs.getString("DAP_UPDATEUSER"));
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
	 * @see admin.model.dao.DataProfileDAO#selects(java.lang.String)
	 */
	@Override
	public Map<String, String> selects(String group) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Map<String, String> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_GROUP);
			pst.setString(1, group);
			rs = pst.executeQuery();
			result = new TreeMap<String, String>();
			while (rs.next()) {
				result.put(rs.getString("DAP_ID"), rs.getString("DAP_VALUE"));
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
	 * @see admin.model.dao.DataProfileDAO#selectall()
	 */
	@Override
	public List<DataProfileDAOBean> selectall() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<DataProfileDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECTALL);
			rs = pst.executeQuery();
			result = new ArrayList<DataProfileDAOBean>();
			while (rs.next()) {
				DataProfileDAOBean bean = new DataProfileDAOBean();
				bean.setDAP_GROUP(rs.getString("DAP_GROUP"));
				bean.setDAP_ID(rs.getString("DAP_ID"));
				bean.setDAP_DESC(rs.getString("DAP_DESC"));
				bean.setDAP_VALUE(rs.getString("DAP_VALUE"));
				bean.setDAP_UPDATETIME(rs.getDate("DAP_UPDATETIME"));
				bean.setDAP_UPDATEUSER(rs.getString("DAP_UPDATEUSER"));
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

	private static final String UPDATE = "UPDATE HG_DataProfile SET DAP_VALUE =?,DAP_DESC =?,DAP_UPDATETIME =getdate(),DAP_UPDATEUSER =? WHERE DAP_GROUP = ? and DAP_ID =?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * admin.model.dao.DataProfileDAO#update(admin.model.DataProfileDAOBean)
	 */
	@Override
	public DataProfileDAOBean update(DataProfileDAOBean bean) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = datasource.getConnection();
			pst = conn.prepareStatement(UPDATE);
			
			pst.setString(1, bean.getDAP_VALUE());
			pst.setString(2, bean.getDAP_DESC());
			pst.setString(3, bean.getDAP_UPDATEUSER());
			pst.setString(4, bean.getDAP_GROUP());
			pst.setString(5, bean.getDAP_ID());
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

	private static final String INSERT = "INSERT INTO HG_DataProfile (DAP_GROUP,DAP_ID,DAP_VALUE,DAP_DESC,DAP_UPDATETIME,DAP_UPDATEUSER) VALUES (?,?,?,?,getdate(),?)";

	@Override
	public DataProfileDAOBean insert(DataProfileDAOBean bean) {
		DataProfileDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(INSERT);
			// DAP_GROUP,DAP_ID,DAP_VALUE,DAP_DESC,DAP_UPDATEUSER
			if (bean != null) {
				pst.setString(1, bean.getDAP_GROUP());
				pst.setString(2, bean.getDAP_ID());
				pst.setString(3, bean.getDAP_VALUE());
				pst.setString(4, bean.getDAP_DESC());
				pst.setString(5, bean.getDAP_UPDATEUSER());
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

	@Override
	public DataProfileDAOBean selectitems(String group, String id) {
		DataProfileDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_GROUP_ID);
			pst.setString(1, group);
			pst.setString(2, id);
			rs = pst.executeQuery();
			System.out.println("AdminUserDAObean select process:"
					+ SELECT_BY_GROUP_ID);
			if (rs.next()) {

				result = new DataProfileDAOBean();
				result.setDAP_GROUP(rs.getString("DAP_GROUP"));
				result.setDAP_ID(rs.getString("DAP_ID"));
				result.setDAP_DESC(rs.getString("DAP_DESC"));
				result.setDAP_VALUE(rs.getString("DAP_VALUE"));
				result.setDAP_UPDATETIME(rs.getDate("DAP_UPDATETIME"));
				result.setDAP_UPDATEUSER(rs.getString("DAP_UPDATEUSER"));
			} else
				System.out.println("DataProfileDAOBean select process errror:"
						+ group + "," + id);
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
}
