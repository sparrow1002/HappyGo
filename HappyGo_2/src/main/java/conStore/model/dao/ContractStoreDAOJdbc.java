package conStore.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import AAA000.DayDevice;
import conStore.model.ContractStoreBean;
import conStore.model.ContractStoreDAO;


public class ContractStoreDAOJdbc implements ContractStoreDAO {
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	
	private DataSource dataSource;
	public ContractStoreDAOJdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/websource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){	
		ContractStoreDAO dao = new ContractStoreDAOJdbc();
		ContractStoreBean bean = new ContractStoreBean();
		//bean.setCos_storeid("03");
		//bean.setCos_pwd("sa123456");
		//dao.insert(bean);
		//dao.delete("03");
		bean.setCos_storeid("01");
		bean.setCos_pwd("sa654321");
		bean.setCos_updatetime("2016-04-08 12:13:06.080");
		//dao.update("111","222","333","444","1","666","777","888","999","2016-04-08 12:13:06.080","000","01");
		dao.update(bean);
		List<ContractStoreBean> beans = dao.select();
		dao.select("03");
		System.out.println(bean);
	}
	DayDevice day = new DayDevice();	
	private static final String SELECT_BY_ID = "select * from HG_ContractStore where COS_STOREID=?";
	@Override
	public ContractStoreBean select(String storeId) {
		ContractStoreBean result = null;
		ResultSet rset = null;
		try(
//			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
			)
			{
			stmt.setString(1, storeId);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new ContractStoreBean();
				result.setCos_storeid(rset.getString("cos_storeid"));
				result.setCos_name(rset.getString("cos_name"));
				result.setCos_pwd(rset.getString("cos_pwd"));
				result.setCos_taxcode(rset.getString("cos_taxcode"));
				result.setCos_address(rset.getString("cos_address"));
				result.setCos_status(rset.getString("cos_status"));
				result.setCos_phone(rset.getString("cos_phone"));
				result.setCos_contact(rset.getString("cos_contact"));
				if(rset.getString("cos_createtime") == null){
					result.setCos_createtime("");
				}else{
				result.setCos_createtime(day.parse_DBtoWeb(rset.getString("cos_createtime")));
				}
				if(rset.getString("cos_deletime")==null){
					result.setCos_deletime("");
				}else{
				result.setCos_deletime(day.parse_DBtoWeb(rset.getString("cos_deletime")));
				}			
				result.setCos_updatetime(rset.getString("cos_updatetime"));
				result.setCos_updateuser(rset.getString("cos_updateuser"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
		return result;	
	}
	
	private static final String SELECT_ALL = "select * from HG_ContractStore where COS_STOREID != 'admin' and COS_STATUS !='2'"; 
	@Override
	public List<ContractStoreBean> select() {
		List<ContractStoreBean> result = null;
		try(
//			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();
			){
			result = new ArrayList<>();
			while(rset.next()){
				ContractStoreBean bean = new ContractStoreBean();				
				bean.setCos_storeid(rset.getString("cos_storeid"));
				bean.setCos_name(rset.getString("cos_name"));
				bean.setCos_pwd(rset.getString("cos_pwd"));
				bean.setCos_taxcode(rset.getString("cos_taxcode"));
				bean.setCos_address(rset.getString("cos_address"));
				bean.setCos_status(rset.getString("cos_status"));
				bean.setCos_phone(rset.getString("cos_phone"));
				bean.setCos_contact(rset.getString("cos_contact"));
				bean.setCos_createtime(day.parse_DBtoWeb(rset.getString("cos_createtime")));						
				bean.setCos_deletime(day.parse_DBtoWeb(rset.getString("cos_deletime")));
				bean.setCos_updatetime(rset.getString("cos_updatetime"));
				bean.setCos_updateuser(rset.getString("cos_updateuser"));
				result.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
			}
		return result;
	}
	
	private static final String INSERT = "insert into HG_ContractStore (COS_STOREID, COS_NAME, COS_PWD, COS_TAXCODE,"+
										 " COS_ADDRESS, COS_PHONE, COS_CONTACT, COS_CREATETIME,"+
										 " COS_DELETIME, COS_UPDATEUSER)"+ 
										 "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	@Override
	public ContractStoreBean insert(ContractStoreBean bean) {
		ContractStoreBean result = null;
		try(
//			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
				){
			if(bean!=null){
				stmt.setString(1, bean.getCos_storeid());
				stmt.setString(2, bean.getCos_name());
				stmt.setString(3, bean.getCos_pwd());
				stmt.setString(4, bean.getCos_taxcode());
				stmt.setString(5, bean.getCos_address());
				//stmt.setString(6, bean.getCos_status());
				stmt.setString(6, bean.getCos_phone());
				stmt.setString(7, bean.getCos_contact());
				stmt.setString(8, bean.getCos_createtime());
				stmt.setString(9, bean.getCos_deletime());
				stmt.setString(10, bean.getCos_updateuser());
				int i = stmt.executeUpdate();
				if(i == 1){
					result =bean;
				}
			}		
		}catch(SQLException e){e.printStackTrace();}
		return result;
	}

	private static final String UPDATE = "update HG_ContractStore set cos_name=?, cos_pwd=?, cos_taxcode=?,"+
										 " cos_address=?, cos_status=?, cos_phone=?, cos_contact=?,"+
										 " cos_createtime=?, cos_deletime=?, cos_updatetime=?, cos_updateuser=? where cos_storeid=?";
	@Override
	/*public ContractStoreBean update(String cos_name, String cos_pwd, String cos_taxcode,
			String cos_address, String cos_status, String cos_phone, String cos_contact, String cos_createtime,
			String cos_deletime,String  cos_updatetime,String cos_updateuser, String cos_storeid) {
		ContractStoreBean result = null;
		try(
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//Connection conn = dataSource.getConnection();	
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
				){	
			
			stmt.setString(1, cos_name);
			stmt.setString(2, cos_pwd);
			stmt.setString(3, cos_taxcode);
			stmt.setString(4, cos_address);
			stmt.setString(5, cos_status);
			stmt.setString(6, cos_phone);
			stmt.setString(7, cos_contact);
			stmt.setString(8, cos_createtime);
			stmt.setString(9, cos_deletime);
			stmt.setString(10, cos_updatetime);
			stmt.setString(11, cos_updateuser);
			stmt.setString(12, cos_storeid);
			int i = stmt.executeUpdate();
			if(i == 1){
				result = this.select(cos_storeid);
			}
		}catch(SQLException e){e.printStackTrace();}

		return result;
	}*/
	public ContractStoreBean update(ContractStoreBean bean) {
		ContractStoreBean result = null;
		try(
//			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();	
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
				){				
			stmt.setString(1, bean.getCos_name());
			stmt.setString(2, bean.getCos_pwd());
			stmt.setString(3, bean.getCos_taxcode());
			stmt.setString(4, bean.getCos_address());
			stmt.setString(5, bean.getCos_status());
			stmt.setString(6, bean.getCos_phone());
			stmt.setString(7, bean.getCos_contact());
			
			stmt.setString(8, day.parse_WebtoDB(bean.getCos_createtime()));
			
			stmt.setString(9, day.parse_WebtoDB(bean.getCos_deletime()));
			stmt.setString(10, bean.getCos_updatetime());
			stmt.setString(11, bean.getCos_updateuser());
			stmt.setString(12, bean.getCos_storeid());
			int i = stmt.executeUpdate();
			if(i == 1){
				result = this.select(bean.getCos_storeid());
			}
		}catch(SQLException e){e.printStackTrace();}

		return result;
	}

	private static final String DELETE = "delete from HG_ContractStore where cos_storeid=?";
	@Override
	public boolean delete(String storeId) {
		try(
//			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);){
			stmt.setString(1, storeId);
			int i = stmt.executeUpdate();
			if(i == 1){
				return true;
			}
		}catch(SQLException e){e.printStackTrace();}
		return false;
	}


	
}
