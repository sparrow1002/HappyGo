package common.model;

import java.util.List;

public interface CardInfoDAO {

	public abstract CardInfoDAOBean select(CardInfoDAOBean bean);

	public abstract List<CardInfoDAOBean> select();

	public abstract CardInfoDAOBean update(CardInfoDAOBean bean);

	public abstract CardInfoDAOBean insert(CardInfoDAOBean bean);

	public abstract CardInfoDAOBean delete(CardInfoDAOBean bean);

}