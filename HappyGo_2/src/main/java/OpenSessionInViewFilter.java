

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebFilter(
		urlPatterns={"/*"},
		initParams={
				@WebInitParam(name="sessionFactoryBeanName",value="sessionFactory")
		}

)
public class OpenSessionInViewFilter implements Filter {
	private FilterConfig config = null;
	private SessionFactory sessionFactory = null;
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		String sessionFactoryBeanname=config.getInitParameter("sessionFactoryBeanName");
		//System.out.println(sessionFactoryBeanname);
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		sessionFactory=(SessionFactory)context.getBean(sessionFactoryBeanname);
	}
	@Override
	public void destroy() {

	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("開始交易");
			chain.doFilter(req, resp);
			System.out.println("完成交易");
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("取消交易");
			sessionFactory.getCurrentSession().getTransaction().rollback();
			chain.doFilter(req, resp);
		}
	}
}

