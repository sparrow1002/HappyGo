package shoppingCart.model;

//尚未改完，參照王老師的shoppingCart 目前進度為32行sql語法

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ShoppingOrderDAOJDBC {
	private static final long serialVersionUID = 1L;
	DataSource dataSource;
	String MBR_MEMBERID = null;

	public ShoppingOrderDAOJDBC() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oooHya");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = "Insert Into ORD_singleOrder(MBR_MEMBERID,ORD_totalAmount, ORD_shippingAddress, ORD_descriptions, ORD_date)"
												+"values(?, ?, ?, ?, ?) ";
	public void insertOrder(SingleOrderBean singleODB) throws SQLException {
		System.out.println("hello, this is orderInsert test program    " + singleODB.MBR_MEMBERID); //呼叫為idnull
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet generatedKeys = null;
		PreparedStatement pStmt2 = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);  // 開啟JDBC Transaction
			pStmt = conn.prepareStatement(INSERT,
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, singleODB.getMBR_MEMBERID());
			pStmt.setDouble(2, singleODB.getORD_totalAmount());
			pStmt.setString(3, singleODB.getORD_shippingAddress());
			pStmt.setString(4, singleODB.getORD_descriptions());
			Timestamp ts = new Timestamp(singleODB.getORD_date().getTime()); //此行出錯
			System.out.println("this is shoppingDAO line 53 timestamp test" + ts);
			pStmt.setTimestamp(5, ts);
			pStmt.executeUpdate();
			int id = 0;
			generatedKeys = pStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			} else {
				throw new SQLException(
						"Creating user failed, no generated key obtained.");
			}
						
			String sqlItem = "Insert Into ORD_Items(ORD_no,PD_ID, PD_descriptions, ORD_amount, ORD_unitPrice)"
					+"values(?, ?, ?, ?, ?) ";
			List<TotalOrderItem> items = singleODB.getItems();
			pStmt2 = conn.prepareStatement(sqlItem);
			int n=0;
			for (TotalOrderItem totorb : items) {
//              下列四個敘述為交易測試而編寫	
//				n++;
//				if (n > 2) {
//					System.out.println("發生例外 n>2");
//					throw new SQLException("JDBC交易測試用");
//				}
				pStmt2.setInt(1, id);
				pStmt2.setString(2, totorb.getPD_ID());
				pStmt2.setString(3, totorb.getPD_descriptions());
				pStmt2.setDouble(4, totorb.getORD_amount());
				pStmt2.setDouble(5, totorb.getORD_unitPrice());
				int count = pStmt2.executeUpdate();
				pStmt2.clearParameters();
			}
			conn.commit();  
		} catch(SQLException ex){
			System.out.println("資料還原");
			if(conn!=null) conn.rollback();
		} finally {
			
			if (pStmt != null) {
				pStmt.close();
			}
			if (pStmt2 != null) {
				pStmt2.close();
			}
			if(conn!=null)  conn.setAutoCommit(true);
			if (conn != null) {
				conn.close();
			}
		}
	}
	public SingleOrderBean getOrder(String ORD_no) throws SQLException {
		String sqlOrder = "SELECT * FROM ORD_singleOrder WHERE ORD_no = ? ";
		String sqlOrderItems = "SELECT * FROM ORD_Items WHERE ORD_no = ? order by ORD_seqno";
		List<TotalOrderItem> items = new ArrayList<TotalOrderItem>();
		Connection conn = null;
		PreparedStatement pStmt = null;
		PreparedStatement pStmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		SingleOrderBean singleODB = null;
		try {
			conn = dataSource.getConnection();
			pStmt = conn.prepareStatement(sqlOrder);
			pStmt.setString(1, ORD_no);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				singleODB = new SingleOrderBean();
				singleODB.setORD_no(rs.getString(1));
				singleODB.setMBR_MEMBERID(rs.getString(2));
				singleODB.setORD_totalAmount(rs.getDouble(3));
				singleODB.setORD_shippingAddress(rs.getString(4));;
				singleODB.setORD_descriptions(rs.getString(5));
				singleODB.setORD_date(rs.getDate(6));
				singleODB.setORD_shippingdate(rs.getDate(7));
			}
			if (singleODB == null) {
				throw new SQLException("資料庫邏輯錯誤：無此紀錄, 訂單編號=" + ORD_no);
			} else {
				pStmt2 = conn.prepareStatement(sqlOrderItems);
				pStmt2.setString(1, ORD_no);
				rs2 = pStmt2.executeQuery();
				TotalOrderItem totalODI =null;
				while (rs2.next()) {
					totalODI = new TotalOrderItem();
					totalODI.setORD_seqno(rs2.getString(1));
					totalODI.setORD_no(rs2.getString(2));
					totalODI.setPD_ID(rs2.getString(3));
					totalODI.setPD_descriptions(rs2.getString(4));
					totalODI.setORD_amount(rs2.getInt(5));
					totalODI.setORD_unitPrice(rs2.getDouble(6));
					items.add(totalODI);
				}
			}
			singleODB.setItems(items);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (rs2 != null) {
				rs2.close();
			}
			if (pStmt != null) {
				pStmt.close();
			}
			if (pStmt2 != null) {
				pStmt2.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return singleODB;
	}
	
	public Collection<SingleOrderBean> getAllOrders() throws SQLException {
		Collection<SingleOrderBean> collSingleODB = new ArrayList<SingleOrderBean>();
		String sqlOrder = "SELECT * FROM ORD_singleOrder Order by ORD_date desc, ORD_no desc ";
		PreparedStatement pStmt = null;
		Connection conn = null;
		ResultSet rs = null;
		SingleOrderBean singleODB = null;
		try {
			conn = dataSource.getConnection();
			pStmt = conn.prepareStatement(sqlOrder);
			rs = pStmt.executeQuery();

			while (rs.next()) {
				singleODB = new SingleOrderBean();
				singleODB.setORD_no(rs.getString(1));
				singleODB.setMBR_MEMBERID(rs.getString(2));
				singleODB.setORD_totalAmount(rs.getDouble(3));
				singleODB.setORD_shippingAddress(rs.getString(4));
				singleODB.setORD_descriptions(rs.getString(5));
				singleODB.setORD_date(rs.getDate(6));
				singleODB.setORD_shippingdate(rs.getDate(7));
				collSingleODB.add(singleODB);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pStmt != null) {
				pStmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("ShoppingOrderDAOJDBC coll.size()=  " + collSingleODB.size());
		return collSingleODB;
	}
	
	public Collection<SingleOrderBean> getMemberOrders() throws SQLException {
		Collection<SingleOrderBean> collSingleODB = new ArrayList<SingleOrderBean>();
		String sqlOrder = "SELECT * FROM ORD_singleOrder Order by ORD_date desc where MBR_MEMBERID = ?";
		PreparedStatement pStmt = null;
		Connection conn = null;
		ResultSet rs = null;
		SingleOrderBean singleODB = null;
		try {
			conn = dataSource.getConnection();
			pStmt = conn.prepareStatement(sqlOrder);
			pStmt.setString(1, MBR_MEMBERID);
			rs = pStmt.executeQuery();

			while (rs.next()) {
				singleODB = new SingleOrderBean();
//				singleODB.setMBR_MEMBERID(rs.getString(2));
//				singleODB.setTotalAmount(rs.getDouble(3));
//				singleODB.setShippingAddress(rs.getString(4));
//				singleODB.setBno(rs.getString(5));
//				singleODB.setInvoiceTitle(rs.getString(6));
//				singleODB.setOrderDate(rs.getDate(7));
//				singleODB.setShippingDate(rs.getDate(8));
//				coll.add(singleODB);
				singleODB.setMBR_MEMBERID(rs.getString(2));
				singleODB.setORD_totalAmount(rs.getDouble(3));
				singleODB.setORD_shippingAddress(rs.getString(4));
				singleODB.setORD_descriptions(rs.getString(5));
				singleODB.setORD_date(rs.getDate(6));
				singleODB.setORD_shippingdate(rs.getDate(7));
				collSingleODB.add(singleODB);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pStmt != null) {
				pStmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return collSingleODB;
	}
	public String getMemberId() {
		return MBR_MEMBERID;
	}

	public void setMemberId(String MBR_MEMBERID) {
		this.MBR_MEMBERID = MBR_MEMBERID;
	}
	
}
