package admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.DataProfileDAOBean;
import admin.model.DataProfileDAOService;
import admin.model.RightDAOBean;
import admin.model.RightDAOService;
import admin.model.RoleDAOBean;
import admin.model.RoleDAOService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Role_list_Action extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private String ROL_ROLEID;
	private String ROL_RIGHTID;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}

	private RightDAOService rightDAOService;
	private RoleDAOService roleDAOService;
	private DataProfileDAOService dataProfileDAOService;

	public void setDataProfileDAOService(
			DataProfileDAOService dataProfileDAOService) {
		this.dataProfileDAOService = dataProfileDAOService;
	}

	public void setRightDAOService(RightDAOService rightDAOService) {
		this.rightDAOService = rightDAOService;
	}

	public void setRoleDAOService(RoleDAOService roleDAOService) {
		this.roleDAOService = roleDAOService;
	}

	public String execute() throws Exception {
		System.out.println("execute");
		// RightDAOBean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mode = req.getParameter("mode");
		DataProfileDAOBean beans = new DataProfileDAOBean();
		beans.setDAP_GROUP("ROLEID");
		List<RoleDAOBean> result = roleDAOService.selectall();
		List<RightDAOBean> result2 = rightDAOService.select();
		Map<String, String> result3 = dataProfileDAOService.selects(beans);
		System.out.println(result3.size());
		req.setAttribute("userlist", result3);
		req.setAttribute("message","");
		System.out.println("mode:" + mode);
		if ("select".equals(mode)) {
			System.out.println("select:");
			result = roleDAOService.selectall();
			System.out.println("right:" + result2);
			if (result == null) {
				System.out.println("select fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("select ok");
				req.setAttribute("rolelist", result);
				req.setAttribute("right", result2);
				return Action.SUCCESS;
			}
		} else if ("edit".equals(mode)) {

			RoleDAOBean roleDAObean = new RoleDAOBean();
			String user = req.getParameter("userid");
			System.out.println("user" + user);
			roleDAObean.setROL_ROLEID(user);
			System.out.println("edit ready to delete!!");
			boolean ssss = roleDAOService.delete(roleDAObean);
			System.out.println(result2);
			List<RoleDAOBean> newbean = new ArrayList<RoleDAOBean>();
			for (RightDAOBean bean : result2) {
				System.out.println("RIGHTI:" + bean.getRIG_RIGHTID());

				RoleDAOBean beanitem;
				String ss = req.getParameter(bean.getRIG_RIGHTID());
				System.out.println("RightDAOBean:" + ss);
				if (ss != null) {
					System.out.println("add");
					beanitem = new RoleDAOBean();
					beanitem.setROL_ROLEID(user);
					beanitem.setROL_RIGHTID(bean.getRIG_RIGHTID());
					beanitem.setROL_UPDATEUSER("dayu");
					newbean.add(beanitem);
				}
			}
			System.out.println("edit ready to insert!!");
			System.out.println(newbean);
			if (newbean != null && newbean.size() > 0) {
				
				if (roleDAOService.insert(newbean)) {
					System.out.println("to insert");
					if (result == null) {
						System.out.println("select fail");
						this.addFieldError("action", "Insert fail");
					} else {
						System.out.println("select ok");
						req.setAttribute("rolelist", result);
						req.setAttribute("right", result2);
					}
					req.setAttribute("message", "權限更新完成!!");
				} else {
					System.out.println("to insert");
					if (result == null) {
						System.out.println("select fail");
						this.addFieldError("action", "Insert fail");
					} else {
						System.out.println("select ok");
						req.setAttribute("rolelist", result);
						req.setAttribute("right", result2);
					}
					req.setAttribute("message", "權限更新失敗!!");
				}
			}

			return Action.SUCCESS;
		}
		System.out.println("final");
		return Action.INPUT;
	}
}
