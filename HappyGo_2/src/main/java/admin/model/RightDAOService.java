package admin.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service(value = "rightDAOService")
public class RightDAOService {
	private RightDAO rightDAO;
	public RightDAOService() {

	}

	public RightDAOService(RightDAO rightDAO) {
		this.rightDAO = rightDAO;
	}
	
	public List<RightDAOBean> select() {
		List<RightDAOBean> result=null;		
		result = rightDAO.select();
		return result;
	}
	
	public RightDAOBean select(RightDAOBean bean) {
		RightDAOBean result=null;		
		result = rightDAO.select(bean);
		return result;
	}
	
	public RightDAOBean insert(RightDAOBean bean) {
		RightDAOBean result;
		result = rightDAO.insert(bean);
		return result;
	}
	
	public RightDAOBean delete(RightDAOBean bean) {
		RightDAOBean result;
		result = rightDAO.delete(bean);
		return result;
	}
	
	public RightDAOBean update(RightDAOBean bean) {
		RightDAOBean result;
		result = rightDAO.update(bean);
		return result;
	}
}
