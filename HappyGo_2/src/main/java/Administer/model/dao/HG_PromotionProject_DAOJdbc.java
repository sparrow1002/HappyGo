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

import org.springframework.stereotype.Component;

import Administer.controller.PromotionProject_Servlet;
import Administer.model.HG_PromotionProject_Bean;

//@Component(value="pmtProjDAO")
public class HG_PromotionProject_DAOJdbc {

	private DataSource dataSource;

	public HG_PromotionProject_DAOJdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/websource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { //main方法測試
		HG_PromotionProject_DAOJdbc dao = new HG_PromotionProject_DAOJdbc();
		/*for(HG_PromotionProject_Bean bean:dao.selectToday("20160412","00000005"))
			System.out.println(bean);*/
		// List<HG_PromotionProject_Bean> beans = dao.select("%活%");				//測試模糊查詢，從活動名稱關鍵字找資料
//		HG_PromotionProject_Bean beans =  dao.select(1);  				//測試從活動編號找活動
//		List<HG_PromotionProject_Bean> beans = dao.selectAll(); 					//測試從活動編號找活動
//		List<HG_PromotionProject_Bean> beans = dao.select("20160401", "20160601");  //測試從活動時間找活動
//		System.out.println(beans);
		System.out.println("selectforever" + dao.selectforever());
	}

	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_BY_ID = "select * from HG_PromotionProject where PTP_PROJID=?";
	private static final String SELECT_BETWEEN_TIME = "select * from HG_PromotionProject  "
			+ "where (PTP_CREATEDATE <= ? and PTP_DELDATE >= ?)   "
			+ "or  (PTP_CREATEDATE between ? and ?)  "
			+ "or  (PTP_DELDATE between ? and ?)";
	private static final String SELECT_BY_NAME = "select * from HG_PromotionProject where PTP_NAME like ?";
	private static final String SELECT_ALL = "select * from HG_PromotionProject";

	private static final String UPDATE = "update HG_PromotionProject set PTP_NAME=?, PTP_CREATEDATE=?, PTP_DELDATE=?, PTP_STATUS=?, PTP_DESC=?, PTP_FIXPOINT=?, PTP_UPDATETIME=getDate() where PTP_PROJID=?";
	private static final String INSERT = "insert into HG_PromotionProject (PTP_PROJID, PTP_NAME, PTP_CREATEDATE, PTP_DELDATE, PTP_STATUS, PTP_DESC, PTP_FIXPOINT, PTP_UPDATETIME) values (?, ?, ?, ?, ?, ?, ?, getDate())";
	
	private static final String SELECT_TODAY1="select PTP_PROJID,PTP_NAME,PTP_CREATEDATE,PTP_DELDATE,PTP_STATUS,PTP_DESC,PTP_COVER,PTP_FIXPOINT,PTP_UPDATETIME,PTP_UPDATEUSER"+ 
			" from HG_PromotionProject"+
			" join HG_PProjectStore on  PTP_PROJID = PPS_PROJID"+
			" where PTP_STATUS='1' and PPS_STOREID = ? and PTP_CREATEDATE<= ? and PTP_DELDATE>= ?";
	private static final String SELECT_TODAY2="select PTP_PROJID,PTP_NAME,PTP_CREATEDATE,PTP_DELDATE,PTP_STATUS,PTP_DESC,PTP_COVER,PTP_FIXPOINT,PTP_UPDATETIME,PTP_UPDATEUSER"+ 
			" from HG_PromotionProject"+
			" join HG_PProjectStore on  PTP_PROJID = PPS_PROJID"+
			" where PPS_STATUS='1' and PPS_STOREID = ? and PTP_CREATEDATE<= ? and PTP_DELDATE>= ? ";
	private static final String SELECT_TODAY3="select PTP_PROJID,PTP_NAME,PTP_CREATEDATE,PTP_DELDATE,PTP_STATUS,PTP_DESC,PTP_COVER,PTP_FIXPOINT,PTP_UPDATETIME,PTP_UPDATEUSER"+ 
			" from HG_PromotionProject"+
			" join HG_PProjectStore on  PTP_PROJID = PPS_PROJID"+
			" where PPS_STATUS='1'and PTP_STATUS='1' and PPS_STOREID = ? and PTP_CREATEDATE<= ? and PTP_DELDATE>= ?";
	
	private static final String SELECT_FOREVER="select * from HG_PromotionProject where PTP_CREATEDATE='20010101'and PTP_DELDATE='20991231'";
	
	public List<HG_PromotionProject_Bean> selectToday(String today,String storeId) { //SELECT_BY_ID的方法
		System.out.println("This is SELECT_TODAY");
		List<HG_PromotionProject_Bean> result = null;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//conn = dataSource.getConnection();
			//Web專用
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_TODAY1);	  //測試從活動編號找活動
			stmt.setString(1, storeId);
			stmt.setString(2, today);
			stmt.setString(3, today);
			rset = stmt.executeQuery();
			result = new ArrayList<HG_PromotionProject_Bean>();
			while (rset.next()) {
				HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
				bean.setPTP_PROJID(rset.getInt("PTP_PROJID"));
				bean.setPTP_NAME(rset.getString("PTP_NAME"));
				bean.setPTP_CREATEDATE(rset.getString("PTP_CREATEDATE"));
				bean.setPTP_DELDATE(rset.getString("PTP_DELDATE"));
				bean.setPTP_STATUS(rset.getString("PTP_STATUS"));
				bean.setPTP_DESC(rset.getString("PTP_DESC"));
				bean.setPTP_COVER(rset.getBytes("PTP_COVER"));
				bean.setPTP_FIXPOINT(rset.getInt("PTP_FIXPOINT"));
				bean.setPTP_UPDATETIME(rset.getDate("PTP_UPDATETIME"));
				bean.setPTP_UPDATEUSER(rset.getString("PTP_UPDATEUSER"));
				result.add(bean);//記得把bean塞進result傳出去
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public HG_PromotionProject_Bean select(int PTP_PROJID) { //SELECT_BY_ID的方法
		System.out.println("This is SELECT_BY_ID");
		HG_PromotionProject_Bean result = null;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			//Web專用
			stmt = conn.prepareStatement(SELECT_BY_ID);	  //測試從活動編號找活動
			stmt.setInt(1, PTP_PROJID);
			//            (1, "%"+DT+"%");
			rset = stmt.executeQuery();
			result = new HG_PromotionProject_Bean();
			while (rset.next()) {
				result = new HG_PromotionProject_Bean();//必備
				result.setPTP_PROJID(rset.getInt("PTP_PROJID"));
				result.setPTP_NAME(rset.getString("PTP_NAME"));
				result.setPTP_CREATEDATE(rset.getString("PTP_CREATEDATE"));
				result.setPTP_DELDATE(rset.getString("PTP_DELDATE"));
				result.setPTP_STATUS(rset.getString("PTP_STATUS"));
				result.setPTP_DESC(rset.getString("PTP_DESC"));
				result.setPTP_COVER(rset.getBytes("PTP_COVER"));
				result.setPTP_FIXPOINT(rset.getInt("PTP_FIXPOINT"));
				result.setPTP_UPDATETIME(rset.getDate("PTP_UPDATETIME"));
				result.setPTP_UPDATEUSER(rset.getString("PTP_UPDATEUSER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<HG_PromotionProject_Bean> select(String PTP_NAME) { //SELECT_BY_NAME的方法
		System.out.println("This is SELECT_BY_NAME");
		List<HG_PromotionProject_Bean> result = null;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			//Web專用
			stmt = conn.prepareStatement(SELECT_BY_NAME); //測試模糊查詢，從活動名稱關鍵字找資料
			stmt.setString(1, "%"+PTP_NAME+"%");
			//            (1, "%"+DT+"%");
			rset = stmt.executeQuery();
			result = new ArrayList<HG_PromotionProject_Bean>();
			while (rset.next()) {
				HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
				bean.setPTP_PROJID(rset.getInt("PTP_PROJID"));
				bean.setPTP_NAME(rset.getString("PTP_NAME"));
				bean.setPTP_CREATEDATE(rset.getString("PTP_CREATEDATE"));
				bean.setPTP_DELDATE(rset.getString("PTP_DELDATE"));
				bean.setPTP_STATUS(rset.getString("PTP_STATUS"));
				bean.setPTP_DESC(rset.getString("PTP_DESC"));
				bean.setPTP_COVER(rset.getBytes("PTP_COVER"));
				bean.setPTP_FIXPOINT(rset.getInt("PTP_FIXPOINT"));
				bean.setPTP_UPDATETIME(rset.getDate("PTP_UPDATETIME"));
				bean.setPTP_UPDATEUSER(rset.getString("PTP_UPDATEUSER"));
				result.add(bean);//記得把bean塞進result傳出去
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<HG_PromotionProject_Bean> select(String PTP_CREATEDATE, String PTP_DELDATE) {//SELECT_BETWEEN_TIME方法
		System.out.println("This is SELECT_BETWEEN_TIME");
		List<HG_PromotionProject_Bean> result = null;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_BETWEEN_TIME);
			//雖然有六個問號，但其實是用兩個值下去查詢
			stmt.setString(1, PTP_CREATEDATE);
			stmt.setString(2, PTP_DELDATE);
			stmt.setString(3, PTP_CREATEDATE);
			stmt.setString(4, PTP_DELDATE);
			stmt.setString(5, PTP_CREATEDATE);
			stmt.setString(6, PTP_DELDATE);
			rset = stmt.executeQuery();
			result = new ArrayList<HG_PromotionProject_Bean>();
			while (rset.next()) {
				HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
				bean.setPTP_PROJID(rset.getInt("PTP_PROJID"));
				bean.setPTP_NAME(rset.getString("PTP_NAME"));
				bean.setPTP_CREATEDATE(rset.getString("PTP_CREATEDATE"));
				bean.setPTP_DELDATE(rset.getString("PTP_DELDATE"));
				bean.setPTP_STATUS(rset.getString("PTP_STATUS"));
				bean.setPTP_DESC(rset.getString("PTP_DESC"));
				bean.setPTP_COVER(rset.getBytes("PTP_COVER"));
				bean.setPTP_FIXPOINT(rset.getInt("PTP_FIXPOINT"));
				bean.setPTP_UPDATETIME(rset.getDate("PTP_UPDATETIME"));
				bean.setPTP_UPDATEUSER(rset.getString("PTP_UPDATEUSER") + "\n");
				result.add(bean);// 記得把bean放進result傳出去
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<HG_PromotionProject_Bean> selectAll(){ //SELECT_ALL方法
		System.out.println("This is SELECT_ALL");
		List<HG_PromotionProject_Bean> result = null;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			System.out.println("This is selectAll DAO1");
			conn = dataSource.getConnection(); //Web專用
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); //SE JDBC測試用
			stmt = conn.prepareStatement(SELECT_ALL);	  //測試查詢全部
			rset = stmt.executeQuery();
			result = new ArrayList<HG_PromotionProject_Bean>();
			System.out.println("This is selectAll DAO2");
			while (rset.next()) {
				System.out.println("This is selectAll DAO3");
				HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
				bean.setPTP_PROJID(rset.getInt("PTP_PROJID"));
				bean.setPTP_NAME(rset.getString("PTP_NAME"));
				bean.setPTP_CREATEDATE(rset.getString("PTP_CREATEDATE"));
				bean.setPTP_DELDATE(rset.getString("PTP_DELDATE"));
				bean.setPTP_STATUS(rset.getString("PTP_STATUS"));
				bean.setPTP_DESC(rset.getString("PTP_DESC"));
				bean.setPTP_COVER(rset.getBytes("PTP_COVER"));
				bean.setPTP_FIXPOINT(rset.getInt("PTP_FIXPOINT"));
				bean.setPTP_UPDATETIME(rset.getDate("PTP_UPDATETIME"));
				bean.setPTP_UPDATEUSER(rset.getString("PTP_UPDATEUSER")+"\n");
				result.add(bean);//記得把bean放進result傳出去
				System.out.println("This is selectAll DAO4");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	public List<HG_PromotionProject_Bean> selectforever(){ //找永久活動的方法
		System.out.println("This is HG_PromotionProject_DAOJdbc SELECT_FOREVER");
		List<HG_PromotionProject_Bean> result = null;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			System.out.println("This is HG_PromotionProject_DAOJdbc selectAll DAO start");
//			conn = dataSource.getConnection(); //Web專用
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); //SE JDBC測試用
			stmt = conn.prepareStatement(SELECT_FOREVER);	  //找永久活動
			rset = stmt.executeQuery();
			result = new ArrayList<HG_PromotionProject_Bean>();
			while (rset.next()) {
				HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
				bean.setPTP_PROJID(rset.getInt("PTP_PROJID"));
				bean.setPTP_NAME(rset.getString("PTP_NAME"));
				bean.setPTP_CREATEDATE(rset.getString("PTP_CREATEDATE"));
				bean.setPTP_DELDATE(rset.getString("PTP_DELDATE"));
				bean.setPTP_STATUS(rset.getString("PTP_STATUS"));
				bean.setPTP_DESC(rset.getString("PTP_DESC"));
				bean.setPTP_COVER(rset.getBytes("PTP_COVER"));
				bean.setPTP_FIXPOINT(rset.getInt("PTP_FIXPOINT"));
				bean.setPTP_UPDATETIME(rset.getDate("PTP_UPDATETIME"));
				bean.setPTP_UPDATEUSER(rset.getString("PTP_UPDATEUSER"));
				result.add(bean);//記得把bean放進result傳出去
				System.out.println("This is HG_PromotionProject_DAOJdbc selectAll DAO end");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	public int insert(HG_PromotionProject_Bean bean){ //insert方法
		//傳入值可用bean，可單一屬性傳入String PTP_PROJID, String PTP_NAME, String PTP_CREATEDATE, String PTP_DELDATE, String PTP_STATUS, String PTP_DESC, byte[] PTP_COVER, int PTP_FIXPOINT, java.sql.Date PTP_UPDATETIME, String PTP_UPDATEUSER
		System.out.println("This is HG_PromotionProject INSERT");
		int insertAmount = 0;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection(); //Web專用
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
			stmt = conn.prepareStatement(INSERT);
			if(bean!=null){
				System.out.println("This is HG_PromotionProject INSERT DAO");
//			stmt.setString(1, bean.getPTP_PROJID());
//				↑不用設，SQL會自動加號碼
				
//PTP_NAME, PTP_CREATEDATE, PTP_DELDATE, PTP_STATUS, PTP_DESC, PTP_FIXPOINT, PTP_UPDATETIME, PTP_UPDATEUSER) values (?, ?, ?, ?, ?, ?, getDate(), ?
			stmt.setInt(1, bean.getPTP_PROJID());
			stmt.setString(2, bean.getPTP_NAME());
			stmt.setString(3, bean.getPTP_CREATEDATE());
			stmt.setString(4, bean.getPTP_DELDATE());
			stmt.setString(5, bean.getPTP_STATUS());
			stmt.setString(6, bean.getPTP_DESC());
//			stmt.setBytes(6, bean.getPTP_COVER()); //圖片
			stmt.setInt(7, bean.getPTP_FIXPOINT());
//			stmt.setDate(9, bean.getPTP_UPDATETIME());
//			bean不用設PTM_UPDATETIME，SQL指令有下
//			stmt.setString(9, bean.getPTP_UPDATEUSER());
			insertAmount = stmt.executeUpdate();
			System.out.println("This is HG_PromotionProject INSERT DAO run end");
			}else{
				insertAmount=999;
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertAmount;
	}
	public int update(HG_PromotionProject_Bean bean){
		System.out.println("This is UPDATE");
		//傳入值可用bean，可單一屬性傳入String PTP_PROJID, String PTP_NAME, String PTP_CREATEDATE, String PTP_DELDATE, String PTP_STATUS, String PTP_DESC, byte[] PTP_COVER, int PTP_FIXPOINT, java.sql.Date PTP_UPDATETIME, String PTP_UPDATEUSER
		int updatetAmount = 0;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			System.out.println("This is Update Dao1");
			conn = dataSource.getConnection(); //Web專用
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			System.out.println("This is Update Dao1");
			if(bean!=null){
			System.out.println("This is Update Dao2");
			stmt.setString(1, bean.getPTP_NAME());
			stmt.setString(2, bean.getPTP_CREATEDATE());
			stmt.setString(3, bean.getPTP_DELDATE());
			stmt.setString(4, bean.getPTP_STATUS());
			stmt.setString(5, bean.getPTP_DESC());
//			stmt.setBytes(7, bean.getPTP_COVER());
			stmt.setInt(6, bean.getPTP_FIXPOINT());
//			stmt.setDate(9, bean.getPTP_UPDATETIME());
//			bean不用設PTM_UPDATETIME，SQL指令有下
//			stmt.setString(9, bean.getPTP_UPDATEUSER());
			stmt.setInt(7, bean.getPTP_PROJID());
			updatetAmount = stmt.executeUpdate();
			System.out.println("This is Update Dao3");
			}else{
				updatetAmount=999;
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatetAmount;
	}
}
