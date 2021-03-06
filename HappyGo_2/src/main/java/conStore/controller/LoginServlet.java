package conStore.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import conStore.model.ContractStoreBean;
import conStore.model.ContractStoreService;
import conStore.model.dao.ContractStoreDAOJdbc;

@WebServlet(urlPatterns = { "/secure/login_store.controller" })
public class LoginServlet extends HttpServlet {
	private ContractStoreService service = new ContractStoreService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 接收HTML Form資料
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 驗證HTML Form資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);

		if (username == null || username.length() == 0) {
			error.put("username", "請輸入ID");
		}
		if (password == null || password.length() == 0) {
			error.put("password", "請輸入PWD");
		}

		if (error != null && !error.isEmpty()) {
			request.getRequestDispatcher("/secure/login_store.jsp").forward(request,
					response);
			return;
		}

		// 呼叫Model
		ContractStoreBean bean = service.login(username, password);

		// 根據Model執行結果顯示View
		if (bean == null) {
			error.put("password", "登入失敗，請再次輸入ID/PWD");
			request.getRequestDispatcher("/secure/login_store.jsp").forward(request,
					response);
		}else if("3".equals(bean.getCos_status())){//管理者登入頁面
			HttpSession session = request.getSession();
			session.setAttribute("storeLoginOK", bean);
			//System.out.println(session.setAttribute("user", bean));
			String path = request.getContextPath();
			response.sendRedirect(path+"/conStore/contractStore.jsp");
		} 
		else if("2".equals(bean.getCos_status())){//待審核
			HttpSession session = request.getSession();
			session.setAttribute("storeLoginOK", bean);
			//System.out.println(session.setAttribute("user", bean));
			String path = request.getContextPath();
			response.sendRedirect(path+"/conStore/singlecontractStore.jsp");					
		}else{//各特店頁面
			HttpSession session = request.getSession();
			session.setAttribute("storeLoginOK", bean);
			//System.out.println(session.setAttribute("user", bean));
			String path = request.getContextPath();
			response.sendRedirect(path+"/conStore/singlecontractStore.jsp");	
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
