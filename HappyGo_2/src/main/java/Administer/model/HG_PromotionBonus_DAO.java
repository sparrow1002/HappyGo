package Administer.model;

import java.util.List;

public interface HG_PromotionBonus_DAO {
	public abstract List<HG_PromotionBonus_Bean> select(int projId);
	public abstract int update(HG_PromotionBonus_Bean bean); 
	public abstract int insert(HG_PromotionBonus_Bean bean);
}
