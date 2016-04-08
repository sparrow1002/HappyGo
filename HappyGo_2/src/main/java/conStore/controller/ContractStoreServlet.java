package conStore.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//接收HTML Form資料
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
		String prodaction = request.getParameter("prodaction");//button
		
		//轉換HTML Form資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		
		//驗證HTML Form資料
		
		
		//呼叫Model
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
		

		//根據Model執行結果顯示View
		if("Select".equals(prodaction)){
			List<ContractStoreBean> result = contractStoreService.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/conStore/display.jsp").forward(request, response);
		}else if(prodaction!=null && prodaction.equals("Insert")){
			ContractStoreBean result = contractStoreService.insert(bean);
			if(result == null){
				error.put("action","Insert fail");
			} else{
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher("/conStore/contractStore.jsp").forward(request, response);
		}else if(prodaction!=null && prodaction.equals("Update")){
			ContractStoreBean result = contractStoreService.update(bean);
			if(bean==null){
				error.put("action", "Update fail");
			} else{
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher("/conStore/contractStore.jsp").forward(request, response);
		}else if(prodaction!=null && prodaction.equals("Delete")){
			boolean result = contractStoreService.delete(bean);
			if(!result){
				request.setAttribute("delete", 0);
			} else {
				request.setAttribute("delete", 1);
			}
			request.getRequestDispatcher("/conStore/contractStore.jsp").forward(request, response);
		}else  {
			error.put("action", "Unknown Action:"+prodaction);
			request.getRequestDispatcher("/conStore/contractStore.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
