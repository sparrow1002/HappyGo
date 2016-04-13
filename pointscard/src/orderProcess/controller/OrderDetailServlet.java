package orderProcess.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.model.MyOrderItemBean;
import shoppingCart.model.ShoppingOrderDAOJDBC;
import shoppingCart.model.SingleOrderBean;
import shoppingCart.model.TotalOrderItem;


@WebServlet("/_05_orderProcess/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String ORD_seqNO = request.getParameter("orderNo");
		try {
			ShoppingOrderDAOJDBC ordDAO = new ShoppingOrderDAOJDBC();
			SingleOrderBean singleODB = ordDAO.getOrder(ORD_seqNO);
			request.setAttribute("OrderBean", singleODB);
			RequestDispatcher  rd = request.getRequestDispatcher("MyShowOrderDetail.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	public void displayOrderBean(SingleOrderBean singleODB) {
		System.out.println("ob.getOrderNo()=" + singleODB.getORD_no());
		System.out.println("ob.getUserID()=" + singleODB.getMBR_MEMBERID());
		System.out.println("ob.getOrderDate=" + singleODB.getORD_date());
		System.out.println("ob.getTotalAmount=" + singleODB.getORD_totalAmount());
		System.out.println("ob.getInvoiceTitle=" + singleODB.getORD_descriptions());

		System.out.println("ob.getShippingAddress=" + singleODB.getORD_shippingAddress());
		System.out.println("ob.getCancelTag=" + singleODB.getORD_cancelTag());
		System.out.println("==============訂單明細=================");
		List<TotalOrderItem> items = singleODB.getItems();
		for (TotalOrderItem totalOIB : items) {
			System.out.println("---------------一筆明細---------------");
			System.out.println("   oib.getSeqno()=" + totalOIB.getORD_seqno());
			System.out.println("   oib.getOrderNo()=" + totalOIB.getORD_no());
			System.out.println("   oib.getBookID()=" + totalOIB.getPD_ID());
			System.out.println("   oib.getDescription()="
					+ totalOIB.getPD_descriptions());
			System.out.println("   oib.getAmount()=" + totalOIB.getORD_amount());
			System.out.println("   oib.getUnitPrice()=" + totalOIB.getORD_unitPrice());
		}
	}
}