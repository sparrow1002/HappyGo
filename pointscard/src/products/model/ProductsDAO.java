package products.model;

import java.io.InputStream;
import java.util.Collection;

public interface ProductsDAO {
	
	public int updateProducts(ProductBean bean, InputStream ipt, long sizeInBytes);
	public int updateProducts(ProductBean bean);
	
	public ProductBean getProduct(String PD_no);
	public Collection<ProductBean> getAllProducts();
	public int deleteProducts(String PD_no);
	public int insertProducts(ProductBean bean, InputStream ipt, long sizeInBytes);

}
