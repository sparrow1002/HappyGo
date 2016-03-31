package admin.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import admin.model.AdminUserDAOService;
import admin.model.AdminUserDAObean;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class Admin_Login_Action extends ActionSupport implements SessionAware {
	private String username;
	private String password;

	@Override
	public void validate() {
		// if (username == null || username.length() == 0) {
		// this.addFieldError("username", "隢撓�ID");
		// }
		// if (password == null || password.length() == 0) {
		// this.addFieldError("password", "隢撓�PWD");
		// }
	}

	public Admin_Login_Action() {
	}
	public Admin_Login_Action(AdminUserDAOService adminUserDAOService) {
		this.adminUserDAOService=adminUserDAOService;
	}
	private AdminUserDAOService adminUserDAOService;// = new
													// adminUserDAOService();

	public void setAdminUserDAOService(AdminUserDAOService adminUserDAOService) {
		this.adminUserDAOService = adminUserDAOService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Admin_Login_Action Exception");
		System.out.println("username:"+username+",password:"+password);
		if(adminUserDAOService==null)
			System.out.println("adminUserDAOService==nul");
		AdminUserDAObean bean = adminUserDAOService.login(username, password);
		if (bean == null) {
			this.addFieldError("password", "登入失敗!!ID/PWD");
			return Action.INPUT;
		} else {
			sessionMap.put("user", bean);
			return Action.SUCCESS;
		}
	}
}
