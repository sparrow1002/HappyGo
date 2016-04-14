package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.CustomerBean;
import model.CustomerDAO;


public class CustomerDAOJdbc implements CustomerDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=HAPPYGO";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "P@ssw0rd";
	
	private DataSource dataSource;
//	public CustomerDAOJdbc() {
//		try {
//			Context ctx = new InitialContext();
//			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOJdbc();
		CustomerBean bean = dao.select("b00003");
		System.out.println(bean);
	}
	
	
	private static final String SELECT_BY_CUSTID = "select * from HG_Member where MBR_MEMBERID=?";
	@Override
	public CustomerBean select(String MBR_MEMBERID) {
		CustomerBean result = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_CUSTID);
			
			stmt.setString(1, MBR_MEMBERID);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new CustomerBean();
				result.setMBR_MEMBERID(rset.getString("MBR_MEMBERID"));
				result.setMBR_NAME(rset.getString("MBR_NAME"));
				result.setMBR_PWD(rset.getString("MBR_PWD"));
				result.setMBR_SEX(rset.getString("MBR_SEX"));
				result.setMBR_BIRTHDAY(rset.getString("MBR_BIRTHDAY"));
				result.setMBR_IDENTITY(rset.getString("MBR_IDENTITY"));
				result.setMBR_POST(rset.getString("MBR_POST"));
				result.setMBR_ARRDESS(rset.getString("MBR_ARRDESS"));
				result.setMBR_MEMBERID(rset.getString("MBR_MARRIED"));
				result.setMBR_MOBIL(rset.getString("MBR_MOBIL"));
				result.setMBR_PHONE(rset.getString("MBR_PHONE"));
				result.setMBR_EMAIL(rset.getString("MBR_EMAIL"));
				result.setMBR_CREATEDATE(rset.getString("MBR_CREATEDATE"));
				result.setMBR_DELDATE(rset.getString("MBR_DELDATE"));
				result.setMBR_POINTS(rset.getInt("MBR_POINTS"));
				result.setMBR_STATUS(rset.getString("MBR_STATUS"));
				result.setMBR_INTRODUCER(rset.getString("MBR_INTRODUCER"));
				result.setMBR_UPDATETIME(rset.getDate("MBR_UPDATETIME"));
				result.setMBR_UPDATEUSER(rset.getString("MBR_UPDATEUSER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	private static final String UPDATE = "update HG_Member set "
			+ "MBR_NAME=?,"/*1*/
			+ "MBR_PWD=?, "/*2*/
			+ "MBR_SEX=?, "/*3*/
			+ "MBR_BIRTHDAY=?, "/*4*/
			+ "MBR_IDENTITY=?, "/*5*/
			+ "MBR_POST=?, "/*6*/
			+ "MBR_ARRDESS=?, "/*7*/
			+ "MBR_MARRIED=?, "/*8*/
			+ "MBR_MOBIL=?, "/*9*/
			+ "MBR_PHONE=?, "/*10*/
			+ "MBR_EMAIL=?, "/*11*/
			+ "MBR_CREATEDATE=?, "/*12*/
			+ "MBR_DELDATE=?, "/*13*/
			+ "MBR_POINTS=?, "/*14*/
			+ "MBR_STATUS=?, "/*15*/
			+ "MBR_INTRODUCER=?, "/*16*/
			+ "MBR_UPDATETIME=getdate(),"
			+ "MBR_UPDATEUSER=?, "/*17*/

			+ "where MBR_MEMBERID=?";/*18*/
	@Override
	public CustomerBean update(String MBR_MEMBERID, String MBR_NAME, 
			                   String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL) 
								
	{
		CustomerBean result = null;
		try(
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(18, MBR_MEMBERID);
			stmt.setString(11, MBR_EMAIL);
			stmt.setString(1, MBR_NAME);
			stmt.setString(2, MBR_PWD);
			stmt.setString(9, MBR_MOBIL);

			int i = stmt.executeUpdate();
			if(i>0) {
				result = this.select(MBR_MEMBERID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	private static final String INSERT = 
			"insert into HG_Member "
			+ "(MBR_MEMBERID, "/*1*/
			+ "MBR_NAME, "/*2*/
			+ "MBR_PWD, "/*3*/
			+ "MBR_SEX, "/*4*/
			+ "MBR_BIRTHDAY, "/*5*/ 
			+ "MBR_IDENTITY, "/*6*/
			+ "MBR_POST, "/*7*/
			+ "MBR_ARRDESS, "/*8*/
			+ "MBR_MARRIED, "/*9*/
			+ "MBR_MOBIL, "/*10*/
			+ "MBR_PHONE, "/*11*/
			+ "MBR_EMAIL, "/*12*/ 
			+ "MBR_CREATEDATE, "/*13*/
			+ "MBR_DELDATE, "/*14*/
			+ "MBR_POINTS, "/*15*/
			+ "MBR_STATUS, "/*16*/
			+ "MBR_INTRODUCER, "/*17*/
			+ "MBR_UPDATETIME, "
			+ "MBR_UPDATEUSER)" /*18*/
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, getdate(), ?)";
	@Override
	public boolean insert(String MBR_MEMBERID, String MBR_NAME,
			String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL) {
		int i = 0;
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				stmt = conn.prepareStatement(INSERT);
				stmt.setString(1, MBR_MEMBERID);
				stmt.setString(2, MBR_NAME);
				stmt.setString(3, MBR_PWD);
//				stmt.setString(4, bean.getMBR_SEX());
				stmt.setString(4, null);
				stmt.setString(5, null);
				stmt.setString(6, null);
				stmt.setString(7, null);
				stmt.setString(8, null);
				stmt.setString(9, null);
				stmt.setString(10, MBR_MOBIL);
				stmt.setString(11, null);
				stmt.setString(12, MBR_EMAIL);
				stmt.setString(13, null);
				stmt.setString(14, null);
				stmt.setInt(15, 0);
				stmt.setString(16, null);
				stmt.setString(17, null);
				
				stmt.setString(18, null);
				
				i = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i>0) return true;
				else
					return false;
			}

	}
	
	
	private static final String DELETE = "delete from HG_Member where MBR_MEMBERID=?";
	@Override
	public boolean delete(String MBR_MEMBERID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			Connection conn = dataSource.getConnection();
			stmt = conn.prepareStatement(DELETE);			
			stmt.setString(1, MBR_MEMBERID);
			i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1) 
				return true;
			else 
				return false;			
		}

	}	
}
