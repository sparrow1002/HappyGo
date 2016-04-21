package conStore.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import conStore.model.ContractStoreBean;
import conStore.model.ContractStoreDAO;
import conStore.model.PProjectStoreBean;
import conStore.model.PProjectStoreDAO;

public class PProjectStoreDAOJdbc implements PProjectStoreDAO{
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=happygo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "sa123456";
	
	private DataSource dataSource;
	public PProjectStoreDAOJdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/websource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){	
		PProjectStoreDAO dao = new PProjectStoreDAOJdbc();
		PProjectStoreBean bean1 = new PProjectStoreBean();
		List<PProjectStoreBean> beans = new ArrayList<>();
		bean1.setPps_projid(1002);
		bean1.setPps_storgpid("north");
		bean1.setPps_storeid("N02");
		bean1.setPps_updateuser("");
		beans.add(bean1);
		
		PProjectStoreBean bean2 = new PProjectStoreBean();
		bean2.setPps_projid(1003);
		bean2.setPps_storgpid("a");
		bean2.setPps_storeid("b");
		bean2.setPps_updateuser("");
		beans.add(bean2);
		
		dao.insert(beans);
	}
	
	private static final String INSERT = "insert into HG_PProjectStore (PPS_PROJID, PPS_STORGPID,"
									   + "PPS_STOREID, PPS_UPDATEUSER)"
									   + "values (?,?,?,?)";
	@Override 
	public int[] insert(List<PProjectStoreBean> beans) { 
	int i[] = null; 
	try( 
//		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
	Connection conn = dataSource.getConnection();	
	PreparedStatement stmt = conn.prepareStatement(INSERT);	
	){ 
	for (PProjectStoreBean bean: beans) {
	stmt.setInt(1, bean.getPps_projid()); 
	stmt.setString(2, bean.getPps_storgpid()); 
	stmt.setString(3, bean.getPps_storeid()); 
	stmt.setString(4, bean.getPps_updateuser());
	stmt.addBatch(); 
	} 
	i = stmt.executeBatch(); 
	}	
	catch(SQLException e){e.printStackTrace();} 
	return i; 
	}
	
	
}
