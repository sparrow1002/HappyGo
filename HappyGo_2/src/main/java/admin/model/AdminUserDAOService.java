package admin.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service(value = "adminUserDAOService")
public class AdminUserDAOService {
	private AdminUserDAO adminUserDAO;

	public AdminUserDAOService() {
	}

	public AdminUserDAOService(AdminUserDAO adminUserDAO) {
		this.adminUserDAO = adminUserDAO;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		AdminUserDAOService service = (AdminUserDAOService) context.getBean("adminUserDAOService");// new Product_Service();
		List<AdminUserDAObean> beans = service.select(null);
		System.out.println("beans=" + beans);
	}

	public List<AdminUserDAObean> select(AdminUserDAObean bean) {
		List<AdminUserDAObean> result = null;
		if (bean != null && bean.getADM_ID() != "") {
			AdminUserDAObean temp = adminUserDAO.select(bean.getADM_ID());
			if (temp != null) {
				result = new ArrayList<AdminUserDAObean>();
				result.add(temp);
			}
		} else {
			result = adminUserDAO.select();
		}
		return result;
	}

	public AdminUserDAObean login(String username, String password) {
		AdminUserDAObean bean = adminUserDAO.select(username);
		if (bean != null) {
			String pass = bean.getADM_PWD();
			byte[] temp = password.getBytes();
			if (pass.equals(password)) {
				return bean;
			}
		}
		return null;
	}

	public AdminUserDAObean changePassword(String username, String orgPasssWord,
			String newPassWord) {
		AdminUserDAObean bean = this.login(username, orgPasssWord);
		if (bean != null) {
			if (newPassWord != null && newPassWord.length() != 0) {
				bean.setADM_PWD(newPassWord);
				return adminUserDAO.update(bean);
			}
		}
		return null;
	}

	public AdminUserDAObean insert(AdminUserDAObean bean) {
		AdminUserDAObean result = null;
		if (bean != null) {
			result = adminUserDAO.insert(bean);
		}
		return result;
	}
	
	public AdminUserDAObean update(AdminUserDAObean bean) {
		AdminUserDAObean result = null;
		if (bean != null) {
			result = adminUserDAO.update(bean);
		}
		return result;
	}
}
