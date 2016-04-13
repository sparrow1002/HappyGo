package register.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RegisterDAOJDBC implements RegisterDAO{
	private DataSource dataSource = null;
//	private LoginServiceDB lsdb = null;
	public RegisterDAOJDBC() {
	
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oooHya");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
	

	private static final String INSERT = "insert into HG_Member ( MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_SEX, MBR_BIRTHDAY, MBR_IDENTITY,MBR_ARRDESS, MBR_MOBIL, MBR_EMAIL) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	@Override
	public CustomerBean saveMember(CustomerBean bean) {	
		
		CustomerBean result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;	
		
			int count;
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(INSERT);
				count = 0;

				pstmt.setString(1, bean.getMBR_MEMBERID());
				pstmt.setString(2, bean.getMBR_NAME());
				pstmt.setString(3, bean.getMBR_PWD());
				pstmt.setString(4, bean.getMBR_SEX());	
				pstmt.setString(5, bean.getMBR_BIRTHDAY());
				pstmt.setString(6, bean.getMBR_IDENTITY());
				pstmt.setString(7, bean.getMBR_ARRDESS());
				pstmt.setString(8, bean.getMBR_MOBIL());
				pstmt.setString(9, bean.getMBR_EMAIL());
				
				count = pstmt.executeUpdate();
				System.out.println(count);
				if(count ==1) {
					result = bean;
				}else {
					throw new SQLException("RegisterServiceDB:新增記錄數 : 0");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					pstmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				try {
					if(conn!=null){
					conn.close();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		return result;
	}

	private static final String SELECT_BY_ID = "Select MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_SEX, MBR_BIRTHDAY, MBR_IDENTITY, MBR_ARRDESS, MBR_MOBIL, MBR_EMAIL from HG_Member where MBR_MEMBERID = ?";
	@Override
	public CustomerBean select(String MBR_MEMBERID) {
		
		CustomerBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
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
				result.setMBR_ARRDESS(rset.getString("MBR_ARRDESS"));
				result.setMBR_MOBIL(rset.getString("MBR_MOBIL"));
				result.setMBR_EMAIL(rset.getString("MBR_EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
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
	public CustomerBean update() {
		return null;
	}

	@Override
	public List<CustomerBean> select() {
		return null;
	}

	@Override
	public int delete(int MBR_MEMBERID) {
		return 0;
	}
}