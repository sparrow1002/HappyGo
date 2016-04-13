package product.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import products.model.ProductBean;
import products.model.ProductJDBC;

@WebServlet("/productDisplay/BuyProduct.do")
public class BuyProductServlet extends HttpServlet {
	// 當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		
		String PD_no1 = request.getParameter("param1");
		String PD_no2 = request.getParameter("param2");

		System.out.println("this is getParameter   " + PD_no1);
		System.out.println("this is getParameter   " + PD_no2);

		ProductJDBC pdJDBC = new ProductJDBC(); 
		ProductBean bean = null;
		bean = pdJDBC.getProduct(PD_no1);
			System.out.println(bean);		
		session.setAttribute("ProductBean", bean);
		
		if(PD_no1==null && PD_no2.equals("02")){
		bean = pdJDBC.getProduct(PD_no2);

		session.setAttribute("ProductBean", bean);
		}
		//測試程式
//		System.out.println("this is productServlet testing  " + getAllBean); 
//		System.out.println("this is productServlet testing  " + bean);
	

//		session.setAttribute("ProductAllBean", getAllBean);

//		response.sendRedirect("/pointscard/productPage/test.jsp");
//		response.sendRedirect("/pointscard/productPage/Products.jsp");
		response.sendRedirect("/pointscard/productDisplay/ProductDetail.jsp");
//		response.sendRedirect("/pointscard/productPage/CopyOfProducts.jsp");

		return;

	}
}