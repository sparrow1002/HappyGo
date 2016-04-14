package Administer.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Administer.model.HG_PromotionBonus_Bean;
import Administer.model.HG_PromotionBonus_Service;
import Administer.model.HG_PromotionMethod_Bean;
import Administer.model.HG_PromotionMethod_Service;
import Administer.model.HG_PromotionProject_Bean;
import Administer.model.HG_PromotionProject_Service;

@WebServlet(
		urlPatterns={"/PromotionProject/PromotionProject.controller"}
)
public class PromotionProject_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HG_PromotionProject_Service projectservice = new HG_PromotionProject_Service();
    private HG_PromotionBonus_Service prombnsservice = new HG_PromotionBonus_Service();
    private HG_PromotionMethod_Service prommthservice = new HG_PromotionMethod_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("PromotionProject_Servlet Servlet_doGet");
		//接收HTML Form資料
		//HG_PromotionProject的欄位資料
				String PTP_PROJID = request.getParameter("PTP_PROJID");
				String PTP_NAME = request.getParameter("PTP_NAME");
				String PTP_DESC = request.getParameter("PTP_DESC");
				String PTP_STATUS = request.getParameter("PTP_STATUS");
				String PTP_CREATEDATE = request.getParameter("PTP_CREATEDATE");
				String PTP_DELDATE = request.getParameter("PTP_DELDATE");
				String PTP_FOREVER = request.getParameter("PTP_FOREVER");
				String str_PTP_FIXPOINT = request.getParameter("PTP_FIXPOINT");
	
		//HG_PromotionBonus的欄位資料	
				String str_PTB_VALUE = request.getParameter("PTB_VALUE");
				String str_PTB_POINT = request.getParameter("PTB_POINT");
				
		//HG_PromotionMethod的欄位資料
				String PTM_model = request.getParameter("PTM_model");
				String PTM_NAME = request.getParameter("PTM_NAME");
				String PTM_VALUE = request.getParameter("PTM_VALUE");
				String str_PTM_VARDATE = request.getParameter("PTM_VARDATE");
				
		//HG_特約店的欄位資料
				
				String PPS_STORGPID = request.getParameter("PPS_STORGPID");
				String PPS_STOREID = request.getParameter("PPS_STOREID");
				
		//submit buttom(insert or update)
				String promotionProject = request.getParameter("promotionProject");
				
				//轉換HTML Form資料
				Map<String, String> error = new HashMap<String, String>();
				request.setAttribute("error", error);
				
				//轉換HG_PromotionBonus的欄位資料
				int int_PTM_VARDATE = 0;
				int_PTM_VARDATE = Integer.parseInt(str_PTM_VARDATE.trim());
				
				//轉換HG_PromotionBonus的欄位資料
				int int_PTB_VALUE = 0;
				int int_PTB_POINT = 0;
				int_PTB_VALUE = Integer.parseInt(str_PTB_VALUE.trim());
				int_PTB_POINT = Integer.parseInt(str_PTB_POINT.trim());
				
				//轉換HG_PromotionProject的欄位資料
							
				//活動狀態開啟，有勾=1，沒勾=0的處理
				String PTP_STATUS_ID = "1";
				if(PTP_STATUS==null){
					PTP_STATUS_ID = "0";
				}
				else{
					PTP_STATUS_ID = "1";
				}
				
				//好像哪裡怪怪der~?
				int id = 0;
				if(PTP_PROJID!=null && PTP_PROJID.trim().length()!=0) {
					try {
						id = Integer.parseInt(PTP_PROJID.trim());
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("pTP_PROJID", "活動編號必須是整數");
					}
				}
				
				//將PTP_FIXPOINT從String轉int且驗證
				int int_PTP_FIXPOINT = 0;
				if(str_PTP_FIXPOINT!=null && str_PTP_FIXPOINT.trim().length()!=0) {
					try {
						int_PTP_FIXPOINT = Integer.parseInt(str_PTP_FIXPOINT.trim());
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("pTP_FIXPOINT", "紅利點數必須是整數");
					}
				}
				
				//日期將yyyy/MM/dd調整為yyyyMMdd
				String StartDate = "";
				String[] aArray1 = PTP_CREATEDATE.split("/");
				for (String d : aArray1) {
					StartDate = StartDate +d;
					        }
				String EndDate ="";
				String[] aArray2 = PTP_DELDATE.split("/");
				for (String d : aArray2) {
					EndDate = EndDate +d;
					        }
				//活動時間(永久)有勾選，給一個很久的時間2001~2099年
				if(PTP_FOREVER!=null){
					StartDate = "20010101";
					EndDate = "20991231";
				}
					
				//驗證HTML Form資料
				if("Update".equals(promotionProject)) {
					if(PTP_PROJID==null || PTP_PROJID.trim().length()==0) {
						error.put("pTP_PROJID", "請輸入活動編號以便於執行"+promotionProject);
					}
				}
				
				if("Insert".equals(promotionProject) || "Update".equals(promotionProject)) {
					if(PTP_NAME==null || PTP_NAME.trim().length()==0) {
						error.put("pTP_NAME", "請輸入活動名稱以便於執行"+promotionProject);
					}
				}
				
				if(error!=null && !error.isEmpty()) {
					if(error.get("pTP_PROJID")!=null){
						request.getRequestDispatcher(
								"/Administer/PromotionProject/updateProj.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher(
								"/Administer/PromotionProject/insertProj.jsp").forward(request, response);
					return;
					}
				}
				
				//呼叫Model
//				HG_PromotionProject_Bean內共10個屬性，這邊設定了7個
				HG_PromotionProject_Bean promprojbean = new HG_PromotionProject_Bean();
				promprojbean.setPTP_PROJID(id);
				promprojbean.setPTP_NAME(PTP_NAME);
				promprojbean.setPTP_DESC(PTP_DESC);
				promprojbean.setPTP_STATUS(PTP_STATUS_ID);
				promprojbean.setPTP_CREATEDATE(StartDate);
				promprojbean.setPTP_DELDATE(EndDate);
				promprojbean.setPTP_FIXPOINT(int_PTP_FIXPOINT);
				
				//HG_PromotionBonus_Bean
				HG_PromotionBonus_Bean prombnsbean = new HG_PromotionBonus_Bean();
				prombnsbean.setPTB_POINT(int_PTB_POINT);
				prombnsbean.setPTB_VALUE(int_PTB_VALUE);
				List<HG_PromotionBonus_Bean> prombnsbeanlist = new ArrayList<>();
				prombnsbeanlist.add(prombnsbean);
				
				//HG_PromotionMethod_Bean
				HG_PromotionMethod_Bean prommtbean = new HG_PromotionMethod_Bean();		
				prommtbean.setPTM_model(PTM_model);
				prommtbean.setPTM_NAME(PTM_NAME);
				prommtbean.setPTM_VALUE(PTM_VALUE);
				prommtbean.setPTM_VARDATE(int_PTM_VARDATE);
				List<HG_PromotionMethod_Bean> prommtbeanlist = new ArrayList<>();
				prommtbeanlist.add(prommtbean);
				
				//根據Model執行結果顯示View
				if("Select".equals(promotionProject)) {
					List<HG_PromotionProject_Bean> result = projectservice.select(promprojbean);
					request.setAttribute("select", result);
					request.getRequestDispatcher(
							"/pages/display.jsp").forward(request, response);
				} else if(promotionProject!=null && promotionProject.equals("Insert")) {
					int proj_result = 0;
					int projbns_result = 0;
					int prommt_result = 0;
					proj_result = projectservice.insert(promprojbean);
					projbns_result = prombnsservice.insert(prombnsbeanlist);
					prommt_result = prommthservice.insert(prommtbeanlist);
					if(proj_result==0 && projbns_result==0 && prommt_result==0) {
						error.put("action", "Insert fail");
					} else {
						request.setAttribute("insert", proj_result);
					}
					request.getRequestDispatcher(
							"/Administer/PromotionProject/index.jsp").forward(request, response);
				} else if(promotionProject!=null && promotionProject.equals("Update")) {
					int proj_result = 0;
					int projbns_result = 0;
					int prommt_result = 0;
					proj_result = projectservice.update(promprojbean);
					projbns_result = prombnsservice.update(prombnsbeanlist);
					prommt_result = prommthservice.insert(prommtbeanlist);
					if(proj_result==0 && projbns_result==0 && prommt_result==0) {
						error.put("action", "Update fail");
					} else {
						request.setAttribute("update", proj_result);
					}
					request.getRequestDispatcher(
							"/Administer/PromotionProject/index.jsp").forward(request, response);
				}
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
