package report.model;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import report.model.dao.reportDAOjdbc;

@WebServlet("/reportServer")
public class reportServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DataSource dataSource;

	public reportServer() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/websource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File reportFile = new File(this.getServletContext().getRealPath("/report/jasper/HappyGo.jasper"));
		File reportFile2 = new File(this.getServletContext().getRealPath("/report/jasper/HappyGo2.jasper"));
		String prodaction = request.getParameter("report_prodaction");
		String store = request.getParameter("report_store");
		String id = request.getParameter("report_id");
		String day[];
		System.out.println(request.getParameter("report_day1"));
		day = request.getParameter("report_day1").split("-");
		String day1 = day[0] + day[1] + day[2];
		day = request.getParameter("report_day2").split("-");
		String day2 = day[0] + day[1] + day[2];
		reportDAOjdbc re = new reportDAOjdbc(dataSource);
		BuildPDF bp = new BuildPDF();
		ViewPDF vp = new ViewPDF();
		boolean result;
		Collection<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
		if (request.getParameter("report_store") == null || request.getParameter("report_store").trim().length() == 0) {
			store = null;
		}
		if (request.getParameter("report_id") == null || request.getParameter("report_id").trim().length() == 0) {
			id = null;
		}
		if ("列印報表".equals(prodaction)) {
			if (store == null) {
				list = re.select(id, day1, day2, store);
				bp.PDFBuid(list, reportFile.getPath());
				result = vp.PDFView(request, response);
			} else {
				list = re.select_store(id, day1, day2, store);
				bp.PDFBuid_store(list, reportFile2.getPath());
				result = vp.PDFView_store(request, response);
			}
		} else if ("查詢".equals(prodaction)) {
			if(store == null){
			List<reportDAOBean> result_bean = re.select_bean(id, day1, day2, store);
			request.setAttribute("report_select", result_bean);
			request.getRequestDispatcher("/report/Count_inquiry.jsp").forward(request, response);
			}else{
			List<reportDAOBean_store> result_bean = re.select_store_bean(id, day1, day2, store);
			BigDecimal total1 = re.total01(result_bean);
			BigDecimal total2 = re.total02(result_bean);
			request.setAttribute("report_select_store", result_bean);
			request.setAttribute("total01", total1);
			request.setAttribute("total02", total2);
			request.getRequestDispatcher("/report/Count_inquiry.jsp").forward(request, response);
			}
		}
	}

}
