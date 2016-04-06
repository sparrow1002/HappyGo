package cardPoint.model;

import java.util.List;

public interface CardPointDAO {
	//public abstract List<CardPointBean> selectByMbr(String memberId);
	//public abstract List<CardPointBean> selectByMbr_Status(String memberId,String status);
	//public abstract List<CardPointBean> selectByUseTran(String useTranId);
	
	/*查詢個人點數*/
	public abstract List<CardPointBean> selectPoint(String memberId,String dDate,String status);
	/*查詢個人即將失效點數*/ 
	public abstract CardPointBean selectLastPoint(String memberId,String dDate,String status);
	//取消交易
	public abstract CardPointBean selectByTran(String tranId);
	
	public abstract boolean update(String status , CardPointBean bean);
	public abstract boolean insert(CardPointBean bean);
}
