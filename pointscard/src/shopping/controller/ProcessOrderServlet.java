package shopping.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.model.CustomerBean;
import products.model.MyOrderItemBean;
import shoppingCart.model.ShoppingCart;
import shoppingCart.model.ShoppingOrderDAOJDBC;
import shoppingCart.model.SingleOrderBean;
import shoppingCart.model.TotalOrderItem;

// OrderConfirm.jsp 呼叫本程式
@WebServlet("/ShoppingCart/ProcessOrder.do")
public class ProcessOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		
		String finalDecision = request.getParameter("finalDecision");		
		HttpSession session = request.getSession(false);
		if (session == null) {   // 使用逾時
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp"  );
			return;
		}
		CustomerBean mb = (CustomerBean) session.getAttribute("LoginOK");
		if (mb == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp"  );
			return;
		}
		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (sc == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp"  );
			return;
		}
		if  (finalDecision.equals("CANCEL")){
			session.removeAttribute("ShoppingCart");
			response.sendRedirect(response.encodeRedirectURL (request.getContextPath()));
			return;  // 一定要記得 return 
		}
		
		String mBR_MEMBERID = mb.getMBR_MEMBERID();
		double oRD_totalAmount = Math.round(sc.getSubtotal()); 
		String oRD_shippingAddress = request.getParameter("ShippingAddress");
//		String bNO = request.getParameter("BNO");
		String oRD_descriptions = request.getParameter("description");
		Date today = (Date)session.getAttribute("today");
		List<TotalOrderItem> items = new ArrayList<TotalOrderItem>(); 
		Map<String, MyOrderItemBean> cart = sc.getContent();
		Set<String> set = cart.keySet();
		
		for (String k : set) {
			MyOrderItemBean oib = cart.get(k);
			String productName =  oib.getPD_name();
//			TotalOrderItem oiDAO = new TotalOrderItem(0, 0, oib.getBookID(), description, oib.getQty(), oib.getPrice(), oib.getDiscount());
			TotalOrderItem totalODI = new TotalOrderItem("0", "0", oib.getPD_ID(), productName, oib.getQty(), oib.getPrice());
			items.add(totalODI);
		}
		// SingleOrderBean:封裝一筆訂單資料的容器(包含訂單主檔與訂單明細檔的資料)
		SingleOrderBean singleODB = new SingleOrderBean(mBR_MEMBERID, oRD_totalAmount, oRD_shippingAddress, oRD_descriptions, today, null, items);
				
		ShoppingOrderDAOJDBC order = new ShoppingOrderDAOJDBC();
		System.out.println("this is processOrderServlet test   " + singleODB.getMBR_MEMBERID() );
		order.insertOrder(singleODB);
		
		session.removeAttribute("ShoppingCart");

		response.sendRedirect(response.encodeRedirectURL ("/pointscard/orderform/OrderSuccess.jsp"));
		} catch(SQLException e) {
			e.printStackTrace();
			throw new ServletException();
		}			
	}
}