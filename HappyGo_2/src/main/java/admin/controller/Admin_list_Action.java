package admin.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.AdminUserDAOService;
import admin.model.AdminUserDAObean;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Admin_list_Action extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private String ADM_ID;
	//private String ADM_PWD;
	private String ADM_NAME;
//	private String ADM_ROLEID;
//	private String ADM_UPDATEUSER;
	//private String prodaction;
//	public String getProdaction() {
//		return prodaction;
//	}
//
//	public void setProdaction(String prodaction) {
//		this.prodaction = prodaction;
//	}

	public String getADM_ID() {
		return ADM_ID;
	}

	public void setADM_ID(String ADM_ID) {
		this.ADM_ID = ADM_ID;
	}

//	public String getADM_PWD() {
//		return ADM_PWD;
//	}
//
//	public void setADM_PWD(String aDM_PWD) {
//		ADM_PWD = aDM_PWD;
//	}

	public String getADM_NAME() {
		return ADM_NAME;
	}

	public void setADM_NAME(String ADM_NAME) {
		this.ADM_NAME = ADM_NAME;
	}

//	public String getADM_ROLEID() {
//		return ADM_ROLEID;
//	}
//
//	public void setADM_ROLEID(String aDM_ROLEID) {
//		ADM_ROLEID = aDM_ROLEID;
//	}
//
//	public String getADM_UPDATEUSER() {
//		return ADM_UPDATEUSER;
//	}
//
//	public void setADM_UPDATEUSER(String aDM_UPDATEUSER) {
//		ADM_UPDATEUSER = aDM_UPDATEUSER;
//	}	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}

	private AdminUserDAOService adminUserDAOService;

	public void setAdminUserDAOService(AdminUserDAOService adminUserDAOService) {
		this.adminUserDAOService = adminUserDAOService;
	}

	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	private AdminUserDAObean checkkeyin() {
//		int iID = 0;
//		if (id != null && id.trim().length() != 0) {
//			try {
//				iID = Integer.parseInt(id.trim());
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//				System.out.println("id error");
//				this.addFieldError("id", "Id敹���");
//			}
//		}
//
//		double dPrice = 0;
//		if (price != null && price.trim().length() != 0) {
//			try {
//				dPrice = Double.parseDouble(price.trim());
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//				System.out.println("price error");
//				this.addFieldError("price", "Price敹��摮�");
//			}
//		}
//		java.util.Date dtMake = null;
//		if (make != null && make.trim().length() != 0) {
//			try {
//				dtMake = sFormat.parse(make.trim());
//			} catch (ParseException e) {
//				e.printStackTrace();
//				System.out.println("make error");
//				this.addFieldError("make", "Make敹�����撘YYYY-MM-DD");
//			}
//		}
//		int iExpire = 0;
//		if (expire != null && expire.trim().length() != 0) {
//			try {
//				iExpire = Integer.parseInt(expire.trim());
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//				System.out.println("expire error");
//				this.addFieldError("expire", "Expire敹���");
//			}
//		}
		
		AdminUserDAObean bean = new AdminUserDAObean();
		
		bean.setADM_ID(ADM_ID);
		bean.setADM_NAME(ADM_NAME);
		bean.setADM_PWD("");
		bean.setADM_ROLEID("");
		bean.setADM_UPDATEUSER("");
		return bean;
	}

	public String execute() throws Exception {
		System.out.println("execute");
		AdminUserDAObean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
//		String  prodaction=req.getParameter("prodaction");
//		if ("select".equals(prodaction)) {
			List<AdminUserDAObean> result = adminUserDAOService.select(null);
			if (result == null) {
				System.out.println("select fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("select ok");
				req.setAttribute("select", result);
				return Action.SUCCESS;
			}
//		} else if ("insert".equals(prodaction)) {
//			AdminUserDAObean result = adminUserDAOService.insert(bean);
//			if (result == null) {
//				System.out.println("insert fail");
//				this.addFieldError("action", "Insert fail");
//			} else {
//				System.out.println("insert ok");
//				req.setAttribute("insert", result);
//				return Action.INPUT;
//			}
//		} else if ("update".equals(prodaction)) {
//			AdminUserDAObean result = adminUserDAOService.update(bean);
//			if (result == null) {
//				System.out.println("update fail");
//				this.addFieldError("action", "update fail");
//			} else {
//				req.setAttribute("update", result);
//				System.out.println("update ok");
//				return Action.INPUT;
//			}
//		} 
		System.out.println("final");
		return Action.INPUT;
	}

	public String dayu_select() throws Exception {
		System.out.println("dayu_select");
		AdminUserDAObean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
		List<AdminUserDAObean> result = adminUserDAOService.select(bean);
		if (result == null) {
			System.out.println("select fail");
			this.addFieldError("action", "Insert fail");
		} else {
			System.out.println("select ok");
			req.setAttribute("select", result);
			return Action.SUCCESS;
		}
		System.out.println("dayu_select final");
		return Action.INPUT;
	}

	public String dayu_insert() throws Exception {
		System.out.println("show1");
		AdminUserDAObean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
		List<AdminUserDAObean> result = adminUserDAOService.select(bean);
		if (result == null) {
			System.out.println("select fail");
			this.addFieldError("action", "Insert fail");
		} else {
			System.out.println("select ok");
			req.setAttribute("select", result);
			return Action.SUCCESS;
		}
		System.out.println("final");
		return Action.INPUT;
	}

	public String dayu_update() throws Exception {
		System.out.println("dayu_update");
		AdminUserDAObean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
		AdminUserDAObean result = adminUserDAOService.update(bean);
		if (result == null) {
			System.out.println("update fail");
			this.addFieldError("action", "update fail");
		} else {
			req.setAttribute("update", result);
			System.out.println("update ok");
			return Action.INPUT;
		}
		System.out.println("dayu_update final");
		return Action.INPUT;
	}
}
