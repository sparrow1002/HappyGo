package API;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cardPoint.model.CardPointService;

/**
 * Servlet implementation class JsonpServlet
 */
@WebServlet("/jsonp")
public class JsonpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CardPointService pointService = new CardPointService();
		String strPoint = request.getParameter("point");
		int point = Integer.parseInt(strPoint);
		Integer discount = pointService.calculateDiscount(point);
		String output = discount.toString() ;
		
		String callback = request.getParameter("callback");
		if(callback!=null && callback.length()!=0){
			output = callback + "('"+ output +"')";
		}
		PrintWriter out = response.getWriter();
		out.write(output);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
