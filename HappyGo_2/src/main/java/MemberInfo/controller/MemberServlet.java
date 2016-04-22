package MemberInfo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberInfo.model.MemberBean;
import MemberInfo.model.MemberService;
import model.CustomerBean;
import model.CustomerService;


@WebServlet(
		urlPatterns={"/pages/member.controller"}
)
public class MemberServlet extends HttpServlet {
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private MemberService service = new MemberService();
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//接收HTML Form資料

		
		String prodaction = request.getParameter("prodaction");		
		if(prodaction!=null && prodaction.equals("回會員中心首頁")) {
			String path = request.getContextPath();
			response.sendRedirect(
					path + "/secure/login_mem.jsp");
			return;
		}

		String MBR_MEMBERID = request.getParameter("MBR_MEMBERID");
		String MBR_NAME = request.getParameter("MBR_NAME");
		String MBR_PWD = request.getParameter("MBR_PWD");
		String MBR_SEX = request.getParameter("MBR_SEX");
		String MBR_BIRTHDAY = request.getParameter("MBR_BIRTHDAY");
		String MBR_IDENTITY = request.getParameter("MBR_IDENTITY");
		String MBR_POST = request.getParameter("MBR_POST");
		String MBR_ARRDESS = request.getParameter("MBR_ARRDESS");
		String MBR_MARRIED = request.getParameter("MBR_MARRIED");
		String MBR_MOBIL = request.getParameter("MBR_MOBIL");
		String MBR_PHONE = request.getParameter("MBR_PHONE");
		String MBR_EMAIL = request.getParameter("MBR_EMAIL");
		String MBR_CREATEDATE = request.getParameter("BR_CREATEDATE");
		String MBR_DELDATE = request.getParameter("MBR_DELDATE");
		String MBR_POINTS = request.getParameter("MBR_POINTS");
		String MBR_STATUS = request.getParameter("MBR_STATUS");
		String MBR_INTRODUCER = request.getParameter("MBR_INTRODUCER");
		String MBR_UPDATETIME = request.getParameter("MBR_UPDATETIME");
		String MBR_UPDATEUSER = request.getParameter("MBR_UPDATEUSER");

		
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		
		CustomerBean bean = new CustomerBean();
		
		if(MBR_MEMBERID==null || MBR_MEMBERID.trim().length()==0) {
			request.setAttribute("user", bean);
			error.put("MBR_MEMBERID", "會員編號不可空白");
			if("建立帳號".equals(prodaction))
				request.getRequestDispatcher(
						"/pages/new.jsp").forward(request, response);
			return;
		} 
		if(MBR_NAME==null || MBR_NAME.trim().length()==0) {
			request.setAttribute("user", bean);
			error.put("MBR_NAME", "會員姓名不可空白");
			if("建立帳號".equals(prodaction))
				request.getRequestDispatcher(
						"/pages/new.jsp").forward(request, response);
			return;
		}
		if(MBR_PWD==null || MBR_PWD.trim().length()==0) {
			request.setAttribute("user", bean);
			error.put("MBR_PWD", "密碼不可空白");
			if("建立帳號".equals(prodaction)){
				request.getRequestDispatcher(
						"/pages/new.jsp").forward(request, response);
			}
			return;
		}		
		
		if(MBR_MOBIL==null || MBR_MOBIL.trim().length()==0) {
			request.setAttribute("user", bean);
			error.put("MBR_MOBIL", "手機號碼不可空白");
			if("建立帳號".equals(prodaction))
				request.getRequestDispatcher(
						"/pages/new.jsp").forward(request, response);
			return;
		}		
		if(MBR_EMAIL==null || MBR_EMAIL.trim().length()==0) {
			request.setAttribute("user", bean);
			error.put("MBR_EMAIL", "電子郵件帳號不可空白");
			if("建立帳號".equals(prodaction))
				request.getRequestDispatcher(
						"/pages/new.jsp").forward(request, response);
			return;
		}		
		
//轉換HTML Form資料
		bean.setMBR_MEMBERID(MBR_MEMBERID);
		bean.setMBR_NAME(MBR_NAME);
		bean.setMBR_PWD(MBR_PWD);
		bean.setMBR_SEX(MBR_SEX);
		bean.setMBR_BIRTHDAY(MBR_BIRTHDAY);
		bean.setMBR_IDENTITY(MBR_IDENTITY);
		bean.setMBR_POST(MBR_POST);
		bean.setMBR_ARRDESS(MBR_ARRDESS);
		bean.setMBR_MARRIED(MBR_MARRIED);
		bean.setMBR_MOBIL(MBR_MOBIL);
		bean.setMBR_PHONE(MBR_PHONE);
		bean.setMBR_EMAIL(MBR_EMAIL);
		bean.setMBR_CREATEDATE(MBR_CREATEDATE);
		bean.setMBR_DELDATE(MBR_DELDATE);
		bean.setMBR_POINTS(100);
		bean.setMBR_STATUS(MBR_STATUS);
		bean.setMBR_INTRODUCER(MBR_INTRODUCER);
		bean.setMBR_UPDATETIME(null);
		bean.setMBR_UPDATEUSER(MBR_UPDATEUSER);		

		if(prodaction!=null && prodaction.equals("建立帳號")) {
			boolean b = service.insert(MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_MOBIL, MBR_EMAIL);
			if(!b) {
				error.put("action", "建立帳號失敗, 請重新操作");
			} 
			String path = request.getContextPath();
			request.getRequestDispatcher(
					"/secure/login_mem.jsp").forward(request, response);
			
			return;
		}
		
		if(prodaction!=null && prodaction.equals("確定")) {
			MemberBean result = service.update(MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_MOBIL, MBR_EMAIL);
			if(result==null) {
				error.put("action", "修改資料失敗, 請重新操作");
			} else {
				request.setAttribute("user", result);
			}
			String path = request.getContextPath();
			request.getRequestDispatcher(
					"/secure/login_mem.jsp").forward(request, response);

			return;
		} 

	}			
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
