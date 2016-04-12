package Administer.model;

import java.util.List;

public interface HG_PromotionMethod_DAO {
	public abstract List<HG_PromotionMethod_Bean> select(int projId);
	public abstract int update(HG_PromotionMethod_Bean bean);
	public abstract int insert(HG_PromotionMethod_Bean bean);
}
