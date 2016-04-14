package MemberInfo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerBean;
import model.CustomerService;


@WebServlet(
		urlPatterns={"/secure/login.controller"}
)
public class LoginServlet extends HttpServlet {
	private CustomerService customerService = new CustomerService();
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("loginOrCreate");
		if(type.equals("登出")) {
			request.getRequestDispatcher(
					"/pages/logout.jsp").forward(request, response);
			return;
		} 		

		if(type.equals("忘記密碼")) {
			request.getRequestDispatcher(
					"/pages/forget.jsp").forward(request, response);
			return;
		} 				
		
		if(type.equals("使用(會員帳號/電子郵件)查詢")){
			//接收HTML Form資料
			String username = request.getParameter("MBR_MEMBERID");
			String email = request.getParameter("MBR_EMAIL");
			
	//驗證HTML Form資料
			Map<String, String> error = new HashMap<String, String>();
			request.setAttribute("error", error);
	
			if(username==null || username.length()==0) {
				error.put("MBR_MEMBERID", "請輸入會員編號");
			}
			if(email==null || email.length()==0) {
				error.put("MBR_EMAIL", "請輸入電子郵件帳號");
			}
			
			if(error!=null && !error.isEmpty()) {
				request.getRequestDispatcher(
						"/pages/forget.jsp").forward(request, response);
				return;
			}
			
	//呼叫Model
			CustomerBean bean = customerService.login(username);
			
	//根據Model執行結果顯示View
			if(bean==null) {
				error.put("MBR_MEMBERID", "帳號不存在，請再次輸入ID/EMAIL");
				request.getRequestDispatcher(
						"/pages/forget.jsp").forward(request, response);
				return;
			} else {
				String s = bean.getMBR_EMAIL(); 
				if(!s.equals(email)){
					error.put("MBR_EMAIL", "電子郵件帳號錯誤，請再次輸入ID/EMAIL");
					request.getRequestDispatcher(
							"/pages/forget.jsp").forward(request, response);
					return;
			}

			final String username1 = "ken.eeit84@gmail.com";
			final String password = "fortestonly";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username1, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("NO_REPLY@eeit84.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ken.eeit84@gmail.com"));
				message.setSubject("您的臨時密碼");
				message.setText("親愛的客戶, 您的臨時密碼是: 1234,"
					+ "\n\n 請使用臨時密碼更新您的密碼設定!");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}				
				
				String path = request.getContextPath();
				response.sendRedirect(
						path + "/pages/resetpassword.jsp");
			}
			return;
		} 
		
		if(type.equals("回會員中心首頁")){
			String path = request.getContextPath();
			request.getRequestDispatcher(
					"/secure/login_mem.jsp").forward(request, response);
		}
		
		if(type.equals("會員登入")){
//接收HTML Form資料
			String username = request.getParameter("MBR_MEMBERID");
			String password = request.getParameter("MBR_PWD");
			
	//驗證HTML Form資料
			Map<String, String> error = new HashMap<String, String>();
			request.setAttribute("error", error);
	
			if(username==null || username.length()==0) {
				error.put("MBR_MEMBERID", "請輸入會員編號");
			}
			if(password==null || password.length()==0) {
				error.put("MBR_PWD", "請輸入密碼");
			}
			
			if(error!=null && !error.isEmpty()) {
				request.getRequestDispatcher(
						"/secure/login_mem.jsp").forward(request, response);
				return;
			}
			
	//呼叫Model
			CustomerBean bean = customerService.login(username);
			
	//根據Model執行結果顯示View
			if(bean==null) {
				error.put("MBR_PWD", "登入失敗，請再次輸入ID/PWD");
				request.getRequestDispatcher(
						"/secure/login_mem.jsp").forward(request, response);
			} else {
				String s = bean.getMBR_PWD();
				if(!s.contains(password)){
					error.put("MBR_PWD", "登入失敗，請再次輸入ID/PWD");
					request.getRequestDispatcher(
							"/secure/login_mem.jsp").forward(request, response);
					return;
				}
					
				HttpSession session = request.getSession();
				session.setAttribute("user", bean);
				
				String path = request.getContextPath();
				response.sendRedirect(
						path + "/pages/product.jsp");
			}
		} else {
			
			String path = request.getContextPath();
			response.sendRedirect(
					path + "/pages/new.jsp");
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
