package Administer.model;

import java.util.ArrayList;
import java.util.List;

import Administer.model.dao.HG_PromotionMethod_DAOJdbc;

public class HG_PromotionMethod_Service {
	private HG_PromotionMethod_DAO dao = new HG_PromotionMethod_DAOJdbc();
	
	public static void main(String args[]){
		HG_PromotionMethod_Service service = new HG_PromotionMethod_Service();
		for(HG_PromotionMethod_Bean bean:service.select(1))
			System.out.println(bean);
	}
	
	public List<HG_PromotionMethod_Bean> select(int projId){
		List<HG_PromotionMethod_Bean> result = new ArrayList<>();
		result = dao.select(projId);
		return result;
	}
	
	public int update(List<HG_PromotionMethod_Bean> beanList){
		int i = 0;
		for(HG_PromotionMethod_Bean bean:beanList){
			i += dao.update(bean);
		}
		return i;
	} 
	
	public int insert(List<HG_PromotionMethod_Bean> beanList){
		int i = 0;
		for(HG_PromotionMethod_Bean bean:beanList){
			i += dao.insert(bean);
		}
		return i;
	} 
}
