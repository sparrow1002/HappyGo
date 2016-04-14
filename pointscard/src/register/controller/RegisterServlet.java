package register.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import register.model.CustomerBean;
import register.model.RegisterDAOJDBC;

@WebServlet("/register/Register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//測試程式
//		RegisterDAOJDBC dao1 = new RegisterDAOJDBC();
//		CustomerBean bean1 = dao1.select("01");		
//		System.out.println(bean1);
		
				Map<String, String> errorMsg = new HashMap<String, String>();
				Map<String, String> msgOK = new HashMap<String, String>();				
				HttpSession session = request.getSession();
		        request.setAttribute("error", errorMsg); 
		        		        
		        String MBR_MEMBERID = request.getParameter("customerId");
		        System.out.println(MBR_MEMBERID);
		        if(MBR_MEMBERID == null || MBR_MEMBERID.trim().length()==0) {		        	
		        	errorMsg.put("errorId","帳號必須輸入");		
		        }
		        
		        String MBR_PWD = request.getParameter("customerPassword");
		        System.out.println(MBR_PWD);
		        if(MBR_PWD==null || MBR_PWD.trim().length()==0) {
		        	errorMsg.put("errorPassword", "密碼必須輸入");		        
		        } 
		        
		        String MBR_NAME = request.getParameter("customerName");
		        if(MBR_NAME==null || MBR_NAME.trim().length()==0) {
		        	errorMsg.put("errorCustomerName", "姓名必須輸入");     	
		        }
		        
		        String MBR_IDENTITY = request.getParameter("identityId");
		        if(MBR_IDENTITY==null || MBR_IDENTITY.trim().length()==0) {
		        	errorMsg.put("identityId", "身分證號必須輸入");		        
		        } 
		        
		        String MBR_MOBIL = request.getParameter("phoneNumber");
		        String MBR_SEX = request.getParameter("sex");
		        System.out.println(MBR_SEX);
		        if(MBR_SEX.equals("男")) {
		        	MBR_SEX = "1";
		        }else {
		        	MBR_SEX = "0";
		        }
		        String MBR_EMAIL = request.getParameter("email");
		        String MBR_ARRDESS = request.getParameter("cities"); 
		        System.out.println(MBR_ARRDESS);
		        String MBR_BIRTHDAY = request.getParameter("birthDay").replaceAll("/", "");     
		        String customerData = request.getParameter("customerData");
		        
		        // 如果有錯誤，呼叫view元件，送回錯誤訊息
		        if(!errorMsg.isEmpty()) { 	
		        	RequestDispatcher rd = request.getRequestDispatcher("/register/register.jsp");
		        	rd.forward(request, response);
		        	return;
		        }
		        	
		        CustomerBean bean = new CustomerBean(MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_SEX, MBR_BIRTHDAY, MBR_IDENTITY, MBR_ARRDESS, MBR_MOBIL, MBR_EMAIL);
		        System.out.println("this is bean" + bean);
		        try {
					RegisterDAOJDBC dao = new RegisterDAOJDBC();
					dao.saveMember(bean);
					request.setAttribute("CustomerBean", bean);
					
					response.sendRedirect("../index.jsp");
//					RequestDispatcher rd = request.getRequestDispatcher("../index.jsp");
//					rd.forward(request, response);
					return;
				} catch (Exception e) {
					if (e.getMessage().indexOf("重複的索引鍵") != -1 || 
							e.getMessage().indexOf("Duplicate entry") != -1) {
							errorMsg.put("errorId","帳號重複，請重新輸入帳號");
						} else {
							errorMsg.put("exception","資料庫存取錯誤:" + e.getMessage());
						}
						RequestDispatcher rd = request
							.getRequestDispatcher("/register/register.jsp");
						rd.forward(request, response);
						return;
					}
				}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);		
	}
	
}
