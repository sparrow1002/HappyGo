package Administer.model;

import java.util.List;

public interface HG_PromotionProject_DAO {

	HG_PromotionProject_Bean select(String PTP_PROJID);

	List<HG_PromotionProject_Bean> select();

	HG_PromotionProject_Bean update(HG_PromotionProject_Bean bean);

	HG_PromotionProject_Bean insert(HG_PromotionProject_Bean bean);

}
