package admin.model;

import java.util.List;

public interface AdminUserDAO {
	public abstract AdminUserDAObean select(String userid);

	public abstract List<AdminUserDAObean> select();

	public abstract AdminUserDAObean insert(AdminUserDAObean bean);

	public abstract AdminUserDAObean update(AdminUserDAObean bean);
}