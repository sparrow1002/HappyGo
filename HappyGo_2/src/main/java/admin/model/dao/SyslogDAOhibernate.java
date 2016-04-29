package admin.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.model.SyslogDAO;
import admin.model.SyslogDAOBean;

@Repository(value = "syslogDAO")
public class SyslogDAOhibernate  implements SyslogDAO  {
	private DataSource datasource;
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SyslogDAOhibernate() {
	}

	public SyslogDAOhibernate(DataSource datasource) {
		this.datasource = datasource;
	}
	public SyslogDAOhibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<SyslogDAOBean> select() {
		Query query = this.getSession().createQuery("from SyslogDAOBean");
		return (List<SyslogDAOBean>) query.list();
	}
	@Override
	public List<SyslogDAOBean> select(SyslogDAOBean orgbean) {
		this.getSession().getTransaction().commit();
		this.getSession().beginTransaction();
		Query query = this.getSession()
				.createQuery("from SyslogDAOBean where LOG_USERID=:id")
				.setParameter("id", orgbean.getLOG_USERID());
		return (List<SyslogDAOBean>) query.list();
	}
	@Override
	public SyslogDAOBean insert(SyslogDAOBean bean) {
		this.getSession().save(bean);
		return bean;
	}
}
