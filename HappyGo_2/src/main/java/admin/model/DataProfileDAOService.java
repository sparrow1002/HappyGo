package admin.model;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service(value = "dataProfileDAOService")
public class DataProfileDAOService {

	private DataProfileDAO dataProfileDAO;

	public DataProfileDAOService() {

	}

	public DataProfileDAOService(DataProfileDAO dataProfileDAO) {
		this.dataProfileDAO = dataProfileDAO;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		DataProfileDAOService service = (DataProfileDAOService) context
				.getBean("dataProfileDAOService");// new Product_Service();
		List<DataProfileDAOBean> beans = service.select();
		System.out.println("beans=" + beans);
	}

	public List<DataProfileDAOBean> select(DataProfileDAOBean bean) {
		List<DataProfileDAOBean> result = null;
		if (bean != null && bean.getDAP_GROUP() != "") {
			System.out.println("AdminUserDAObean select :"
					+ bean.getDAP_GROUP());
			result = dataProfileDAO.select(bean.getDAP_GROUP());
		} else {
			result = dataProfileDAO.selectall();
		}
		return result;
	}

	public Map<String, String> selects(DataProfileDAOBean bean) {
		Map<String, String> result = null;
		if (bean != null && bean.getDAP_GROUP() != "") {
			System.out.println("AdminUserDAObean select :"
					+ bean.getDAP_GROUP());
			result = dataProfileDAO.selects(bean.getDAP_GROUP());
		}
		return result;
	}

	public String selectitem(DataProfileDAOBean bean) {
		String result = "";
		if (bean != null && bean.getDAP_GROUP() != "") {
			System.out.println("AdminUserDAObean select :"
					+ bean.getDAP_GROUP());
			result = dataProfileDAO.selectitem(bean.getDAP_GROUP(),
					bean.getDAP_ID());
		}
		return result;
	}

	public DataProfileDAOBean selectitems(DataProfileDAOBean bean) {
		DataProfileDAOBean result = null;
		if (bean != null && bean.getDAP_GROUP() != "") {
			System.out.println("AdminUserDAObean select :"
					+ bean.getDAP_GROUP());
			result = dataProfileDAO.selectitems(bean.getDAP_GROUP(),
					bean.getDAP_ID());
		}
		return result;
	}

	public List<DataProfileDAOBean> select() {
		List<DataProfileDAOBean> result = null;
		result = dataProfileDAO.selectall();
		return result;
	}

	public DataProfileDAOBean update(DataProfileDAOBean bean) {
		DataProfileDAOBean result = null;
		if (bean != null) {
			result = dataProfileDAO.update(bean);
		}
		return result;
	}

	public DataProfileDAOBean insert(DataProfileDAOBean bean) {
		DataProfileDAOBean result = null;
		if (bean != null) {
			System.out.println("service insert to go!!");
			result = dataProfileDAO.insert(bean);
		} else
			System.out.println("service insert not go!!");
		return result;
	}

	public List<DataProfileDAOBean> getRoleID() {
		List<DataProfileDAOBean> result = null;
		result = dataProfileDAO.select("ROLEID");
		return result;
	}
	//2016/4 28 dayu add new method
	public String select(String psDAP_GROUP, String psDAP_ID) {
		String result = "";		
		result = dataProfileDAO.selectitem(psDAP_GROUP,psDAP_ID);
		return result;
	}
}
