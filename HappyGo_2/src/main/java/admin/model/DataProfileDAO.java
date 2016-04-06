package admin.model;

import java.util.List;
import java.util.Map;

public interface DataProfileDAO {

	public abstract String selectitem(String group, String id);
	
	public abstract DataProfileDAOBean selectitems(String group, String id);

	public abstract List<DataProfileDAOBean> select(String group);

	public abstract Map<String, String> selects(String group);

	public abstract List<DataProfileDAOBean> selectall();

	public abstract DataProfileDAOBean update(DataProfileDAOBean bean);
	
	public abstract DataProfileDAOBean insert(DataProfileDAOBean bean);

}