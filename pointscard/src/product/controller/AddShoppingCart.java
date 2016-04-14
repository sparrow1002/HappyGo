package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import products.model.MyOrderItemBean;
import shoppingCart.model.ShoppingCart;


@WebServlet("/AddShoppingCart")
public class AddShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session == null) {      // 使用逾時
			request.setAttribute("Errors", "使用逾時，請重新登入(BuyBookServlet:SessionTimeOut)");
			RequestDispatcher rd = request.getRequestDispatcher("/secure/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		ShoppingCart cart = (ShoppingCart)session.getAttribute("ShoppingCart");
		// 如果找不到ShoppingCart物件
		if (cart == null) {
			// 就新建ShoppingCart物件
			cart = new ShoppingCart();
			// 將此新建ShoppingCart的物件放到session物件內
			session.setAttribute("ShoppingCart", cart);
		}
		
		String pD_ID 		= request.getParameter("id");
		String pD_name 		= request.getParameter("name");
		String qtyStr 		= request.getParameter("qty");
		String priceStr 	= request.getParameter("price");
		int qty = 0 ; 
		double price = 0 ; 
		
		try{
			// 進行資料型態的轉換
			qty = Integer.parseInt(qtyStr.trim());
			price = Double.parseDouble(priceStr.trim());
		} catch(NumberFormatException e){
			throw new ServletException(e); 
		}
		// 將訂單資料封裝到OrderItemBean內
		MyOrderItemBean myODI = new MyOrderItemBean(pD_name, qty, pD_ID, price);
		// 將OrderItemBean加入ShoppingCart的物件內
		cart.addToCart(pD_ID, myODI);
		session.setAttribute("addSuccess", myODI);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/productDisplay/ProductDetail.jsp");
//		rd.forward(request, response);
		response.sendRedirect("/pointscard/productDisplay/ProductDetail.jsp");
		
	}
}
