package Administer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conStore.model.PProjectStoreBean;
import conStore.model.dao.PProjectStoreDAOJdbc;

@WebServlet(
		urlPatterns={"/PromotionProject/PromotionStore.controller"}
)
public class projChoiceStore_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收HTML Form資料
		//思考如何接多筆name=${row.cos_storeid}
		//<!-- 目前跳著勾選店面會有問題 -->
		String PTP_PROJID = request.getParameter("PTP_PROJID");
		String member[] = request.getParameterValues("member");
		System.out.println(member.length);
		System.out.println("projChoiceStore_Servlet PTP_PROJID="+PTP_PROJID);
		//cos_storeid的資料，由於可能會有1~多筆，必須用while迴圈+陣列處理
		int j=0;
		while(request.getParameter("cos_storeid"+j)!=null){
			j++;
		}
		String cos_storeid[] = new String[member.length];
		
		int int_PTP_PROJID = 0;
		int_PTP_PROJID = Integer.parseInt(PTP_PROJID.trim());
		
		List<PProjectStoreBean> beanlists = new ArrayList<PProjectStoreBean>();
		int i = 0;
		for(i=0;i<=member.length;i++){
			if(request.getParameter("cos_storeid"+i)!=null){
				PProjectStoreBean bean = new PProjectStoreBean();
				bean.setPps_projid(int_PTP_PROJID);
				cos_storeid[i]=request.getParameter("cos_storeid"+i);
				bean.setPps_storeid(cos_storeid[i]);
				beanlists.add(bean);
				System.out.println(i);
			}
		}
		
		String proChoiceStore = request.getParameter("proChoiceStore");
		
		//轉換HTML Form資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		
//		int int_PTP_PROJID = 0;
//		int_PTP_PROJID = Integer.parseInt(PTP_PROJID.trim());
		
		//驗證HTML Form資料
		//都沒選擇店家，要提醒使用者選擇
		if("Insert".equals(proChoiceStore)){
			if(beanlists.isEmpty()) {
			error.put("noStore", "請至少選擇一個店家");
			}
		}
		
		//有error，回選擇店家頁面
		if(error!=null && !error.isEmpty()) {
			request.getRequestDispatcher(
					"/Administer/PromotionProject/projChoiceStore.jsp").forward(request, response);
			return;
		}
		
		//呼叫Model
		List<PProjectStoreBean> beanlist = new ArrayList<>();
		for(i=0; i<member.length;i++){
		PProjectStoreBean bean = new PProjectStoreBean();
		bean.setPps_projid(int_PTP_PROJID);
		bean.setPps_storeid(cos_storeid[i]);
		beanlist.add(bean);
		}
		
		//根據Model執行結果顯示View
		PProjectStoreDAOJdbc dao = new PProjectStoreDAOJdbc();
		if(proChoiceStore!=null && proChoiceStore.equals("Insert")) {
			int[] result = dao.insert(beanlists);
			if(result==null) {
				error.put("action", "Insert fail");
			} else {
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher(
					"/Administer/PromotionProject/index.jsp").forward(request, response);
		} else {
			error.put("action", "Unknown Action:"+proChoiceStore);
			request.getRequestDispatcher(
					"/Administer/PromotionProject/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
