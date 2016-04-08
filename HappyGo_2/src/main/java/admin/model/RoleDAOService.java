package admin.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service(value = "roleDAOService")
public class RoleDAOService {
	private RoleDAO roleDAO;

	public RoleDAOService() {

	}

	public RoleDAOService(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	public List<RoleDAOBean> selectall() {
		List<RoleDAOBean> result=null;		
		result = roleDAO.select();
		return result;
	}
	
	public List<RoleDAOBean> select(RoleDAOBean bean) {
		List<RoleDAOBean> result=null;		
		result = roleDAO.select(bean.getROL_ROLEID());
		return result;
	}
	
	public boolean delete(RoleDAOBean bean) {
		boolean result=false;		
		result = roleDAO.delete(bean);
		return result;
	}
	
	public boolean insert(List<RoleDAOBean> beans) {
		boolean result=false;		
		result = roleDAO.insert(beans);
		return result;
	}
}
