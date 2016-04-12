package Administer.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Administer.model.HG_PromotionProject_Bean;
import Administer.model.HG_PromotionProject_Service;

@WebServlet(
		urlPatterns={"/PromotionProject/PromotionProject.controller"}
)
public class PromotionProject_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HG_PromotionProject_Service projectservice = new HG_PromotionProject_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//先做單一table，暫時只先處理HG_PromotionProject的欄位資料
		
		//接收HTML Form資料
		//HG_PromotionProject的欄位資料
		System.out.println("Servlet");
				String PTP_PROJID = request.getParameter("PTP_PROJID");
				String PTP_NAME = request.getParameter("PTP_NAME");
				String PTP_DESC = request.getParameter("PTP_DESC");
				String PTP_STATUS = request.getParameter("PTP_STATUS");
				String PTP_CREATEDATE = request.getParameter("PTP_CREATEDATE");
				String PTP_DELDATE = request.getParameter("PTP_DELDATE");
				
				String PTB_VALUE = request.getParameter("PTB_VALUE");
				String PTB_POINT = request.getParameter("PTB_POINT");
				
				String PTM_VALUE = request.getParameter("PTM_VALUE");
				String PTM_POINT = request.getParameter("PTM_POINT");
				
				String PPS_STORGPID = request.getParameter("PPS_STORGPID");
				String PPS_STOREID = request.getParameter("PPS_STOREID");
				
				String promotionProject = request.getParameter("promotionProject");
				
				//轉換HTML Form資料，確認欄位是整數，日期是數字組成的字串
				Map<String, String> error = new HashMap<String, String>();
				request.setAttribute("error", error);
							
//				活動狀態開啟，有勾=1，沒勾=0的處理
				String PTP_STATUS_ID = "1";
				if(PTP_STATUS==null){
					PTP_STATUS_ID = "0";
				}
				else{
					PTP_STATUS_ID = "1";
				}
				
				int id = 0;
				if(PTP_PROJID!=null && PTP_PROJID.trim().length()!=0) {
					try {
						id = Integer.parseInt(PTP_PROJID.trim());
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("id", "Id必須是整數");
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
				HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
				bean.setPTP_PROJID(id);
				bean.setPTP_NAME(PTP_NAME);
				bean.setPTP_DESC(PTP_DESC);
				bean.setPTP_STATUS(PTP_STATUS_ID);
				bean.setPTP_CREATEDATE(StartDate);
				bean.setPTP_DELDATE(EndDate);
//				bean內共10個屬性，這邊設定了5個
				
				//根據Model執行結果顯示View
				if("Select".equals(promotionProject)) {
					List<HG_PromotionProject_Bean> result = projectservice.select(bean);
					request.setAttribute("select", result);
					request.getRequestDispatcher(
							"/pages/display.jsp").forward(request, response);
				} else if(promotionProject!=null && promotionProject.equals("Insert")) {
					int result = 0;
					result = projectservice.insert(bean);
					if(result==0) {
						error.put("action", "Insert fail");
					} else {
						request.setAttribute("insert", result);
					}
					request.getRequestDispatcher(
							"/Administer/PromotionProject/index.jsp").forward(request, response);
				} else if(promotionProject!=null && promotionProject.equals("Update")) {
					int result = 0;
					result = projectservice.update(bean);
					if(result==0) {
						error.put("action", "Update fail");
					} else {
						request.setAttribute("update", result);
					}
					request.getRequestDispatcher(
							"/Administer/PromotionProject/index.jsp").forward(request, response);
				}
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
