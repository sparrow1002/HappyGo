package cardPoint.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cardPoint.model.CardPointBean;
import cardPoint.model.CardPointDAO;

public class CardPointDAO_JDBC implements CardPointDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "P@ssw0rd";
	
	public static void main(String[] args) {
		CardPointDAO_JDBC dao = new CardPointDAO_JDBC();
		
		String memberId = "mb01";
		String dDate = "20161113";
		String status = "1";
		
		CardPointBean bean =new CardPointBean();
		bean.setTranId(201604110005L);
		bean.setdDate("20161204");
		bean.setPointAdd(10);
		//bean.setPointDre(0);
		bean.setTranDate("20160404");
		bean.setMemberId("jdbc01");
		bean.setStatus("1");
		bean.setUseTranId(0);
		bean.setUpdateUser("tra01");
		
		for(CardPointBean testbean : dao.selectPoint(memberId, dDate, status))
			System.out.println(testbean);
		System.out.println(dao.selectLastPoint(memberId, dDate, status));
		System.out.println(dao.selectByTran(201604110001L));	
		/*if(dao.insert(bean)){
			System.out.println("insert ok");
		}else{
			System.out.println("insert error");
		};*/
		/*if(dao.update("1",bean)){
			System.out.println("update ok");
		}else{
			System.out.println("update error");
		};*/
		
	}
	
	
	private static final String SELECTPIONT = "select * from HG_CardPoint where CPT_MEMBERID = ? "
			+ "and CPT_DDATE>= ? "
			+ "and CPT_STATUS = ? "
			+ "order by CPT_DDATE asc";
	public List<CardPointBean> selectPoint(String memberId, String dDate, String status) {
		List<CardPointBean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECTPIONT);
			pstmt.setString(1, memberId);
			pstmt.setString(2, dDate);
			pstmt.setString(3, status);
			rset = pstmt.executeQuery();
			
			result = new ArrayList<CardPointBean>();
			while(rset.next()){
				CardPointBean bean = new CardPointBean();
				bean.setTranId(rset.getLong("CPT_TRANID"));
				bean.setdDate(rset.getString("CPT_DDATE"));
				bean.setPointAdd(rset.getInt("CPT_POINTADD"));
				bean.setPointDre(rset.getInt("CPT_POINTDRE"));
				bean.setTranDate(rset.getString("CPT_TRANDATE"));
				bean.setMemberId(rset.getString("CPT_MEMBERID"));
				bean.setStatus(rset.getString("CPT_STATUS"));
				bean.setUseTranId(rset.getLong("CPT_USETRANID"));
				bean.setUpdateTime(rset.getTimestamp("CPT_UPDATETIME"));
				bean.setUpdateUser(rset.getString("CPT_UPDATEUSER"));
				result.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return result;
	}
	
	private static final String SELECTLASTPOINT = "select TOP 1 * from HG_CardPoint where CPT_MEMBERID = ? "
			+ "and CPT_DDATE>= ? "
			+ "and CPT_STATUS = ? "
			+ "order by CPT_DDATE asc";
	public CardPointBean selectLastPoint(String memberId, String dDate,	String status) {
		CardPointBean result = null;
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rset;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECTLASTPOINT);
			pstmt.setString(1, memberId);
			pstmt.setString(2, dDate);
			pstmt.setString(3, status);
			rset = pstmt.executeQuery();
			if(rset.next()){
				CardPointBean bean = new CardPointBean();
				bean.setTranId(rset.getLong("CPT_TRANID"));
				bean.setdDate(rset.getString("CPT_DDATE"));
				bean.setPointAdd(rset.getInt("CPT_POINTADD"));
				bean.setPointDre(rset.getInt("CPT_POINTDRE"));
				bean.setTranDate(rset.getString("CPT_TRANDATE"));
				bean.setMemberId(rset.getString("CPT_MEMBERID"));
				bean.setStatus(rset.getString("CPT_STATUS"));
				bean.setUseTranId(rset.getLong("CPT_USETRANID"));
				bean.setUpdateTime(rset.getTimestamp("CPT_UPDATETIME"));
				bean.setUpdateUser(rset.getString("CPT_UPDATEUSER"));
				result = bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String SELECTBYTRAN = "select * from HG_CardPoint where CPT_TRANID = ?";
	public CardPointBean selectByTran(long tranId) {
		CardPointBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null ;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECTBYTRAN);
			pstmt.setLong(1, tranId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				CardPointBean bean = new CardPointBean();
				bean.setTranId(rset.getLong("CPT_TRANID"));
				bean.setdDate(rset.getString("CPT_DDATE"));
				bean.setPointAdd(rset.getInt("CPT_POINTADD"));
				bean.setPointDre(rset.getInt("CPT_POINTDRE"));
				bean.setTranDate(rset.getString("CPT_TRANDATE"));
				bean.setMemberId(rset.getString("CPT_MEMBERID"));
				bean.setStatus(rset.getString("CPT_STATUS"));
				bean.setUseTranId(rset.getLong("CPT_USETRANID"));
				bean.setUpdateTime(rset.getTimestamp("CPT_UPDATETIME"));
				bean.setUpdateUser(rset.getString("CPT_UPDATEUSER"));
				result = bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String UPDATE = "update HG_CardPoint set "
			+ "CPT_DDATE = ?,"
			+ "CPT_POINTADD = ?,"
			+ "CPT_POINTDRE = ?,"
			+ "CPT_TRANDATE = ?,"
			+ "CPT_MEMBERID = ?,"
			+ "CPT_STATUS = ?,"
			+ "CPT_USETRANID = ?,"
			+ "CPT_UPDATETIME = getdate(),"
			+ "CPT_UPDATEUSER = ?"
			+ " where CPT_TRANID = ?"
			+ " and CPT_STATUS = ?";
	public boolean update(String status , CardPointBean bean) {
		Connection conn =null;
		PreparedStatement pstmt;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, bean.getdDate());
			pstmt.setInt(2, bean.getPointAdd());
			pstmt.setInt(3, bean.getPointDre());
			pstmt.setString(4, bean.getTranDate());
			pstmt.setString(5, bean.getMemberId());
			pstmt.setString(6, bean.getStatus());
			pstmt.setLong(7, bean.getUseTranId());
			pstmt.setString(8, bean.getUpdateUser());
			pstmt.setLong(9,bean.getTranId());
			pstmt.setString(10, status);
			int i = pstmt.executeUpdate();
			System.out.println("CardPointDAO_JDBC update i= "+i);
			if(i>=1){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

	private static final String INSERT = "insert into HG_CardPoint values (?,?,?,?,?,?,?,?,getdate(),?)";
	public boolean insert(CardPointBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setLong(1,bean.getTranId());
			pstmt.setString(2, bean.getdDate());
			pstmt.setInt(3, bean.getPointAdd());
			pstmt.setInt(4, bean.getPointDre());
			pstmt.setString(5, bean.getTranDate());
			pstmt.setString(6, bean.getMemberId());
			pstmt.setString(7, bean.getStatus());
			pstmt.setLong(8, bean.getUseTranId());
			pstmt.setString(9, bean.getUpdateUser());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	

}
