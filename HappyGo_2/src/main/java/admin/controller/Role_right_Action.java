package admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.RightDAOBean;
import admin.model.RightDAOService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Role_right_Action extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private RightDAOService rightDAOService;
	private String RIG_RIGHTID;
	private String RIG_DESC;
	private String RIG_FUNTION;

	public void setRIG_RIGHTID(String rIG_RIGHTID) {
		RIG_RIGHTID = rIG_RIGHTID;
	}

	public void setRIG_DESC(String rIG_DESC) {
		RIG_DESC = rIG_DESC;
	}

	public void setRIG_FUNTION(String rIG_FUNTION) {
		RIG_FUNTION = rIG_FUNTION;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public void setRightDAOService(RightDAOService rightDAOService) {
		this.rightDAOService = rightDAOService;
	}

	public String execute() throws Exception {
		System.out.println("execute");
		// RightDAOBean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mode = req.getParameter("mode");
		System.out.println("mode:" + mode);
		if ("select".equals(mode)) {

		} else if ("edit".equals(mode)) {
			RightDAOBean bean = new RightDAOBean();
			bean.setRIG_RIGHTID(RIG_RIGHTID);
			bean = rightDAOService.select(bean);
			System.out.println("RIG_RIGHTID:" + RIG_RIGHTID);
			req.setAttribute("edit", bean);

		} else if ("update".equals(mode)) {
			RightDAOBean bean = new RightDAOBean();
			bean.setRIG_RIGHTID(RIG_RIGHTID);
			bean.setRIG_DESC(RIG_DESC);
			bean.setRIG_FUNTION(RIG_FUNTION);
			bean.setRIG_UPDATEUSER("dayu");
			bean = rightDAOService.update(bean);
			if (bean != null)
				req.setAttribute("message", "資料更新完成");

		}
		List<RightDAOBean> result = rightDAOService.select();
		req.setAttribute("select", result);
		System.out.println("final");
		return Action.INPUT;
	}
}
