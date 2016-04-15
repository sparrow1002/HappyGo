package Administer.model;

import java.util.ArrayList;
import java.util.List;

import Administer.model.dao.HG_PromotionBonus_DAOJdbc;

public class HG_PromotionBonus_Service {
	private HG_PromotionBonus_DAO dao = new HG_PromotionBonus_DAOJdbc();
	
	public static void main(String args[]){
		HG_PromotionBonus_Service service = new HG_PromotionBonus_Service();
		for(HG_PromotionBonus_Bean bean:service.select(2))
			System.out.println(bean);
	}
	
	public List<HG_PromotionBonus_Bean> select(int projId){
		List<HG_PromotionBonus_Bean> result = new ArrayList<HG_PromotionBonus_Bean>();
		result = dao.select(projId);
		return result;
	}
	
	public int update(List<HG_PromotionBonus_Bean> beanList){
		int i = 0;
		for(HG_PromotionBonus_Bean bean:beanList){
			i += dao.update(bean);
		}
		return i;
	}
	
	public int insert(List<HG_PromotionBonus_Bean> beanList){
		int i = 0;
		for(HG_PromotionBonus_Bean bean:beanList){
			i += dao.insert(bean);
		}
		return i;
	}
}
