package shopping.model;

import java.util.List;

public interface ShoppingDAO {
	public abstract ShoppingBean selectByTran(long tranId);
	public abstract List<ShoppingBean> selectByMember(String memberId);
	public abstract List<ShoppingBean> selectByStore(String storeId);
	public abstract List<ShoppingBean> selectByProj(int projId);
	public abstract List<ShoppingBean> selectByDate(String begin, String end);
	
	public abstract boolean update(String status, ShoppingBean bean);
	public abstract boolean insert(ShoppingBean bean);
}
