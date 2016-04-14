package register.model;

import java.util.List;

public interface RegisterDAO {
	public CustomerBean saveMember(CustomerBean bean) ;
	
	public CustomerBean select(String MBR_MEMBERID);
	
	public CustomerBean update() ;
	
	public List<CustomerBean> select() ;
	
	public int delete(int MBR_MEMBERID);
	
	
	
}
