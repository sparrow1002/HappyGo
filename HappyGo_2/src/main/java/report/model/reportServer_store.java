package report.model;

import java.io.File;
import java.io.IOException;
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

@WebServlet("/reportServer_store")
public class reportServer_store extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DataSource dataSource;
	public reportServer_store() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/websource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}
    
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String store = request.getParameter("username");
    	File reportFile = new
    			File(this.getServletContext().getRealPath("/report/jasper/HappyGo2.jasper")); 
    	String store = "1022000001";
    	String prodaction = request.getParameter("reportstore_prodaction");
    	String id = request.getParameter("reportstore_id");
    	String day01[];
    	day01 = request.getParameter("reportstore_day1").split("-");
    	String day1 = day01[0]+day01[1]+day01[2];
    	day01 = request.getParameter("reportstore_day2").split("-");
    	String day2 = day01[0]+day01[1]+day01[2];
    	reportDAOjdbc re = new reportDAOjdbc(dataSource);
    	BuildPDF bp = new BuildPDF();
    	ViewPDF vp = new ViewPDF();
    	boolean result;
    	Collection<Map<String, ?>> list1 = new ArrayList<Map<String, ?>>();
    	if(request.getParameter("reportstore_id")==null || request.getParameter("reportstore_id").trim().length()==0){
    		id=null;
    	}
    	if("產生PDF".equals(prodaction)){
    	list1 = re.select_store(id,day1,day2,store);
    	System.out.println(".................");
    	bp.PDFBuid_store(list1,reportFile.getPath());
    	result = vp.PDFView_store(request,response);
    	}else if("查詢".equals(prodaction)){
    		
    		List<reportDAOBean_store> result_bean = re.select_store_bean(id,day1,day2,store);
			request.setAttribute("reportstore_select", result_bean);
			request.getRequestDispatcher(
					"/report/Special_shops.jsp").forward(request, response);
    	}
	}

}
