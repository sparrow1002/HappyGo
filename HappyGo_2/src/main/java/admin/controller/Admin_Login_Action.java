package admin.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.AdminUserDAOService;
import admin.model.AdminUserDAObean;
import admin.model.RightDAOBean;
import admin.model.RightDAOService;
import admin.model.RoleDAOBean;
import admin.model.RoleDAOService;

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
		this.adminUserDAOService = adminUserDAOService;
	}

	private AdminUserDAOService adminUserDAOService;// = new
													// adminUserDAOService();

	public void setAdminUserDAOService(AdminUserDAOService adminUserDAOService) {
		this.adminUserDAOService = adminUserDAOService;
	}

	private RoleDAOService roleDAOService;

	public void setRoleDAOService(RoleDAOService roleDAOService) {
		this.roleDAOService = roleDAOService;
	}

	private RightDAOService rightDAOService;

	public void setRightDAOService(RightDAOService rightDAOService) {
		this.rightDAOService = rightDAOService;
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
		System.out.println("LOGIN ACTION");
		HttpServletRequest req = ServletActionContext.getRequest();
		String mode = req.getParameter("mode");
		System.out.println("mpde:"+mode);
		if(mode!=null && mode.equals("quit")){
			sessionMap.clear();
			System.out.println("QUIT");
			return "dayu";
		}
		if(sessionMap.containsKey("adminuser") && sessionMap.containsKey("adminuserright"))
			return Action.SUCCESS;
		System.out.println("Admin_Login_Action Exception");
		System.out.println("username:" + username + ",password:" + password);
		if (adminUserDAOService == null)
			System.out.println("adminUserDAOService==nul");
		AdminUserDAObean bean = adminUserDAOService.login(username, password);
		if (bean == null) {
			this.addFieldError("password", "登入失敗!!ID/PWD");
			return Action.INPUT;
		} else {
			sessionMap.put("adminuser", username);
			RoleDAOBean rbean = new RoleDAOBean();
			rbean.setROL_ROLEID(bean.getADM_ROLEID());
			Map<String, Map> right = new LinkedHashMap<String, Map>();
			// Map<String, Map> right_1 = new TreeMap<String, Map>();
			Map<String, String> rightitem = null;
			List<RoleDAOBean> rbeans = roleDAOService.select(rbean);
			String sIndex = "";
			String sGroupName = "";
			int i = 0;
			for (RoleDAOBean rbeanitem : rbeans) {
				RightDAOBean ribean = new RightDAOBean();
				ribean.setRIG_RIGHTID(rbeanitem.getROL_RIGHTID());
				ribean = rightDAOService.select(ribean);
				i = i++;
				if (sIndex == "") {
					sIndex = ribean.getRIG_RIGHTID().substring(0, 1);
					sGroupName = ribean.getRIG_DESC();
					rightitem = new LinkedHashMap<String, String>();
					//System.out.println("NEW MAP");
				}
				System.out.println("sGroupName:" + sGroupName);
				if (sIndex.equals(ribean.getRIG_RIGHTID().substring(0, 1))) {
					if (!rbeanitem.getROL_RIGHTID().contains("000"))
						rightitem.put(ribean.getRIG_DESC(),
								ribean.getRIG_FUNTION());
					
				}
				if (!sIndex.equals(ribean.getRIG_RIGHTID().substring(0, 1))) {					
					i = 0;					
					right.put(sGroupName, rightitem);
					sGroupName = ribean.getRIG_DESC();
					
					sIndex = ribean.getRIG_RIGHTID().substring(0, 1);
					rightitem = new LinkedHashMap<String, String>();
					if (!rbeanitem.getROL_RIGHTID().contains("000"))
						rightitem.put(ribean.getRIG_DESC(),
								ribean.getRIG_FUNTION());
					
				}
			}
			right.put(sGroupName, rightitem);
			sessionMap.put("adminuserright", right);
			System.out.println(right);
			return Action.SUCCESS;
		}
	}
}
