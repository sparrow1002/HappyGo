package conStore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conStore.model.ContractStoreBean;
import conStore.model.ContractStoreService;

@WebServlet(urlPatterns = { "/conStore/register.controller" })
public class RegisterServlet extends HttpServlet {
	private ContractStoreService contractStoreService = new ContractStoreService();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		String storeid = request.getParameter("storeid");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String taxcode = request.getParameter("taxcode");
		String address = request.getParameter("address");
//		String status = request.getParameter("status");
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
		//bean.setCos_status(status);
		bean.setCos_phone(phone);
		bean.setCos_contact(contact);
		bean.setCos_createtime(createtime);
		bean.setCos_deletime(deletime);
		bean.setCos_updatetime(updatetime);
		bean.setCos_updateuser(updateuser);
		
		if(prodaction!=null && prodaction.equals("申請特約商店")) {
			ContractStoreBean result = contractStoreService.insert(bean);
			if(result==null) {
				//error.put("action", "Insert fail");
			} else {
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher(
					"/secure/login_store.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
