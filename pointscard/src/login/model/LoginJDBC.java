package login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class LoginJDBC implements LoginDAO {
	
	private DataSource dataSource;
	public LoginJDBC() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oooHya");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_MBR_MEMBERID = "select * from HG_Member where MBR_MEMBERID=?";

	@Override
	public CustomerBean select(String MBR_MEMBERID) {
		CustomerBean result = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_MBR_MEMBERID);
			
			stmt.setString(1, MBR_MEMBERID);
			rset = stmt.executeQuery();
			System.out.println("JDBC rset Test" +  "   " + rset);
			if(rset.next()) {
				result = new CustomerBean();
				result.setMBR_MEMBERID(rset.getString("MBR_MEMBERID"));
				result.setMBR_NAME(rset.getString("MBR_NAME"));
				result.setMBR_PWD(rset.getString("MBR_PWD"));
				result.setMBR_SEX(rset.getString("MBR_SEX"));
				result.setMBR_BIRTHDAY(rset.getString("MBR_BIRTHDAY"));
				result.setMBR_IDENTITY(rset.getString("MBR_IDENTITY"));
				result.setMBR_ARRDESS(rset.getString("MBR_ARRDESS"));
				result.setMBR_MOBIL(rset.getString("MBR_MOBIL"));
				result.setMBR_EMAIL(rset.getString("MBR_EMAIL"));				
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
}
