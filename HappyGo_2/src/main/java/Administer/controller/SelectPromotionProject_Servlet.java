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
		urlPatterns={"/PromotionProject/selectPromotionProject.controller"}
)
public class SelectPromotionProject_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HG_PromotionProject_Service PMOPJservice = new HG_PromotionProject_Service();
       
	//先做單一table，暫時只先處理HG_PromotionProject的欄位資料
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收HTML Form資料
		System.out.println("接收HTML Form資料");
		String PTP_PROJID = request.getParameter("PTP_PROJID");
		String PTP_NAME = request.getParameter("PTP_NAME");
		String PTP_CREATEDATE = request.getParameter("PTP_CREATEDATE");
		String PTP_DELDATE = request.getParameter("PTP_DELDATE");
		
		String promotionProject = request.getParameter("promotionProject");
		
		//轉換HTML Form資料，確認欄位是整數，轉換日期資料格式
		System.out.println("轉換HTML Form資料");
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
	
		int id = 0;
		if(PTP_PROJID!=null && PTP_PROJID.trim().length()!=0) {
			try {
				id = Integer.parseInt(PTP_PROJID.trim());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("id", "活動編號必須是整數");
			}
		}
		//日期將MM/dd/yyyy調整為MMddyyyy
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
		//輸入ID，就查ID。尚未處理防呆，Demo時輸入A欄位就不要輸入B欄位避免error
		//輸入名稱，就查名稱。
		//輸入日期，就查日期。
		//都不輸入，就查全部。
		
		System.out.println("驗證HTML Form資料");
		if(error!=null && !error.isEmpty()) {
			request.getRequestDispatcher(
					"/administer/PromotionProject/selectProj.jsp").forward(request, response);
			return;
		}
		//呼叫Model
		System.out.println("呼叫Model");
		HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
		bean.setPTP_PROJID(id);
		bean.setPTP_NAME(PTP_NAME);
		bean.setPTP_CREATEDATE(StartDate);
		bean.setPTP_DELDATE(EndDate);
		
		//根據Model執行結果顯示View
		System.out.println("根據Model執行結果顯示View");
		if("select".equals(promotionProject)) {
			List<HG_PromotionProject_Bean> result = PMOPJservice.select(bean);
//			HG_PromotionProject_Bean result = (HG_PromotionProject_Bean) PMOPJservice.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/administer/PromotionProject/display.jsp").forward(request, response);
		} else  {
			error.put("action", "Unknown Action:"+promotionProject);
			request.getRequestDispatcher(
					"/administer/PromotionProject/selectProj.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
