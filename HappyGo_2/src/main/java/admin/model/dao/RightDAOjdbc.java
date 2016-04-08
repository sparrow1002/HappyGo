package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import admin.model.RightDAO;
import admin.model.RightDAOBean;

public class RightDAOjdbc implements RightDAO {
	private DataSource datasource;
	public RightDAOjdbc() {

	}
	public RightDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}
	private static final String SELECT_BY_RIGHTID = "SELECT *  FROM HG_Right where RIG_RIGHTID=? ";
	private static final String SELECTALL = "SELECT *  FROM HG_Right";
	/* (non-Javadoc)
	 * @see admin.model.dao.RightDAO#select(java.lang.String)
	 */
	@Override
	public List<RightDAOBean> select(RightDAOBean beans) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<RightDAOBean> result = null;
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_RIGHTID);
			pst.setString(1, beans.getRIG_RIGHTID());
			rs = pst.executeQuery();
			result = new ArrayList<RightDAOBean>();
			while (rs.next()) {
				RightDAOBean bean = new RightDAOBean();
				bean.setRIG_RIGHTID(rs.getString("RIG_RIGHTID"));
				bean.setRIG_FUNTION(rs.getString("RIG_FUNTION"));
				bean.setRIG_DESC(rs.getString("RIG_DESC"));
				bean.setRIG_UPDATETIME(rs.getDate("RIG_UPDATETIME"));
				bean.setRIG_UPDATEUSER(rs.getString("RIG_UPDATEUSER"));

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
	
	/* (non-Javadoc)
	 * @see admin.model.dao.RightDAO#select()
	 */
	@Override
	public List<RightDAOBean> select() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<RightDAOBean> result = null;
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECTALL);
			rs = pst.executeQuery();
			result = new ArrayList<RightDAOBean>();
			while (rs.next()) {
				RightDAOBean bean = new RightDAOBean();
				bean.setRIG_RIGHTID(rs.getString("RIG_RIGHTID"));
				bean.setRIG_FUNTION(rs.getString("RIG_FUNTION"));
				bean.setRIG_DESC(rs.getString("RIG_DESC"));
				bean.setRIG_UPDATETIME(rs.getDate("RIG_UPDATETIME"));
				bean.setRIG_UPDATEUSER(rs.getString("RIG_UPDATEUSER"));

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
	private static final String INSERT = "INSERT INTO HG_Right (RIG_RIGHTID,RIG_DESC,RIG_FUNTION,RIG_UPDATETIME,RIG_UPDATEUSER)  VALUES  (?,?,?,getdate(),?)";
	/* (non-Javadoc)
	 * @see admin.model.dao.RightDAO#insert(admin.model.RightDAOBean)
	 */
	@Override
	public RightDAOBean insert(RightDAOBean bean) {
		RightDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(INSERT);
			// DAP_GROUP,DAP_ID,DAP_VALUE,DAP_DESC,DAP_UPDATEUSER
			if (bean != null) {
				pst.setString(1, bean.getRIG_RIGHTID());
				pst.setString(2, bean.getRIG_DESC());
				pst.setString(3, bean.getRIG_FUNTION());
				pst.setString(4, bean.getRIG_UPDATEUSER());
				
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
	
	private static final String DELETE = "delete HG_Right  WHERE RIG_RIGHTID = ?";
	/* (non-Javadoc)
	 * @see admin.model.dao.RightDAO#delete(admin.model.RightDAOBean)
	 */
	@Override
	public RightDAOBean delete(RightDAOBean bean) {
		Connection conn = null;
		PreparedStatement pst = null;
		RightDAOBean result = null;
		try {
			conn = datasource.getConnection();
			pst = conn.prepareStatement(DELETE);
			pst.setString(1, bean.getRIG_RIGHTID());

			int i = pst.executeUpdate();
			if (i < 1) {
				result = bean;
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
	
	private static final String UPDATE = "UPDATE HG_Right SET RIG_DESC =?,RIG_FUNTION = ?,RIG_UPDATETIME = getdate(),RIG_UPDATEUSER = ? WHERE RIG_RIGHTID = ?";
	/* (non-Javadoc)
	 * @see admin.model.dao.RightDAO#update(admin.model.RightDAOBean)
	 */
	@Override
	public RightDAOBean update(RightDAOBean bean) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = datasource.getConnection();
			pst = conn.prepareStatement(UPDATE);
			pst.setString(1, bean.getRIG_DESC());
			pst.setString(2, bean.getRIG_FUNTION());
			pst.setString(3, bean.getRIG_UPDATEUSER());
			pst.setString(4, bean.getRIG_RIGHTID());
			
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
}
