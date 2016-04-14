package report.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
    
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String store = request.getParameter("store");
    	String id = request.getParameter("id");
    	reportDAOjdbc re = new reportDAOjdbc(dataSource);
    	BuildPDF bp = new BuildPDF();
    	ViewPDF vp = new ViewPDF();
    	boolean result;
    	Collection<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
    	if(request.getParameter("store")==null || request.getParameter("store").trim().length()==0){
    		store = null;
    	}
    	if(request.getParameter("id")==null || request.getParameter("id").trim().length()==0){
    		id=null;
    	}
    	list = re.select(id,request.getParameter("day1"),request.getParameter("day2"),store);
    	bp.PDFBuid(list);
    	result = vp.PDFView(request,response);
	}

}
