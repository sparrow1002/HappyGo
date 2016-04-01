package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import admin.model.AdminUserDAOService;
import admin.model.AdminUserDAObean;

@WebServlet("/Admin_list_Servlet.controller")
public class Admin_list_Servlet  extends HttpServlet {

	private AdminUserDAOService adminUserDAOService;
	@Override
	public void init() throws ServletException {
//		ServletContext application = this.getServletContext();
//		WebApplicationContext context = (WebApplicationContext)
//				WebApplicationContextUtils.getWebApplicationContext(application);
		WebApplicationContext context = (WebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		adminUserDAOService = (AdminUserDAOService) context.getBean("adminUserDAOService");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("test");
//		List<AdminUserDAObean> result = adminUserDAOService.select(null);
//		req.setAttribute("select", result);
		req.getRequestDispatcher("/admin/userlist.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	public String execute(){
		return "";
	}
}
