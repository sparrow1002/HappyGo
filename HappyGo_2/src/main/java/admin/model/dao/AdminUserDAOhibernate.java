package admin.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import admin.model.AdminUserDAO;
import admin.model.AdminUserDAObean;

@Repository(value = "adminUserDAO")
public class AdminUserDAOhibernate  implements AdminUserDAO{
	private DataSource datasource;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public AdminUserDAOhibernate() {}

	public AdminUserDAOhibernate(DataSource datasource) {
		this.datasource = datasource;
	}
	public AdminUserDAOhibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public AdminUserDAObean select(String userid) {
		System.out.println(userid);
		AdminUserDAObean temp = this.getSession().get(AdminUserDAObean.class, userid);
		return temp;
	}
	@Override
	public List<AdminUserDAObean> select() {
		this.getSession().getTransaction().commit();
		this.getSession().beginTransaction();
		Query query = this.getSession().createQuery("from AdminUserDAObean");
		return (List<AdminUserDAObean>) query.list();
	}
	@Override
	public AdminUserDAObean insert(AdminUserDAObean bean) {
		this.getSession().save(bean);
		return bean;
	}
	@Override
	public AdminUserDAObean update(AdminUserDAObean bean) {
		this.getSession().saveOrUpdate(bean);
		return bean;
	}
}
