package admin.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import admin.model.RoleDAO;
import admin.model.RoleDAOBean;

@Repository(value = "roleDAO")
public class RoleDAOhibernate implements RoleDAO {
	private DataSource datasource;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context
//				.getBean("sessionFactory");
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			RoleDAO dao = (RoleDAO) context.getBean("roleDAO");
//			// List<RoleDAOBean> bean = dao.select("01");
//			// System.out.println(bean);
//			// List<RoleDAOBean> beans = dao.select();
//			// System.out.println(beans);
//
//			List<RoleDAOBean> beans = new ArrayList<RoleDAOBean>();
//			RoleDAOBean bean = new RoleDAOBean();
//
//			// bean.setROL_ROLEID("03");
//			// bean.setROL_RIGHTID("1002");
//			// bean.setROL_UPDATETIME(new java.util.Date());
//			// bean.setROL_UPDATEUSER("userid");
//			//
//			// beans.add(bean);
//			// if (dao.insert(beans))
//			// System.out.println("ok");
//			// else
//			// System.out.println("no");
//			
//			String jpqlUpdate = "update RoleDAOBean set ROL_UPDATETIME=getdate(),ROL_UPDATEUSER=:id3 where ROL_ROLEID=:id and ROL_RIGHTID=:id2";
//			int updatedEntities = sessionFactory.getCurrentSession()
//					.createQuery(jpqlUpdate)
//					.setParameter("id3", "accadd")
//					.setParameter("id", "03")
//					.setParameter("id2", "1001")
//					.executeUpdate();
//			if (updatedEntities > 0)
//				System.out.println("ok");
//			else
//				System.out.println("no");
//
////			result.setROL_UPDATETIME(new java.util.Date());
////			result.setROL_UPDATEUSER("userid");
//
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//	}

	public RoleDAOhibernate() {

	}

	public RoleDAOhibernate(DataSource datasource) {
		this.datasource = datasource;
	}
	public RoleDAOhibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final String SELECT_BY_ROLEID = "FROM RoleDAOBean where ROL_ROLEID=? ";
	private static final String SELECTALL = "FROM RoleDAOBean";

	@Override
	public List<RoleDAOBean> select(String roleid) {
		Query query = this.getSession()
				.createQuery("from RoleDAOBean where ROL_ROLEID=:id order by ROL_ROLEID,ROL_RIGHTID")
				.setParameter("id", roleid);
		return (List<RoleDAOBean>) query.list();
	}

	@Override
	public List<RoleDAOBean> select() {
		Query query = this.getSession().createQuery("from RoleDAOBean order by ROL_ROLEID,ROL_RIGHTID");
		return (List<RoleDAOBean>) query.list();
	}

	@Override
	public boolean delete(RoleDAOBean bean) {
		Query query = this.getSession()
				.createQuery("delete RoleDAOBean where ROL_ROLEID=:id")
				.setParameter("id", bean.getROL_ROLEID());
		query.executeUpdate();
		return true;

	}

	@Override
	public boolean insert(List<RoleDAOBean> beans) {
		System.out.println("RoleDAOBean insert");
		this.getSession().getTransaction().commit();
		this.getSession().beginTransaction();
		if (beans != null) {
			for (RoleDAOBean bean : beans) {
				System.out.println("bean ROLEID:"+bean.getROL_ROLEID()+",RIGHTID:"+bean.getROL_RIGHTID());
				this.getSession().saveOrUpdate(bean);
			}
			return true;
		}
		this.getSession().getTransaction().commit();
		return false;
	}
}
