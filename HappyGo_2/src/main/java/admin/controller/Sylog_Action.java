package admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.DataProfileDAOService;
import admin.model.SyslogDAOBean;
import admin.model.SyslogDAOService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Sylog_Action extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	private String LOG_USERID;

	public String getLOG_USERID() {
		return LOG_USERID;
	}

	public void setLOG_USERID(String lOG_USERID) {
		LOG_USERID = lOG_USERID;
	}

	private SyslogDAOService syslogDAOService;

	public void setSyslogDAOService(SyslogDAOService syslogDAOService) {
		this.syslogDAOService = syslogDAOService;
	}

	private DataProfileDAOService dataProfileDAOService;

	public void setDataProfileDAOService(
			DataProfileDAOService dataProfileDAOService) {
		this.dataProfileDAOService = dataProfileDAOService;
	}

	public String execute() throws Exception {
		System.out.println("execute");

		HttpServletRequest req = ServletActionContext.getRequest();
		String mode = req.getParameter("mode");
		// DataProfileDAOBean beans = new DataProfileDAOBean();

		// List<DataProfileDAOBean> dataprofileresult;
		// dataprofileresult = dataProfileDAOService.select(beans);
		// System.out.println(dataprofileresult);
		// req.setAttribute("roleid", dataprofileresult);
		// System.out.println("mode:" + mode);
		if ("select".equals(mode)) {
			List<SyslogDAOBean> result = syslogDAOService.select();
			if (result == null) {
				System.out.println("select fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("select ok");
				req.setAttribute("select", result);
				return Action.SUCCESS;
			}
		} else if ("selectitem".equals(mode)) {
			List<SyslogDAOBean> result;
			// System.out.println(ADM_ID);
			if (LOG_USERID != null && LOG_USERID.trim() != "") {
				SyslogDAOBean bean = new SyslogDAOBean();
				bean.setLOG_USERID(LOG_USERID);
				result = syslogDAOService.select(bean);
			} else
				result = syslogDAOService.select();
			if (result == null) {
				System.out.println("selectitem fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("selectitem ok");
				req.setAttribute("selectitem", result.get(0));
				SyslogDAOBean bean = new SyslogDAOBean();
				result = syslogDAOService.select(null);
				req.setAttribute("select", result);
				return Action.SUCCESS;
			}
		}
		System.out.println("final");
		return Action.INPUT;
	}
}
