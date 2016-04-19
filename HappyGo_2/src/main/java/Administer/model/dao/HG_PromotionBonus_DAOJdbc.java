package Administer.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cardPoint.model.CardPointBean;
import Administer.model.HG_PromotionBonus_Bean;
import Administer.model.HG_PromotionBonus_DAO;

public class HG_PromotionBonus_DAOJdbc implements HG_PromotionBonus_DAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
//	public static void main(String[] args) {
//		int projId = 2;
//		HG_PromotionBonus_DAOJdbc dao = new HG_PromotionBonus_DAOJdbc();
//		
//		for(HG_PromotionBonus_Bean bean:dao.select(projId))
//			System.out.println(bean);
//		HG_PromotionBonus_Bean bean = new HG_PromotionBonus_Bean();
//		bean.setPTB_ID(4);
//		bean.setPTB_model("b");
//		bean.setPTB_OPER("");
//		bean.setPTB_POINT(15);
//		bean.setPTB_PROJID(3);
//		bean.setPTB_VALUE(100);
//		bean.setPTB_UPDATEUSER("jdbc01");
//		if(dao.insert(bean))
//			System.out.println("insert ok");
//		else
//			System.out.println("insert error");
//		
//	}
	
	private DataSource dataSource;
	
	public HG_PromotionBonus_DAOJdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/websource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String SELECT = "select * from HG_PromotionBonus where PTB_PROJID=?;";
	public List<HG_PromotionBonus_Bean> select(int projId) {
		List<HG_PromotionBonus_Bean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			//conn = dataSource.getConnection();
			//Web專用
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT);
			pstmt.setInt(1, projId);
			rset = pstmt.executeQuery();
			result = new ArrayList<HG_PromotionBonus_Bean>();
			while(rset.next()){
				HG_PromotionBonus_Bean bean = new HG_PromotionBonus_Bean();
				bean.setPTB_ID(rset.getInt("PTB_ID"));
				bean.setPTB_model(rset.getString("PTB_model"));
				bean.setPTB_OPER(rset.getString("PTB_OPER"));
				bean.setPTB_POINT(rset.getInt("PTB_POINT"));
				bean.setPTB_PROJID(rset.getInt("PTB_PROJID"));
				bean.setPTB_VALUE(rset.getInt("PTB_VALUE"));
				bean.setPTB_UPDATETIME(rset.getDate("PTB_UPDATETIME"));
				bean.setPTB_UPDATEUSER(rset.getString("PTB_UPDATEUSER"));
				result.add(bean);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	private static final String UPDATE = "update HG_PromotionBonus set "
			+ "PTB_OPER=?,"
			+ "PTB_VALUE=?,"
			+ "PTB_POINT=?,"
			+ "PTB_PROJID=?,"
			+ "PTB_model=?,"
			+ "PTB_UPDATETIME=GETDATE(),"
			+ "PTB_UPDATEUSER=? "
			+ "where PTB_ID=?;";
	public int update(HG_PromotionBonus_Bean bean) {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, bean.getPTB_OPER());
			pstmt.setInt(2, bean.getPTB_VALUE());
			pstmt.setInt(3, bean.getPTB_POINT());
			pstmt.setInt(4, bean.getPTB_PROJID());
			pstmt.setString(5, bean.getPTB_model());
			pstmt.setString(6, bean.getPTB_UPDATEUSER());
			pstmt.setInt(7, bean.getPTB_ID());
			i = pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}


//	private static final String INSERT = "insert into HG_PromotionBonus (PTB_OPER, PTB_VALUE, PTB_POINT, PTB_PROJID, "
//										+ "PTB_model, PTB_UPDATETIME, PTB_UPDATEUSER, PTB_ID) "
//										+ "values (?,?,?,?,?,getdate(),?,?)";
	private static final String INSERT = "insert into HG_PromotionBonus (PTB_OPER, PTB_VALUE, PTB_POINT, PTB_PROJID, "
			+ "PTB_model, PTB_UPDATETIME, PTB_UPDATEUSER) "
			+ "values (?,?,?,?,?,getdate(),?)";
	public int insert(HG_PromotionBonus_Bean bean) {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bean.getPTB_OPER());
			pstmt.setInt(2, bean.getPTB_VALUE());
			pstmt.setInt(3, bean.getPTB_POINT());
			pstmt.setInt(4, bean.getPTB_PROJID());
			pstmt.setString(5, bean.getPTB_model());
			pstmt.setString(6, bean.getPTB_UPDATEUSER());
//			pstmt.setInt(7, bean.getPTB_ID());
			i = pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	

}
