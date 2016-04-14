package products.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductJDBC implements ProductsDAO {
	private DataSource dataSource;
	
	 public ProductJDBC() {		
		try {
			 Context ctx = new InitialContext();
			 dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oooHya");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE = "update products set PD_name=?, PD_ID=?, PD_discriptions=?, PD_amount=?, PD_price=?, PD_fileBane, PD_image where PD_no=?";

	@Override
	public int updateProducts(ProductBean bean, InputStream ipt, long sizeInBytes) {
		Connection conn=null;
		PreparedStatement stmt = null;
		int count = 0;
		if(sizeInBytes == -1){
			count = updateProducts(bean);
			return count;
		}
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.clearParameters(); //?
			stmt.setString(1, bean.getPD_name());
			stmt.setString(2, bean.getPD_ID());
			stmt.setString(3, bean.getPD_discriptions());
			stmt.setInt(4, bean.getPD_amount());
			stmt.setDouble(5, bean.getPD_price());
			stmt.setString(6, bean.getPD_fileName());
			stmt.setBinaryStream(7, ipt, sizeInBytes);
			stmt.setString(8, bean.getPD_no());
			count = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			
			try {
				if(stmt!=null){
				stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	private static final String UPDATEONE = "update products set PD_name=?, PD_ID=?, PD_discriptions=?, PD_amount=?, PD_price=? where PD_no=?";

	@Override
	public int updateProducts(ProductBean bean) {
		Connection conn=null;
		PreparedStatement stmt = null;
		int count = 0;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(UPDATEONE);
			stmt.clearParameters();  //?
			stmt.setString(1, bean.getPD_name());
			stmt.setString(2, bean.getPD_ID());
			stmt.setString(3, bean.getPD_discriptions());
			stmt.setInt(4, bean.getPD_amount());
			stmt.setDouble(5, bean.getPD_price());
			stmt.setString(6, bean.getPD_no());
			count = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			
			try {
				if(stmt!=null){
				stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	private static final String SELECT = "select * from HG_products where PD_no = ?";
	@Override
	public ProductBean getProduct(String PD_no) {
		ProductBean bean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT);
			stmt.setString(1, PD_no);
			rset = stmt.executeQuery();
			if(rset.next()) {			
				bean = new ProductBean();
				bean.setPD_no(rset.getString(1));
				bean.setPD_name(rset.getString(2));
				bean.setPD_ID(rset.getString(3));
				bean.setPD_discriptions(rset.getString(4));
				bean.setPD_amount(rset.getInt(5));
				bean.setPD_price(rset.getDouble(6));
				bean.setPD_fileName(rset.getString(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {				
				if (rset!=null) {
					rset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				if (stmt!=null) {
					stmt.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				if (conn!=null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return bean;
	}
	
	private static final String SELECT_ALL = "Select * from HG_products";
	@Override
	public Collection<ProductBean> getAllProducts() {
		Collection<ProductBean> productBox = new ArrayList<ProductBean>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
				
			try {
				conn = dataSource.getConnection();
				stmt = conn.prepareStatement(SELECT_ALL);
				rset = stmt.executeQuery();
				while (rset.next()) {
					ProductBean bean = new ProductBean();
					bean = new ProductBean();
					bean.setPD_no(rset.getString(1));
					bean.setPD_name(rset.getString(2));
					bean.setPD_ID(rset.getString(3));
					bean.setPD_discriptions(rset.getString(4));
					bean.setPD_price(rset.getDouble(5));
					bean.setPD_fileName(rset.getString(6));
					
					productBox.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if (rset != null) {
					try {
						rset.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch(SQLException e){
					   e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		return productBox;
	}
	
	private static final String DELETE = "delete * from HG_products where PD_no = ?";
	@Override
	public int deleteProducts(String PD_no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, "PD_no");
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException e){
				   e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	private static final String INSERT = "insert into HG_products(PD_no, PD_name, PD_ID, PD_discriptions, PD_amount, PD_price, PD_fileName, PD_image)" 
				+ "values(?,?,?,?,?,?,?,?)";
	@Override
	public int insertProducts(ProductBean bean, InputStream ipt, long sizeInBytes) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT);
			count = stmt.executeUpdate();
			stmt.setString(1, bean.getPD_no());
			stmt.setString(2, bean.getPD_name());
			stmt.setString(3, bean.getPD_ID());
			stmt.setString(4, bean.getPD_discriptions());
			stmt.setInt(5, bean.getPD_amount());
			stmt.setDouble(6, bean.getPD_price());
			stmt.setString(7, bean.getPD_fileName());
			stmt.setBinaryStream(8, ipt, sizeInBytes);
			count = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {			
			try {
				if(stmt!=null){
				stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
}
