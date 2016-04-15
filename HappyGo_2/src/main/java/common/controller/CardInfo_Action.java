package common.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import admin.model.AdminUserDAOService;
import admin.model.AdminUserDAObean;
import admin.model.DataProfileDAOBean;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import common.model.CardInfoDAOBean;
import common.model.CardInfoDAOService;

public class CardInfo_Action extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private String CDI_CardID;
	private String CDI_CardName;
	private String CDI_CardInfo;
	private byte[] CDI_IMG;

	public String getCDI_CardID() {
		return CDI_CardID;
	}

	public void setCDI_CardID(String cDI_CardID) {
		CDI_CardID = cDI_CardID;
	}

	public String getCDI_CardName() {
		return CDI_CardName;
	}

	public void setCDI_CardName(String cDI_CardName) {
		CDI_CardName = cDI_CardName;
	}

	public String getCDI_CardInfo() {
		return CDI_CardInfo;
	}

	public void setCDI_CardInfo(String cDI_CardInfo) {
		CDI_CardInfo = cDI_CardInfo;
	}

	public byte[] getCDI_IMG() {
		return CDI_IMG;
	}

	public void setCDI_IMG(byte[] cDI_IMG) {
		CDI_IMG = cDI_IMG;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	private CardInfoDAOService cardInfoDAOService;

	public void setCardInfoDAOService(CardInfoDAOService cardInfoDAOService) {
		this.cardInfoDAOService = cardInfoDAOService;
	}
	
	public String execute() throws Exception {
		System.out.println("execute");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String mode = req.getParameter("mode");
			
		if ("select".equals(mode)) {
			List<CardInfoDAOBean> result;
			result = cardInfoDAOService.select();
			if (result == null) {
				System.out.println("select fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("select ok");
				req.setAttribute("select", result);
				return Action.SUCCESS;
			}
		} else if ("selectitem".equals(mode)) {
			CardInfoDAOBean result;
			CardInfoDAOBean bean =new CardInfoDAOBean();
			bean.setCDI_CardID(CDI_CardID);
			result = cardInfoDAOService.select(bean);
			req.setAttribute("selectitem", result);
			List<CardInfoDAOBean> results=cardInfoDAOService.select();
			if (results == null) {
				System.out.println("selectitem fail");
				this.addFieldError("action", "Insert fail");
			} else {
				System.out.println("selectitem ok");
				req.setAttribute("select", results);				
			}
		}
		System.out.println("final");
		return Action.SUCCESS;
	}
}
