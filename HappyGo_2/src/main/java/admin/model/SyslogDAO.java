package admin.model;

import java.util.List;

public interface SyslogDAO {

	public abstract List<SyslogDAOBean> select();

	public abstract List<SyslogDAOBean> select(SyslogDAOBean orgbean);

	public abstract SyslogDAOBean insert(SyslogDAOBean bean);

}