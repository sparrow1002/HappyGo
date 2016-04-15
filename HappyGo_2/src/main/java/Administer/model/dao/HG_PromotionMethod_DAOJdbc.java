package Administer.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Administer.model.HG_PromotionBonus_Bean;
import Administer.model.HG_PromotionMethod_Bean;
import Administer.model.HG_PromotionMethod_DAO;

public class HG_PromotionMethod_DAOJdbc implements HG_PromotionMethod_DAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	public static void main(String[] args) {
		int projId = 2;
		HG_PromotionMethod_DAOJdbc dao = new HG_PromotionMethod_DAOJdbc();
		
		/*for(HG_PromotionMethod_Bean bean:dao.select(projId))
			System.out.println(bean);*/
		HG_PromotionMethod_Bean bean = new HG_PromotionMethod_Bean();
		bean.setPTM_NAME("煊");
		bean.setPTM_DESC("煊");
		bean.setPTM_model("1");
		bean.setPTM_OPER(">");
		bean.setPTM_VALUE("1");
		bean.setPTM_VARDATE(20);
		bean.setPTM_PROJID(1);
		bean.setPTM_UPDATEUSER("jdbc01");
		System.out.println(dao.insert(bean));
	}

	private static final String SELECT = "select * from HG_PromotionMethod where PTM_PROJID=?";
	public List<HG_PromotionMethod_Bean> select(int projId) {
		List<HG_PromotionMethod_Bean> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(SELECT);
			pstmt.setInt(1, projId);
			rset = pstmt.executeQuery();
			result = new ArrayList<HG_PromotionMethod_Bean>();
			while(rset.next()){
				HG_PromotionMethod_Bean bean = new HG_PromotionMethod_Bean();
				bean.setPTM_ID(rset.getInt("PTM_ID"));
				bean.setPTM_DESC(rset.getString("PTM_DESC"));
				bean.setPTM_model(rset.getString("PTM_model"));
				bean.setPTM_NAME(rset.getString("PTM_NAME"));
				bean.setPTM_OPER(rset.getString("PTM_OPER"));
				bean.setPTM_PROJID(rset.getInt("PTM_PROJID"));
				bean.setPTM_VALUE(rset.getString("PTM_VALUE"));
				bean.setPTM_VARDATE(rset.getInt("PTM_VARDATE"));
				bean.setPTM_UPDATETIME(rset.getDate("PTM_UPDATETIME"));
				bean.setPTM_UPDATEUSER(rset.getString("PTM_UPDATEUSER"));
				result.add(bean);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update HG_PromotionMethod set "
			+ "PTM_NAME=?,"
			+ "PTM_DESC=?,"
			+ "PTM_model=?,"
			+ "PTM_OPER=?,"
			+ "PTM_VALUE=?,"
			+ "PTM_VARDATE=?,"
			+ "PTM_PROJID=?,"
			+ "PTM_UPDATETIME=getdate(),"
			+ "PTM_UPDATEUSER=?"
			+ "where PTM_ID=?";
	public int update(HG_PromotionMethod_Bean bean) {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, bean.getPTM_NAME());
			pstmt.setString(2, bean.getPTM_DESC());
			pstmt.setString(3, bean.getPTM_model());
			pstmt.setString(4, bean.getPTM_OPER());
			pstmt.setString(5, bean.getPTM_VALUE());
			pstmt.setInt(6, bean.getPTM_VARDATE());
			pstmt.setInt(7, bean.getPTM_PROJID());
			pstmt.setString(8, bean.getPTM_UPDATEUSER());
			pstmt.setInt(9, bean.getPTM_ID());
			i = pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	private static final String INSERT = "insert into HG_PromotionMethod values"
			+ " (?,?,?,?,?,?,?,getdate(),?);";
	public int insert(HG_PromotionMethod_Bean bean) {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bean.getPTM_NAME());
			pstmt.setString(2, bean.getPTM_DESC());
			pstmt.setString(3, bean.getPTM_model());
			pstmt.setString(4, bean.getPTM_OPER());
			pstmt.setString(5, bean.getPTM_VALUE());
			pstmt.setInt(6, bean.getPTM_VARDATE());
			pstmt.setInt(7, bean.getPTM_PROJID());
			pstmt.setString(8, bean.getPTM_UPDATEUSER());
			i = pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
