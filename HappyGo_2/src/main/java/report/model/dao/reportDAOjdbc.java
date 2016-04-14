package report.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import report.model.reportDAOBean;

public class reportDAOjdbc {
	
	private DataSource datasource;
	
	public reportDAOjdbc(DataSource datasource) {
		this.datasource = datasource;
	}
	
	private static final String SELECT_BY_USERID = "select SOP_MEMBERID,COS_NAME,CPT_TRANDATE,SOP_TRANAMT,SOP_DISCOUNT,CPT_POINTADD,CPT_POINTDRE,SOP_overPoint from HG_CardPoint  join HG_Shopping on HG_CardPoint.CPT_TRANID = HG_Shopping.SOP_TRANID join HG_ContractStore on HG_Shopping.SOP_STOREID = HG_ContractStore.COS_STOREID where SOP_MEMBERID=? AND CPT_TRANDATE>=? AND CPT_TRANDATE<=?" ;
	private static final String SELECT_BY_store = "select SOP_MEMBERID,COS_NAME,CPT_TRANDATE,SOP_TRANAMT,SOP_DISCOUNT,CPT_POINTADD,CPT_POINTDRE,SOP_overPoint from HG_CardPoint  join HG_Shopping on HG_CardPoint.CPT_TRANID = HG_Shopping.SOP_TRANID join HG_ContractStore on HG_Shopping.SOP_STOREID = HG_ContractStore.COS_STOREID where SOP_STOREID=? AND CPT_TRANDATE>=? AND CPT_TRANDATE<=?" ;
	private static final String SELECT_BY_USERID_IDandstore = "select SOP_MEMBERID,COS_NAME,CPT_TRANDATE,SOP_TRANAMT,SOP_DISCOUNT,CPT_POINTADD,CPT_POINTDRE,SOP_overPoint from HG_CardPoint  join HG_Shopping on HG_CardPoint.CPT_TRANID = HG_Shopping.SOP_TRANID join HG_ContractStore on HG_Shopping.SOP_STOREID = HG_ContractStore.COS_STOREID where SOP_MEMBERID=? AND CPT_TRANDATE>=? AND CPT_TRANDATE<=? AND SOP_STOREID=?" ;
	public Collection<Map<String, ?>> select(String id,String day1,String day2,String store){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Collection<Map<String, ?>> result = null;
		try {
			conn = datasource.getConnection();
			if(store==null){
			pst = conn.prepareStatement(SELECT_BY_USERID);
			pst.setString(1, id);
			pst.setString(2, day1);
			pst.setString(3, day2);
			}else if(id==null){
				pst = conn.prepareStatement(SELECT_BY_store);
				pst.setString(1, store);
				pst.setString(2, day1);
				pst.setString(3, day2);
			}else{
			pst = conn.prepareStatement(SELECT_BY_USERID_IDandstore);
			pst.setString(1, id);
			pst.setString(2, day1);
			pst.setString(3, day2);
			pst.setString(4, store);
			}
			rs = pst.executeQuery();
			System.out.println("AdminUserDAObean select process:"
					+ SELECT_BY_USERID);
			result = new ArrayList<Map<String, ?>>();
			while (rs.next()) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("SOP_MEMBERID", rs.getString("SOP_MEMBERID"));
				data.put("COS_NAME", rs.getString("COS_NAME"));
				data.put("CPT_TRANDATE", rs.getString("CPT_TRANDATE"));
				data.put("SOP_TRANAMT", rs.getBigDecimal("SOP_TRANAMT"));
				data.put("SOP_DISCOUNT", rs.getBigDecimal("SOP_DISCOUNT"));
				data.put("CPT_POINTADD", rs.getBigDecimal("CPT_POINTADD"));
				data.put("CPT_POINTDRE", rs.getBigDecimal("CPT_POINTDRE"));
				data.put("SOP_overPoint", rs.getInt("SOP_overPoint"));
				result.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
private static final String CheckStore = "SELECT COS_STOREID FROM HG_ContractStore where SELECT COS_STOREID=?";
//public boolean checkStore(String store){
//	String result = null;
//	Connection conn = null;
//	PreparedStatement pst = null;
//	ResultSet rs = null;
//	try {
//		conn = datasource.getConnection();
//		pst = conn.prepareStatement(CheckStore);
//		pst.setString(1, store);
//		rs = pst.executeQuery();
//		if(rs.next()) {
//			result = rs.getString("SELECT COS_STOREID from HG_ContractStore");
//		}
//		if(result==null){
//			return false;
//		}else{
//			return true;
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if (pst != null)
//			try {
//				pst.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		if (conn != null)
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
//	return false;
//}
}
