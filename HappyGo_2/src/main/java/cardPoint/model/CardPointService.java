package cardPoint.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Administer.model.HG_PromotionBonus_Bean;
import cardPoint.model.dao.CardPointDAO_JDBC;

public class CardPointService {
	private CardPointDAO pointDAO = new CardPointDAO_JDBC();
	private String today = this.getToday();//今天yyyymmdd
	private String unUse = "1";//HG_DataProfile 未使用
	private String used = "2";//HG_DataProfile 已使用
	private String updateUser = "lib0405";//目前寫死 還沒寫
	private int lifeDay = 30;//dDate=today+lifeDay 目前寫死 should select from HG_DataProfile	
	
	public static void main(String[] args) {
		CardPointService service = new CardPointService();
		String memberId = "jdbc03";
		String dDate = service.today;
		//String dDate = "20161113";
		String status = "1";
		
		//System.out.println(service.calculateAfterDate(dDate,service.lifeDay));
		//System.out.println(service.calculateAddPoint(-200));
		
		
		/*List<CardPointBean> cpb = service.selectPoint(memberId, dDate, status);
		for(CardPointBean bean : cpb)
			System.out.println(bean);*/
		/*int totalPoint = service.totalPoint(memberId);
		System.out.println("totalPoint= "+totalPoint);*/
		//System.out.println(service.LastPoint(memberId));
		//更改未使用點數狀態
		/*boolean updateUsePoint = service.updateUsePoint(54, cpb, "test0405");
		if(updateUsePoint){
			System.out.println("updateUsePoint OK");
		}else{
			System.out.println("updateUsePoint error");
		}*/
		//取消交易
		/*boolean cancelOk = service.cancelTran("TRANID1");
		if(cancelOk){
			System.out.println("cancelTran OK");
		}else{
			System.out.println("cancelTran error");
		}*/
	}
	
	public List<CardPointBean> selectPoint(String memberId, String dDate, String status){
		List<CardPointBean> result = new ArrayList<CardPointBean>();
		result = pointDAO.selectPoint(memberId, dDate, status);
		return result;
	}
	
	public int totalPoint(String memberId){
		int point = 0;
		for(CardPointBean bean : this.selectPoint(memberId, today, unUse)){
			point = point + bean.getPointAdd();
		}
		return point;
	}
	
	public CardPointBean LastPoint(String memberId){
		return pointDAO.selectLastPoint(memberId, today, unUse);
	}
	
	public boolean updateUsePoint(int usePoint, List<CardPointBean> listBean, String tranId){
		CardPointBean bean = new CardPointBean();
		CardPointBean newBean = new CardPointBean();
		int size = listBean.size();
		System.out.println("CardPointService updateUsePoint size= "+size);
		int i=0;
		while(i < size){
			System.err.println("CardPointService updateUsePoint i="+i);
			bean = listBean.get(i);
			int point = bean.getPointAdd();
			System.out.println("CardPointService updateUsePoint point="+point);
			usePoint = usePoint - point;
			System.out.println("CardPointService updateUsePoint usePoint="+usePoint);
			bean.setStatus(used);
			bean.setUseTranId(tranId);
			bean.setUpdateUser(updateUser);
			boolean updateOk = pointDAO.update(unUse , bean);
			System.out.println("CardPointService updateUsePoint updateOk:"+updateOk);
			System.out.println("CardPointService updateUsePoint update:"+bean);
			if(usePoint > 0){
				i++;
			}else if(usePoint < 0){
				usePoint = 0 - usePoint;
				newBean.setTranId(bean.getTranId());
				newBean.setdDate(bean.getdDate());
				newBean.setPointAdd(usePoint);//
				newBean.setPointDre(bean.getPointDre());
				newBean.setTranDate(bean.getTranDate());
				newBean.setMemberId(bean.getMemberId());
				newBean.setStatus(unUse);
				newBean.setUseTranId(tranId);
				newBean.setUpdateUser(updateUser);
				boolean insertOk = pointDAO.insert(newBean);
				System.out.println("CardPointService updateUsePoint insertOk:"+insertOk);
				System.out.println("CardPointService updateUsePoint insert:"+newBean);
				System.out.println("CardPointService updateUsePoint usePoint < 0 i="+i);
				return true;
			}else if(usePoint == 0){
				System.out.println("CardPointService updateUsePoint usePoint == 0 i="+i);
				return true;
			}
		}
		return false;
	}
	
	public boolean ddddddddd(String memberId , int totalCost, int discount){
		if( this.totalPoint(memberId) >= discount ){
			
		
		
		
		
			this.selectPoint(memberId, today, unUse);
		
			int cost = this.calculateCost(totalCost, discount);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean cancelTran(String tranId){
		//XXXXXXXXXXXXX-------------> update HG_Shopping's SOP_STATUS
		
		CardPointBean bean = new CardPointBean();
		CardPointBean newBean = new CardPointBean();
		bean = pointDAO.selectByTran(tranId);
		//update status
		bean.setStatus(used);
		bean.setUpdateUser(updateUser);
		boolean updateOk = pointDAO.update(unUse , bean);
		System.out.println("CardPointService cancelTran update:"+bean);
		//insert new point
		if (bean.getPointDre()>0 && updateOk) {
			newBean.setTranId(today);//目前暫訂
			newBean.setdDate(this.calculateAfterDate(today,this.lifeDay));
			newBean.setPointAdd(bean.getPointDre());
			newBean.setTranDate(today);
			newBean.setMemberId(bean.getMemberId());
			newBean.setStatus(unUse);
			newBean.setUpdateUser(updateUser);
			pointDAO.insert(newBean);
			System.out.println("CardPointService cancelTran insert:"+newBean);
			return true;
		}
		return false;
	}
	//=================================================
	public String getToday(){
		java.util.Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");       
	    String strToday = sdf.format(date);       
	    return strToday;
	}
	public String calculateAfterDate(String strDate, int addDay){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		java.util.Date date = null;
		String strAfterDate = null;
		try {
			date = sdf.parse(strDate);
			java.util.Date afterDate = new Date(date.getTime() + 1000L*3600*24*addDay); 
			strAfterDate = sdf.format(afterDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strAfterDate;
	}
	public int calculateCost(int totalCost, int discount){
		int cost = totalCost - discount;
		return cost;
	}
	public int calculateAddPoint(int cost){
		int addPoint=0;
		int floorHeight = 100;//HG_DataProfile
		int point = 10;//HG_DataProfile
		int i=1;
		while(cost/(floorHeight*i) > 0){
			addPoint += point ; 
			i++ ;
		}
		return addPoint;
	}
	public int getFixPoint(){
		//HG_PromotionProject_Bean bean = new HG_PromotionProject_Bean();
		//bean = HG_PromotionProjectDAO.select(PTP_PROJID);
		//int fixPoint = bean.getPTP_FIXPOINT();
		int fixPoint = 10;
		return fixPoint;
	}
	public int calculateBonus(int cost, List<HG_PromotionBonus_Bean> PBListBean){
		int bonus = 0;
		for(HG_PromotionBonus_Bean bean:PBListBean){
			if(cost >= bean.getPTB_VALUE() ){
				bonus = bean.getPTB_POINT();				
			}else if(cost < bean.getPTB_VALUE() ){
				break;
			}
		}
		return bonus;
	}
	public boolean confirmMember(){
		
		return false;
	}
}
