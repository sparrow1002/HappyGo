package admin.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.model.RightDAO;
import admin.model.RightDAOBean;


@Repository(value = "rightDAO")
public class RightDAOhibernate implements RightDAO {
	private DataSource datasource;
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public RightDAOhibernate() {
	}

	public RightDAOhibernate(DataSource datasource) {
		this.datasource = datasource;
	}
	public RightDAOhibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public RightDAOBean select(RightDAOBean bean) {
		RightDAOBean newbean = (RightDAOBean) this.getSession().get(RightDAOBean.class, bean.getRIG_RIGHTID());
		return (RightDAOBean) newbean;
	}
	@Override
	public List<RightDAOBean> select() {
		Query query = this.getSession().createQuery("from RightDAOBean");
		return (List<RightDAOBean>) query.list();
	}
	@Override
	public RightDAOBean insert(RightDAOBean bean) {
		this.getSession().save(bean);
		return bean;
	}
	@Override
	public RightDAOBean delete(RightDAOBean bean) {
		Query query = this.getSession()
				.createQuery("delete RightDAOBean where RIG_RIGHTID=:id")
				.setParameter("id", bean.getRIG_RIGHTID());
		query.executeUpdate();
		return bean;
	}
	@Override
	public RightDAOBean update(RightDAOBean bean) {
		this.getSession().saveOrUpdate(bean);
		return bean;
	}
}
