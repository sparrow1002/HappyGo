package login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.model.CustomerBean;
import login.model.LoginServiceDB;

//20160401未加cookie與filter

@WebServlet("/secure/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private LoginServiceDB service = new LoginServiceDB();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
		HttpSession session = request.getSession();	
		String requestURI = (String) session.getAttribute("requestURI");
		Map<String, String> errorMsg = new HashMap<String, String>();		
		
		request.setAttribute("error", errorMsg);
		
		String MBR_MEMBERID = request.getParameter("userId");
		String MBR_PWD = request.getParameter("userPassword");
		
		System.out.println("request.getParameterTest" + "      " +  MBR_MEMBERID + "         " + MBR_PWD);
		
		if(MBR_MEMBERID == null || MBR_MEMBERID.trim().length() == 0) {
			
			System.out.println("validationTest one" + MBR_MEMBERID + MBR_PWD);
			errorMsg.put("accountError", "尚未填寫帳號");

		}
		
		if(MBR_PWD == null || MBR_PWD.trim().length() == 0) {
			errorMsg.put("passwordError", "尚未填寫帳號");
		}
		
		if(!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("pointscard/secure/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		 LoginServiceDB service;
		
		service = new LoginServiceDB();
		
		CustomerBean bean = service.login(MBR_MEMBERID, MBR_PWD);
		
		if(bean!=null) {				
			session.setAttribute("LoginOK", bean);	
			String path = request.getContextPath();
			response.sendRedirect(path+"/index.jsp");
			session.setAttribute("user", bean);

			
		}else {
			request.getRequestDispatcher(
					"/secure/login.jsp").forward(request, response);
			errorMsg.put("loginFailed", "該帳號不存在，請再次輸入帳密");				
		}
	
		if (errorMsg.isEmpty()) {
//			 此時不要用下面兩個敘述，因為網址列的URL不會改變
//			 RequestDispatcher rd = request.getRequestDispatcher("...");
//			 rd.forward(request, response);
			if (requestURI != null) {
				requestURI = (requestURI.length() == 0 ? request
						.getContextPath() : requestURI);
				System.out.println("part1" + requestURI);
//				response.sendRedirect(response.encodeRedirectURL(requestURI));
				return;
			} else {
//				response.sendRedirect(response.encodeRedirectURL(request
//						.getContextPath()));
				return;
			}
		} else {
//			 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/secure/login.jsp");
			rd.forward(request, response);
			return;
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}
