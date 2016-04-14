package MemberInfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import MemberInfo.model.MemberBean;
import MemberInfo.model.MemberDAO;



public class MemberDAOJdbc implements MemberDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
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
		MemberDAO dao = new MemberDAOJdbc();
		MemberBean bean = dao.select("b00003");
		System.out.println(bean);
	}
	
	
	private static final String SELECT_BY_CUSTID = "select * from HG_Member where MBR_MEMBERID=?";
	@Override
	public MemberBean select(String MBR_MEMBERID) {
		MemberBean result = null;
		
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
				result = new MemberBean();
				result.setMBR_MEMBERID(rset.getString("MBR_MEMBERID"));
				result.setMBR_NAME(rset.getString("MBR_NAME"));
				result.setMBR_PWD(rset.getString("MBR_PWD"));
				result.setMBR_EMAIL(rset.getString("MBR_EMAIL"));
				result.setMBR_MOBIL(rset.getString("MBR_MOBIL"));
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
	
	private static final String UPDATE = 
			"update HG_Member set MBR_MOBIL=?, MBR_EMAIL=?, MBR_NAME=?, MBR_PWD=? where MBR_MEMBERID=?";
	@Override
	public MemberBean update(String MBR_MEMBERID, String MBR_NAME, 
			                   String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL) 
								
	{
		MemberBean result = null;
		try(
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(5, MBR_MEMBERID);
			stmt.setString(2, MBR_EMAIL);
			stmt.setString(3, MBR_NAME);
			stmt.setString(4, MBR_PWD);
			stmt.setString(1, MBR_MOBIL);

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
			"insert into HG_Member (MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_SEX, MBR_BIRTHDAY, " + 
			"MBR_IDENTITY, MBR_POST, MBR_ARRDESS, MBR_MARRIED, MBR_MOBIL, MBR_PHONE, MBR_EMAIL, " + 
			"MBR_CREATEDATE, MBR_DELDATE, MBR_POINTS, MBR_STATUS, MBR_INTRODUCER, MBR_UPDATETIME, MBR_UPDATEUSER)" +
			"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
				stmt.setString(15, null);
				stmt.setString(16, null);
				stmt.setString(17, null);
				stmt.setString(18, null);
				stmt.setString(19, null);
				
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
