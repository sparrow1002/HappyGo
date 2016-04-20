package admin.model.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.model.DataProfileDAO;
import admin.model.DataProfileDAOBean;


@Repository(value = "dataProfileDAO")
public class DataProfileDAOhibernate implements DataProfileDAO {
	private DataSource datasource;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DataProfileDAOhibernate() {

	}

	public DataProfileDAOhibernate(DataSource datasource) {
		this.datasource = datasource;
	}

	public DataProfileDAOhibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String selectitem(String group, String id) {
		DataProfileDAOBean temp = new DataProfileDAOBean();
		temp.setDAP_GROUP(group);
		temp.setDAP_ID(id);
		temp = this.getSession().get(DataProfileDAOBean.class, temp);
		return temp.getDAP_VALUE();
	}

	@Override
	public DataProfileDAOBean selectitems(String group, String id) {
		DataProfileDAOBean temp = new DataProfileDAOBean();
		temp.setDAP_GROUP(group);
		temp.setDAP_ID(id);
		temp = this.getSession().get(DataProfileDAOBean.class, temp);
		return temp;
	}

	@Override
	public List<DataProfileDAOBean> select(String group) {
		Query query = this.getSession()
				.createQuery("from DataProfileDAOBean where DAP_GROUP=:id")
				.setParameter("id", group);
		return (List<DataProfileDAOBean>) query.list();
	}

	@Override
	public Map<String, String> selects(String group) {
		Query query = this.getSession()
				.createQuery("from DataProfileDAOBean where DAP_GROUP=:id")
				.setParameter("id", group);

		List<DataProfileDAOBean> temp = (List<DataProfileDAOBean>) query.list();
		Map<String, String> temp2 = new TreeMap<String, String>();
		for (DataProfileDAOBean bean : temp) {
			temp2.put(bean.getDAP_ID(), bean.getDAP_VALUE());
		}
		return temp2;
	}

	@Override
	public List<DataProfileDAOBean> selectall() {
		Query query = this.getSession().createQuery("from DataProfileDAOBean");
		return (List<DataProfileDAOBean>) query.list();
	}

	@Override
	public DataProfileDAOBean update(DataProfileDAOBean bean) {
		this.getSession().saveOrUpdate(bean);
		return bean;
	}

	@Override
	public DataProfileDAOBean insert(DataProfileDAOBean bean) {
		this.getSession().save(bean);
		return bean;
	}

}
