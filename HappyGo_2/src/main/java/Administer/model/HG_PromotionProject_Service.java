package Administer.model;

import java.util.ArrayList;
import java.util.List;

import Administer.model.dao.HG_PromotionProject_DAOJdbc;

public class HG_PromotionProject_Service {

	private HG_PromotionProject_DAOJdbc PromotionProjectDao = new HG_PromotionProject_DAOJdbc();

	public int insert(HG_PromotionProject_Bean bean) {
		// 活動編號可在寫入資料庫時由資料庫新增或由這邊加入，前提是bean必須在這邊包裝
		int result = 0;
		if (bean != null) {
			result = PromotionProjectDao.insert(bean);
		}
		return result;
	}

	public int update(HG_PromotionProject_Bean bean) {
		int result = 0;
		if (bean != null) {
			System.out.println("This is Update Service");
			result = PromotionProjectDao.update(bean);
		}
		return result;
	}
	
	public List<HG_PromotionProject_Bean> selectToday(String today,String storeId){
		List<HG_PromotionProject_Bean> result;
		result = PromotionProjectDao.selectToday(today,storeId);
		return result;
	}

	// select有SELECT_BY_ID、SELECT_BETWEEN_TIME、SELECT_BY_NAME、SELECT_ALL

	public List<HG_PromotionProject_Bean> select(HG_PromotionProject_Bean bean) {
		List<HG_PromotionProject_Bean> result = null;
		if (bean != null && bean.getPTP_PROJID() != 0) {

			HG_PromotionProject_Bean selectById = PromotionProjectDao.select(bean.getPTP_PROJID());
			if (bean.getPTP_PROJID() != 0) {
				// 如果有輸入活動編號，顯示相關結果
				result = new ArrayList<HG_PromotionProject_Bean>();
				result.add(selectById);
				System.out.println("This is 編號查詢");
			}
		} else if (bean.getPTP_NAME() != "") {
			// 如果有輸入活動名稱關鍵字，顯示相關結果
			List<HG_PromotionProject_Bean> selectByName = PromotionProjectDao.select(bean.getPTP_NAME());
			result = new ArrayList<HG_PromotionProject_Bean>();
			result.addAll(selectByName);
			System.out.println("This is 關鍵字查詢");
		} 
		else if (bean.getPTP_CREATEDATE().length() > 0  && bean.getPTP_DELDATE().length() > 0) {
			// 如果有輸入日期，顯示相關結果。
			List<HG_PromotionProject_Bean> selectBetweenTime = PromotionProjectDao.select(bean.getPTP_CREATEDATE(),
					bean.getPTP_DELDATE());
			result = new ArrayList<HG_PromotionProject_Bean>();
			result.addAll(selectBetweenTime);
			System.out.println("This is 日期查詢");
		} else {
			// 如果都沒輸入，顯示全部結果。
			result = PromotionProjectDao.selectAll();
			System.out.println("This is 全部查詢");
		}
		return result;
	}
}