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
		urlPatterns={"/conStore/modify.controller"}
		)
public class modify extends HttpServlet {

		private ContractStoreService contractStoreService = new ContractStoreService();
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
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
			
			ContractStoreBean beanuser = new ContractStoreBean();
			HttpSession session = request.getSession();
			beanuser = (ContractStoreBean)session.getAttribute("storeLoginOK");
			System.out.println(updateuser = beanuser.getCos_storeid());
			
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
			
			if(prodaction!=null && prodaction.equals("Update")){
				ContractStoreBean result = contractStoreService.update(bean);
				if(bean==null){
					
				} else{
					request.setAttribute("update", result);
				}
				request.getRequestDispatcher("/conStore/contractStore.jsp").forward(request, response);
			}

		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			this.doGet(req, resp);
		}

}
