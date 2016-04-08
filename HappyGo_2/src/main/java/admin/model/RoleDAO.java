package admin.model;

import java.util.List;

public interface RoleDAO {

	public abstract List<RoleDAOBean> select(String roleid);

	public abstract List<RoleDAOBean> select();

	public abstract boolean delete(RoleDAOBean bean);

	public abstract boolean insert(List<RoleDAOBean> beans);

}