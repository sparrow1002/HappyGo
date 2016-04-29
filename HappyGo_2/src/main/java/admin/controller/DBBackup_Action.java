package admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.AdminUserDAObean;
import admin.model.DBBackupDAOservice;
import admin.model.SyslogDAOBean;
import admin.model.SyslogDAOService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DBBackup_Action extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	private SyslogDAOService syslogDAOService;

	public void setSyslogDAOService(SyslogDAOService syslogDAOService) {
		this.syslogDAOService = syslogDAOService;
	}

	private DBBackupDAOservice dbBackupDAOservice= null;
	public void setDbBackupDAOservice(DBBackupDAOservice dbBackupDAOservice) {
		this.dbBackupDAOservice = dbBackupDAOservice;
	}

	public String execute() throws Exception {
		System.out.println("execute");

		HttpServletRequest req = ServletActionContext.getRequest();
		SyslogDAOBean lognean = new SyslogDAOBean();
		String mode = req.getParameter("mode");
		if ("exec".equals(mode)) {
			if (dbBackupDAOservice == null)
				System.out.println("DBBackup_Action dbBackupDAOservice is null");
			if (dbBackupDAOservice.execBackup()) {
				req.setAttribute("message", "資料更新成功");
				lognean.setLOG_TYPE("DB01");
				lognean.setLOG_USERID("DBBACKUP");
				lognean.setLOG_UPDATEUSER(sessionMap.get("adminuser")
						.toString());
				lognean.setLOG_DESC("資料庫備份:"
						+ sessionMap.get("adminuser").toString());
				lognean.setLOG_UPDATETIME(new java.util.Date());
				syslogDAOService.insert(lognean);
			} else {
				req.setAttribute("message", "資料更新失敗");
				lognean.setLOG_TYPE("DB02");
				lognean.setLOG_USERID("DBBACKUP");
				lognean.setLOG_UPDATEUSER(sessionMap.get("adminuser")
						.toString());
				lognean.setLOG_DESC("資料庫備份:"
						+ sessionMap.get("adminuser").toString());
				lognean.setLOG_UPDATETIME(new java.util.Date());
				syslogDAOService.insert(lognean);
			}
		}
		SyslogDAOBean bean = new SyslogDAOBean();
		bean.setLOG_USERID("DBBACKUP");
		List<SyslogDAOBean> result = null;
		result = syslogDAOService.select(bean);
		req.setAttribute("select", result);
		return Action.SUCCESS;
	}
}
