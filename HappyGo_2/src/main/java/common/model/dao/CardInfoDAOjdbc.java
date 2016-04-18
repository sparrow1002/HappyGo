package common.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import common.model.CardInfoDAO;
import common.model.CardInfoDAOBean;
import admin.model.AdminUserDAObean;

public class CardInfoDAOjdbc implements CardInfoDAO {
	private DataSource datasource;

	public CardInfoDAOjdbc() {

	}

	public CardInfoDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}

	private static final String SELECT_BY_CardID = "select * from HG_CardInfo where CDI_CardID=?";
	private static final String SELECTALL = "select * from HG_CardInfo";

	/* (non-Javadoc)
	 * @see common.model.dao.CardInfoDAO#select(common.model.CardInfoDAOBean)
	 */
	@Override
	public CardInfoDAOBean select(CardInfoDAOBean bean) {
		CardInfoDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECT_BY_CardID);
			pst.setString(1, bean.getCDI_CardID());
			rs = pst.executeQuery();

			if (rs.next()) {
				result = new CardInfoDAOBean();
				result.setCDI_CardID(rs.getString("CDI_CardID"));
				result.setCDI_CardInfo(rs.getString("CDI_CardInfo"));
				result.setCDI_CardName(rs.getString("CDI_CardName"));
				result.setCDI_IMG(rs.getBytes("CDI_IMG"));

			} else
				System.out.println("CardInfoDAOBean select process errror:"
						+ bean.getCDI_CardID().toString());
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
	 * @see common.model.dao.CardInfoDAO#select()
	 */
	@Override
	public List<CardInfoDAOBean> select() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		List<CardInfoDAOBean> result = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(SELECTALL);
			rs = pst.executeQuery();
			result = new ArrayList<CardInfoDAOBean>();
			while (rs.next()) {
				CardInfoDAOBean bean = new CardInfoDAOBean();
				bean.setCDI_CardID(rs.getString("CDI_CardID"));
				bean.setCDI_CardInfo(rs.getString("CDI_CardInfo"));
				bean.setCDI_CardName(rs.getString("CDI_CardName"));
				bean.setCDI_IMG(rs.getBytes("CDI_IMG"));
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

	private static final String UPDATE = "UPDATE HG_CardInfo  SET CDI_CardName =?,CDI_CardInfo = ?,CDI_IMG = ? WHERE CDI_CardID = ?";
	private static final String INSERT = "INSERT INTO HG_CardInfo (CDI_CardID,CDI_CardName,CDI_CardInfo,CDI_IMG) VALUES  (?,?,?,?)";

	/* (non-Javadoc)
	 * @see common.model.dao.CardInfoDAO#update(common.model.CardInfoDAOBean)
	 */
	@Override
	public CardInfoDAOBean update(CardInfoDAOBean bean) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(UPDATE);
			pst.setString(1, bean.getCDI_CardName());
			pst.setString(2, bean.getCDI_CardInfo());
			pst.setBytes(3, bean.getCDI_IMG());
			pst.setString(4, bean.getCDI_CardID());
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

	/* (non-Javadoc)
	 * @see common.model.dao.CardInfoDAO#insert(common.model.CardInfoDAOBean)
	 */
	@Override
	public CardInfoDAOBean insert(CardInfoDAOBean bean) {
		CardInfoDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(INSERT);
			// ADM_ID,ADM_PWD,ADM_NAME,ADM_ROLEID,ADM_UPDATETIME,ADM_UPDATEUSER
			if (bean != null) {
				pst.setString(1, bean.getCDI_CardName());
				pst.setString(2, bean.getCDI_CardInfo());
				pst.setBytes(3, bean.getCDI_IMG());
				pst.setString(4, bean.getCDI_CardID());
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

	private static final String DELETE = "delete HG_CardInfo  WHERE CDI_CardID = ?";

	/* (non-Javadoc)
	 * @see common.model.dao.CardInfoDAO#delete(common.model.CardInfoDAOBean)
	 */
	@Override
	public CardInfoDAOBean delete(CardInfoDAOBean bean) {
		CardInfoDAOBean result = null;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = datasource.getConnection();
			pst = conn.prepareStatement(DELETE);
			// ADM_ID,ADM_PWD,ADM_NAME,ADM_ROLEID,ADM_UPDATETIME,ADM_UPDATEUSER
			if (bean != null) {
				pst.setString(1, bean.getCDI_CardID());
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
