package admin.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.AdminUserDAOService;
import admin.model.AdminUserDAObean;
import admin.model.DataProfileDAOBean;
import admin.model.DataProfileDAOService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Admin_list_Action extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private String ADM_ID;
	private String ADM_PWD;
	private String ADM_NAME;
	private String ADM_ROLEID;

	public String getADM_ID() {
		return ADM_ID;
	}

	public void setADM_ID(String ADM_ID) {
		this.ADM_ID = ADM_ID;
	}

	public String getADM_PWD() {
		return ADM_PWD;
	}

	public void setADM_PWD(String aDM_PWD) {
		ADM_PWD = aDM_PWD;
	}

	public String getADM_NAME() {
		return ADM_NAME;
	}

	public void setADM_NAME(String ADM_NAME) {
		this.ADM_NAME = ADM_NAME;
	}

	public String getADM_ROLEID() {
		return ADM_ROLEID;
	}

	public void setADM_ROLEID(String aDM_ROLEID) {
		ADM_ROLEID = aDM_ROLEID;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}

	private AdminUserDAOService adminUserDAOService;

	public void setAdminUserDAOService(AdminUserDAOService adminUserDAOService) {
		this.adminUserDAOService = adminUserDAOService;
	}

	private DataProfileDAOService dataProfileDAOService;

	public void setDataProfileDAOService(
			DataProfileDAOService dataProfileDAOService) {
		this.dataProfileDAOService = dataProfileDAOService;
	}

	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	private AdminUserDAObean checkkeyin() {
		// int iID = 0;
		// if (id != null && id.trim().length() != 0) {
		// try {
		// iID = Integer.parseInt(id.trim());
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// System.out.println("id error");
		// this.addFieldError("id", "Id敹���");
		// }
		// }
		//
		// double dPrice = 0;
		// if (price != null && price.trim().length() != 0) {
		// try {
		// dPrice = Double.parseDouble(price.trim());
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// System.out.println("price error");
		// this.addFieldError("price", "Price敹��摮�");
		// }
		// }
		// java.util.Date dtMake = null;
		// if (make != null && make.trim().length() != 0) {
		// try {
		// dtMake = sFormat.parse(make.trim());
		// } catch (ParseException e) {
		// e.printStackTrace();
		// System.out.println("make error");
		// this.addFieldError("make", "Make敹�����撘YYYY-MM-DD");
		// }
		// }
		// int iExpire = 0;
		// if (expire != null && expire.trim().length() != 0) {
		// try {
		// iExpire = Integer.parseInt(expire.trim());
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// System.out.println("expire error");
		// this.addFieldError("expire", "Expire敹���");
		// }
		// }
		
		AdminUserDAObean bean = new AdminUserDAObean();
		System.out.println("ADM_ID");
		bean.setADM_ID(ADM_ID);
		bean.setADM_NAME(ADM_NAME);
		bean.setADM_PWD(ADM_PWD);
		bean.setADM_ROLEID(ADM_ROLEID);
		bean.setADM_UPDATEUSER(sessionMap.get("adminuser").toString());
		return bean;
	}

	public String execute() throws Exception {
		System.out.println("execute");
		AdminUserDAObean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mode = req.getParameter("mode");
		DataProfileDAOBean beans = new DataProfileDAOBean();
		beans.setDAP_GROUP("ROLEID");
		List<DataProfileDAOBean> dataprofileresult;
		dataprofileresult = dataProfileDAOService.select(beans);
		System.out.println(dataprofileresult);
		req.setAttribute("roleid", dataprofileresult);
		// System.out.println("mode:" + mode);
		if ("select".equals(mode)) {
			List<AdminUserDAObean> result;
			System.out.println("ADM_ID:" + ADM_ID);
			if (ADM_ID != null && !ADM_ID.equals(""))
				result = adminUserDAOService.select(bean);
			else
				result = adminUserDAOService.select(null);
			if (result == null) {
				System.out.println("select fail");
				this.addFieldError("action", "Insert fail");
			} else {
//				DataProfileDAOBean dbean	=new DataProfileDAOBean();
//				for(AdminUserDAObean beanitem:result){
//					dbean.setDAP_GROUP("ROLEID");
//					dbean.setDAP_ID(beanitem.getADM_ROLEID());
//					beanitem.setADM_ROLEID(dataProfileDAOService.selectitem(dbean));
//				}
				System.out.println("select ok");
				req.setAttribute("select", result);
				return Action.SUCCESS;
			}
		} else if ("selectitem".equals(mode)) {
			List<AdminUserDAObean> result;
			// System.out.println(ADM_ID);
			if (ADM_ID != null && ADM_ID.trim() != "")
				result = adminUserDAOService.select(bean);
			else
				result = adminUserDAOService.select(null);
			if (result == null) {
				System.out.println("selectitem fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("selectitem ok");
				req.setAttribute("selectitem", result.get(0));
				result = adminUserDAOService.select(null);
				req.setAttribute("select", result);
				return Action.SUCCESS;
			}
		} else if ("insert".equals(mode)) {
			AdminUserDAObean result = adminUserDAOService.insert(bean);
			if (bean == null) {
				System.out.println("insert fail");
				this.addFieldError("action", "insert fail");
				req.setAttribute("message", "insert fail");
			} else {
				req.setAttribute("message", "insert ok");				
			}
			List<AdminUserDAObean> results;
			results = adminUserDAOService.select(null);
			req.setAttribute("select", results);
		} else if ("update".equals(mode)) {
			System.out.println("action:"+bean.getADM_PWD()+","+bean.getADM_NAME()+","+
					bean.getADM_ROLEID()+","+bean.getADM_UPDATEUSER()+","+bean.getADM_ID()+",");
			bean = adminUserDAOService.update(bean);			
			if (bean == null) {
				System.out.println("update fail");
				this.addFieldError("action", "update fail");
				req.setAttribute("message", "update fail");
			} else {
				req.setAttribute("message", "update ok");				
			}
			List<AdminUserDAObean> result;
			result = adminUserDAOService.select(null);
			req.setAttribute("select", result);
		}
		System.out.println("final");
		return Action.INPUT;
	}

}
