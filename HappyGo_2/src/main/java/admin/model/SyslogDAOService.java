package admin.model;

import java.util.List;

import org.springframework.stereotype.Service;
@Service(value = "syslogDAOService")
public class SyslogDAOService {
	private SyslogDAO syslogDAO;
	public SyslogDAOService() {

	}

	public SyslogDAOService(SyslogDAO syslogDAO) {
		this.syslogDAO = syslogDAO;
	}
	
	public List<SyslogDAOBean> select() {
		List<SyslogDAOBean> result=null;		
		result = syslogDAO.select();
		return result;
	}
	
	public List<SyslogDAOBean> select(SyslogDAOBean bean) {
		List<SyslogDAOBean> result=null;		
		result = syslogDAO.select(bean);
		return result;
	}
	
	public SyslogDAOBean insert(SyslogDAOBean bean) {
		SyslogDAOBean result;
		result = syslogDAO.insert(bean);
		return result;
	}
}
