package report.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cardPoint.model.CardPointService;


@WebServlet("/reportCancelServer")
public class reportCancelServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public reportCancelServer() {

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long cancel = Long.parseLong(request.getParameter("report_cancel"));
		CardPointService cpService = new CardPointService();
		boolean result = cpService.cancelTran(cancel);
		request.getRequestDispatcher(
				"/report/result.jsp").forward(request, response);
	}

}
