package admin.model;

import java.util.List;

public interface RightDAO {

	public abstract List<RightDAOBean> select(RightDAOBean bean);

	public abstract List<RightDAOBean> select();

	public abstract RightDAOBean insert(RightDAOBean bean);

	public abstract RightDAOBean delete(RightDAOBean bean);

	public abstract RightDAOBean update(RightDAOBean bean);

}