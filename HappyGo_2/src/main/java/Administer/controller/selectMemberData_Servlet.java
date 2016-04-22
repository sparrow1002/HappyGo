package Administer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AAA000.DayDevice;
import model.CustomerBean;
import model.dao.CustomerDAOJdbc;

@WebServlet("/Administer/selectMemberData.controller")
public class selectMemberData_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//接收HTML Form資料
		String MBR_MEMBERID = request.getParameter("MBR_MEMBERID");
		String selectMemberData = request.getParameter("selectMemberData");
		//轉換HTML Form資料
		//驗證HTML Form資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		
		if(MBR_MEMBERID==null || MBR_MEMBERID.trim().length()==0) {
			error.put("id", "請輸入編號");
		}
		
		if(error!=null && !error.isEmpty()) {
			request.getRequestDispatcher(
					"/Administer/selectMemberData/selectMemberData.jsp").forward(request, response);
			return;
		}
		//呼叫Model
		//根據Model執行結果顯示View
		CustomerDAOJdbc dao = new CustomerDAOJdbc();
		CustomerBean bean = new CustomerBean();
		bean = dao.select(MBR_MEMBERID);
		
		if("select".equals(selectMemberData)) {
		if(bean!=null){
			//yyyyMMdd-->yyyy/MM/dd
			DayDevice day1 = new DayDevice();
			if(bean.getMBR_BIRTHDAY()!=null && bean.getMBR_BIRTHDAY().length()>0){
				bean.setMBR_BIRTHDAY(day1.parse_DBtoWeb(bean.getMBR_BIRTHDAY()));
			}
			
				request.setAttribute("select", bean);
				request.getRequestDispatcher(
						"/Administer/selectMemberData/selectMemberData.jsp").forward(request, response);
		}else{
			error.put("MBR_MEMBERID", "查無該資料");
			request.getRequestDispatcher(
					"/Administer/selectMemberData/selectMemberData.jsp").forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
