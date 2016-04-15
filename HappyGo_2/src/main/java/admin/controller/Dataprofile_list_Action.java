package admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.DataProfileDAOBean;
import admin.model.DataProfileDAOService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Dataprofile_list_Action extends ActionSupport implements
		SessionAware {
	private Map<String, Object> sessionMap;
	private String DAP_GROUP;
	private String DAP_ID;
	private String DAP_VALUE;
	private String DAP_DESC;

	public String getDAP_GROUP() {
		return DAP_GROUP;
	}

	public void setDAP_GROUP(String dAP_GROUP) {
		DAP_GROUP = dAP_GROUP;
	}

	public String getDAP_ID() {
		return DAP_ID;
	}

	public void setDAP_ID(String dAP_ID) {
		DAP_ID = dAP_ID;
	}

	public String getDAP_VALUE() {
		return DAP_VALUE;
	}

	public void setDAP_VALUE(String dAP_VALUE) {
		DAP_VALUE = dAP_VALUE;
	}

	public String getDAP_DESC() {
		return DAP_DESC;
	}

	public void setDAP_DESC(String dAP_DESC) {
		DAP_DESC = dAP_DESC;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}

	private DataProfileDAOService dataProfileDAOService;

	public void setDataProfileDAOService(
			DataProfileDAOService dataProfileDAOService) {
		this.dataProfileDAOService = dataProfileDAOService;
	}

	private DataProfileDAOBean checkkeyin() {
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

		DataProfileDAOBean bean = new DataProfileDAOBean();
		System.out.println("(1)"+DAP_GROUP+","+DAP_ID+","+DAP_VALUE+","+DAP_DESC);
		bean.setDAP_GROUP(DAP_GROUP);
		bean.setDAP_ID(DAP_ID);
		System.out.println("DAP_ID:" + DAP_ID);
		bean.setDAP_VALUE(DAP_VALUE);
		bean.setDAP_DESC(DAP_DESC);
		
		bean.setDAP_UPDATEUSER(sessionMap.get("adminuser").toString());
		return bean;
	}

	public String execute() throws Exception {
		System.out.println("execute");
		DataProfileDAOBean bean = checkkeyin();
		HttpServletRequest req = ServletActionContext.getRequest();
		String mode = req.getParameter("mode");

		// System.out.println("mode:" + mode);
		if ("select".equals(mode)) {
			List<DataProfileDAOBean> result;
			System.out.println("DAP_GROUP:" + DAP_GROUP);
			if (DAP_GROUP != null && !DAP_GROUP.equals(""))
				result = dataProfileDAOService.select(bean);
			else
				result = dataProfileDAOService.select(null);
			if (result == null) {
				System.out.println("select fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("select ok");
				req.setAttribute("select", result);
				return Action.SUCCESS;
			}
		} else if ("selectitem".equals(mode)) {
			DataProfileDAOBean result;
			List<DataProfileDAOBean> results;
			System.out.println("DAP_GROUP" + DAP_GROUP);
			System.out.println("DAP_ID" + DAP_ID);
			result = dataProfileDAOService.selectitems(bean);

			if (result == null) {
				System.out.println("selectitem fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("selectitem ok");
				req.setAttribute("selectitem", result);			
			}
		} else if ("newitem".equals(mode)) {	
			System.out.println("newitem ok");
			System.out.println(bean);
			req.setAttribute("newitem", bean);		
		} else if ("insert".equals(mode)) {
			
			DataProfileDAOBean result = dataProfileDAOService.insert(bean);
			System.out.println(bean.getDAP_GROUP()+","+bean.getDAP_ID()+","+bean.getDAP_VALUE()+","+bean.getDAP_DESC());
			if (result == null) {
				req.setAttribute("message", "資料新增失敗!!");
				this.addFieldError("action", "Insert fail");
			} else {
				req.setAttribute("message", "資料新增成功!!");
				req.setAttribute("insert", result);
			}
		}
		else if ("update".equals(mode)) {
			DataProfileDAOBean result = dataProfileDAOService.update(bean);
			if (result == null) {
				System.out.println("update fail");
				this.addFieldError("action", "Insert fail");
				req.setAttribute("message", "資料更新失敗!!");
			} else {
				System.out.println("update ok");
				req.setAttribute("message", "資料更新成功!!");
			}
		}
		else if ("edit".equals(mode)) {
			bean.setDAP_GROUP(DAP_GROUP);
			bean.setDAP_ID(DAP_ID);
			List<DataProfileDAOBean> results;
			DataProfileDAOBean result;
			result = dataProfileDAOService.selectitems(bean);

			if (result == null) {
				System.out.println("update fail");
				this.addFieldError("action", "update fail");
			} else {
				
				req.setAttribute("edit", result);
			}
		}
		List<DataProfileDAOBean> results = dataProfileDAOService.select(null);
		req.setAttribute("select", results);
		System.out.println("final");
		return Action.SUCCESS;
	}
}
