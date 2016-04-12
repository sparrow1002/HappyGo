package model;

import java.util.Arrays;

import model.CustomerDAO;
import model.dao.CustomerDAOJdbc;

public class CustomerService {
	private CustomerDAOJdbc dao = new CustomerDAOJdbc();

	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		CustomerBean bean = service.login("b00003");
		System.out.println(bean);
	}
	
	public CustomerBean login(String MBR_MEMBERID) {
		CustomerBean result = dao.select(MBR_MEMBERID);
		return result;
	}

	public boolean insert(String MBR_MEMBERID, String MBR_NAME,
			String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL){
		boolean b = dao.insert(MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_MOBIL, MBR_EMAIL);
		return b;
	}
	
	public CustomerBean update(String MBR_MEMBERID, String MBR_NAME,
			String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL){
		CustomerBean bean = dao.update(MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_MOBIL, MBR_EMAIL);
		return bean;
	}	
}
