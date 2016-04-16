package Administer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;

@WebServlet(
		urlPatterns={"/PromotionProject/PromotionStore.controller"}
)
public class projChoiceStore_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收HTML Form資料
		//思考如何接多筆name=${row.cos_storeid}
		String PTP_PROJID = request.getParameter("PTP_PROJID");
		
		String prodaction = request.getParameter("prodaction");
		
		//轉換HTML Form資料
		//不太需要轉換，因為都是勾選+submit
		
		//驗證HTML Form資料
		//都沒選擇店家，要提醒使用者選擇
		if(error!=null && !error.isEmpty()) {
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
			return;
		}
		
		//呼叫Model
		//都沒選擇店家，回到projChoiceStore
		//有選擇一家以上，回到首頁，告知success
		if("Select".equals(prodaction)) {
			List<ProductBean> result = productService.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/pages/display.jsp").forward(request, response);
		} else if(prodaction!=null && prodaction.equals("Insert")) {
			ProductBean result = productService.insert(bean);
			if(result==null) {
				error.put("action", "Insert fail");
			} else {
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
		} else if(prodaction!=null && prodaction.equals("Update")) {
			ProductBean result = productService.update(bean);
			if(result==null) {
				error.put("action", "Update fail");
			} else {
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
		} else if(prodaction!=null && prodaction.equals("Delete")) {
			boolean result = productService.delete(bean);
			if(!result) {
				request.setAttribute("delete", 0);
			} else {
				request.setAttribute("delete", 1);
			}
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
		} else  {
			error.put("action", "Unknown Action:"+prodaction);
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
