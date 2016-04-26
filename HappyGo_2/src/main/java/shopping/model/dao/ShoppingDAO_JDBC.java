package shopping.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import report.model.reportDAOBean;
import shopping.model.ShoppingBean;
import shopping.model.ShoppingDAO;

public class ShoppingDAO_JDBC implements ShoppingDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "P@ssw0rd";
	
	private DataSource dataSource;
	public ShoppingDAO_JDBC() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/websource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ShoppingDAO_JDBC dao = new ShoppingDAO_JDBC();
		String tranId = "123456789012345678";
		String memberId = "mb01";
		String storeId = "cos123"; 
		int projId = 123;
		String begin = "20150502";
		String end = "20160410";
		String statusTaraned = "1";
		String statusCancelTran = "0";
					
		//System.out.println(dao.selectByTran(tranId));
		/*for(ShoppingBean bean1:dao.selectByMember(memberId))
			System.out.println(bean1);*/
		for(ShoppingBean bean1:dao.selectByDate(begin, end))
			System.out.println(bean1);
		
		ShoppingBean bean = new ShoppingBean();
		bean.setTranId(tranId);
		bean.setTranAmt(553);
		bean.setDisCount(10);
		bean.setMemberId(memberId);
		bean.setStatus(statusTaraned);
		bean.setProjId(projId);
		bean.setStoreId(storeId);
		bean.setOverPoint(103);
		bean.setTranDate("20160410");
		bean.setUpdateUser("tran01");
		/*if(dao.update(statusCancelTran, bean)){
			System.out.println("update ok");
		}else
			System.out.println("update error");*/
		/*if(dao.insert(bean))
			System.out.println("insert ok");
		else
			System.out.println("insert error");*/
	}
	
	private static final String SELECT_BY_USERID = "select * from HG_CardPoint"
			+ " join HG_Shopping on HG_CardPoint.CPT_TRANID = HG_Shopping.SOP_TRANID"
			+ " join HG_ContractStore on HG_Shopping.SOP_STOREID = HG_ContractStore.COS_STOREID"
			+ " where SOP_MEMBERID=? AND CPT_TRANDATE>=? AND CPT_TRANDATE<=?";
	private static final String SELECT_BY_store = "select * from HG_CardPoint"
			+ " join HG_Shopping on HG_CardPoint.CPT_TRANID = HG_Shopping.SOP_TRANID"
			+ " join HG_ContractStore on HG_Shopping.SOP_STOREID = HG_ContractStore.COS_STOREID"
			+ " where SOP_STOREID=? AND CPT_TRANDATE>=? AND CPT_TRANDATE<=?";
	private static final String SELECT_BY_USERID_IDandstore = "select * from HG_CardPoint"
			+ " join HG_Shopping on HG_CardPoint.CPT_TRANID = HG_Shopping.SOP_TRANID"
			+ " join HG_ContractStore on HG_Shopping.SOP_STOREID = HG_ContractStore.COS_STOREID"
			+ " where SOP_MEMBERID=? AND CPT_TRANDATE>=? AND CPT_TRANDATE<=? AND SOP_STOREID=?";
	public List<reportDAOBean> select_bean(String id, String day1, String day2, String store) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		reportDAOBean bean = null;
		List<reportDAOBean> result = null;
		try {
			conn = dataSource.getConnection();
			if (store == null) {
				pst = conn.prepareStatement(SELECT_BY_USERID);
				pst.setString(1, id);
				pst.setString(2, day1);
				pst.setString(3, day2);
			} else if (id == null) {
				pst = conn.prepareStatement(SELECT_BY_store);
				pst.setString(1, store);
				pst.setString(2, day1);
				pst.setString(3, day2);
			} else {
				pst = conn.prepareStatement(SELECT_BY_USERID_IDandstore);
				pst.setString(1, id);
				pst.setString(2, day1);
				pst.setString(3, day2);
				pst.setString(4, store);
			}
			rs = pst.executeQuery();
			System.out.println("AdminUserDAObean select process:" + SELECT_BY_USERID);
			result = new ArrayList<reportDAOBean>();
			while (rs.next()) {
				bean = new reportDAOBean();
				bean.setSOP_MEMBERID(rs.getString("SOP_MEMBERID"));
				bean.setCOS_NAME(rs.getString("COS_NAME"));
				bean.setCPT_TRANDATE(rs.getString("CPT_TRANDATE"));
				//bean.setTranDate(rset.getString("SOP_tranDate"));
				bean.setSOP_TRANAMT(rs.getBigDecimal("SOP_TRANAMT"));
				bean.setSOP_DISCOUNT(rs.getBigDecimal("SOP_DISCOUNT"));
				bean.setCPT_POINTADD(rs.getBigDecimal("CPT_POINTADD"));
				bean.setCPT_POINTDRE(rs.getBigDecimal("CPT_POINTDRE"));
				//bean.setSOP_overPoint(rs.getInt("SOP_overPoint"));
				bean.setSOP_TRANID(rs.getString("SOP_TRANID"));
				bean.setSOP_STATUS(rs.getString("SOP_STATUS"));
				
								
				if (rs.getString("SOP_STATUS").equals("0")) {
					if (rs.getString("CPT_STATUS").equals("0")) {
						bean.setTransation("交易取消");
					} else if (rs.getString("CPT_STATUS").equals("1")) {
						bean.setTransation("退還點數");
					}
				} else if (rs.getString("SOP_STATUS").equals("1")) {
					bean.setTransation("交易完成");
				}
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
	
	private static final String SELECTBYTRAN = "select * from HG_Shopping where SOP_TRANID= ?";
	public ShoppingBean selectByTran(long tranId) {
		ShoppingBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECTBYTRAN);
			pstmt.setLong(1, tranId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				ShoppingBean bean = new ShoppingBean();
				bean.setTranId(rset.getString("SOP_TRANID"));
				bean.setTranAmt(rset.getInt("SOP_TRANAMT"));
				bean.setDisCount(rset.getInt("SOP_DISCOUNT"));
				bean.setMemberId(rset.getString("SOP_MEMBERID"));
				bean.setStatus(rset.getString("SOP_STATUS"));
				bean.setProjId(rset.getInt("SOP_PROJID"));
				bean.setStoreId(rset.getString("SOP_STOREID"));
				bean.setOverPoint(rset.getInt("SOP_overPoint"));
				bean.setTranDate(rset.getString("SOP_tranDate"));
				bean.setUpdateTime(rset.getTimestamp("SOP_UPDATETIME"));
				bean.setUpdateUser(rset.getString("SOP_UPDATEUSER"));
				result = bean;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECTBYMEMBER = "select * from HG_Shopping where SOP_MEMBERID= ?";
	public List<ShoppingBean> selectByMember(String memberId) {
		List<ShoppingBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECTBYMEMBER);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			result = new ArrayList<ShoppingBean>();
			while(rset.next()){
				ShoppingBean bean = new ShoppingBean();
				bean.setTranId(rset.getString("SOP_TRANID"));
				bean.setTranAmt(rset.getInt("SOP_TRANAMT"));
				bean.setDisCount(rset.getInt("SOP_DISCOUNT"));
				bean.setMemberId(rset.getString("SOP_MEMBERID"));
				bean.setStatus(rset.getString("SOP_STATUS"));
				bean.setProjId(rset.getInt("SOP_PROJID"));
				bean.setStoreId(rset.getString("SOP_STOREID"));
				bean.setOverPoint(rset.getInt("SOP_overPoint"));
				bean.setTranDate(rset.getString("SOP_tranDate"));
				bean.setUpdateTime(rset.getTimestamp("SOP_UPDATETIME"));
				bean.setUpdateUser(rset.getString("SOP_UPDATEUSER"));
				result.add(bean);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String STORE = "select * from HG_Shopping where SOP_STOREID=?";
	public List<ShoppingBean> selectByStore(String storeId) {
		List<ShoppingBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(STORE);
			pstmt.setString(1, storeId);
			rset = pstmt.executeQuery();
			
			result = new ArrayList<ShoppingBean>();
			while(rset.next()){
				ShoppingBean bean = new ShoppingBean();
				bean.setTranId(rset.getString("SOP_TRANID"));
				bean.setTranAmt(rset.getInt("SOP_TRANAMT"));
				bean.setDisCount(rset.getInt("SOP_DISCOUNT"));
				bean.setMemberId(rset.getString("SOP_MEMBERID"));
				bean.setStatus(rset.getString("SOP_STATUS"));
				bean.setProjId(rset.getInt("SOP_PROJID"));
				bean.setStoreId(rset.getString("SOP_STOREID"));
				bean.setOverPoint(rset.getInt("SOP_overPoint"));
				bean.setTranDate(rset.getString("SOP_tranDate"));
				bean.setUpdateTime(rset.getTimestamp("SOP_UPDATETIME"));
				bean.setUpdateUser(rset.getString("SOP_UPDATEUSER"));
				result.add(bean);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String PROJ = "select * from HG_Shopping where SOP_PROJID=?";
	public List<ShoppingBean> selectByProj(int projId) {
		List<ShoppingBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(PROJ);
			pstmt.setInt(1, projId);
			rset = pstmt.executeQuery();
			
			result = new ArrayList<ShoppingBean>();
			while(rset.next()){
				ShoppingBean bean = new ShoppingBean();
				bean.setTranId(rset.getString("SOP_TRANID"));
				bean.setTranAmt(rset.getInt("SOP_TRANAMT"));
				bean.setDisCount(rset.getInt("SOP_DISCOUNT"));
				bean.setMemberId(rset.getString("SOP_MEMBERID"));
				bean.setStatus(rset.getString("SOP_STATUS"));
				bean.setProjId(rset.getInt("SOP_PROJID"));
				bean.setStoreId(rset.getString("SOP_STOREID"));
				bean.setOverPoint(rset.getInt("SOP_overPoint"));
				bean.setTranDate(rset.getString("SOP_tranDate"));
				bean.setUpdateTime(rset.getTimestamp("SOP_UPDATETIME"));
				bean.setUpdateUser(rset.getString("SOP_UPDATEUSER"));
				result.add(bean);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String DATE = "select * from HG_Shopping where SOP_tranDate between ? and ?";
	public List<ShoppingBean> selectByDate(String begin, String end) {
		List<ShoppingBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(DATE);
			pstmt.setString(1, begin);
			pstmt.setString(2, end);
			rset = pstmt.executeQuery();
			
			result = new ArrayList<ShoppingBean>();
			while(rset.next()){
				ShoppingBean bean = new ShoppingBean();
				bean.setTranId(rset.getString("SOP_TRANID"));
				bean.setTranAmt(rset.getInt("SOP_TRANAMT"));
				bean.setDisCount(rset.getInt("SOP_DISCOUNT"));
				bean.setMemberId(rset.getString("SOP_MEMBERID"));
				bean.setStatus(rset.getString("SOP_STATUS"));
				bean.setProjId(rset.getInt("SOP_PROJID"));
				bean.setStoreId(rset.getString("SOP_STOREID"));
				bean.setOverPoint(rset.getInt("SOP_overPoint"));
				bean.setTranDate(rset.getString("SOP_tranDate"));
				bean.setUpdateTime(rset.getTimestamp("SOP_UPDATETIME"));
				bean.setUpdateUser(rset.getString("SOP_UPDATEUSER"));
				result.add(bean);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update HG_Shopping set "
			+ "SOP_STATUS=?,"
			+ "SOP_UPDATETIME=GETDATE(),"
			+ "SOP_UPDATEUSER=? "
			+ "where SOP_TRANID=?";
	public boolean update(String status, ShoppingBean bean) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, status);
			pstmt.setString(2,bean.getUpdateUser());
			pstmt.setString(3, bean.getTranId());
			int i = pstmt.executeUpdate();
			conn.close();
			if(i>0){
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "insert into HG_Shopping values (?,?,?,?,?,?,?,?,?,getdate(),?)";
	public boolean insert(ShoppingBean bean) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bean.getTranId());
			pstmt.setInt(2, bean.getTranAmt());
			pstmt.setInt(3, bean.getDisCount());
			pstmt.setString(4, bean.getMemberId());
			pstmt.setString(5, bean.getStatus());
			pstmt.setInt(6, bean.getProjId());
			pstmt.setString(7, bean.getStoreId());
			pstmt.setInt(8, bean.getOverPoint());
			pstmt.setString(9, bean.getTranDate());
			pstmt.setString(10, bean.getUpdateUser());
			int i = pstmt.executeUpdate();
			conn.close();
			if(i>0){
				result = true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
