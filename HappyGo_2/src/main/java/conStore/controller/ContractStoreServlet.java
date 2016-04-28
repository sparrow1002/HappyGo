package conStore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conStore.model.ContractStoreBean;
import conStore.model.ContractStoreService;

@WebServlet(		  
		urlPatterns={"/conStore/contractStore.controller"}
		)
public class ContractStoreServlet extends HttpServlet {
	private ContractStoreService contractStoreService = new ContractStoreService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ContractStoreBean cb = (ContractStoreBean)session.getAttribute("storeLoginOK");
		
		String storeid = request.getParameter("storeid");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String taxcode = request.getParameter("taxcode");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		String phone = request.getParameter("phone");
		String contact = request.getParameter("contact");
		String createtime = request.getParameter("createtime");
		String deletime = request.getParameter("deletime");
		String updatetime = request.getParameter("updatetime");
		String updateuser = request.getParameter("Updateuser");
		String prodaction = request.getParameter("prodaction");
		
		ContractStoreBean bean = new ContractStoreBean();
		bean.setCos_storeid(storeid);
		bean.setCos_name(name);
		bean.setCos_pwd(pwd);
		bean.setCos_taxcode(taxcode);
		bean.setCos_address(address);
		bean.setCos_status(status);
		bean.setCos_phone(phone);
		bean.setCos_contact(contact);
		bean.setCos_createtime(createtime);
		bean.setCos_deletime(deletime);
		bean.setCos_updatetime(updatetime);
		bean.setCos_updateuser(updateuser);
		
		String prePath = request.getHeader("Referer");
		session.setAttribute("prePath", prePath);

		if("修改".equals(prodaction)){
			List<ContractStoreBean> result = contractStoreService.select(bean);
			request.setAttribute("select", result);
			if(bean.getCos_status()=="1" || bean.getCos_status()=="0"){
				request.getRequestDispatcher("/conStore/modify.jsp").forward(request, response);
			}else{
			request.getRequestDispatcher("/conStore/modify.jsp").forward(request, response);
			}
		}else if("登出".equals(prodaction)){
			session.removeAttribute("storeLoginOK");
			String path = request.getContextPath();
			response.sendRedirect(path+"/secure/login_store.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
