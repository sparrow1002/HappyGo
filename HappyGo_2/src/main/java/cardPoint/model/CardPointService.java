package cardPoint.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.hibernate.type.SortedMapType;

import model.CustomerBean;
import model.CustomerService;
import AAA000.DayDevice;
import Administer.model.HG_PromotionBonus_Bean;
import Administer.model.HG_PromotionBonus_Service;
import Administer.model.HG_PromotionMethod_Bean;
import Administer.model.HG_PromotionMethod_Service;
import Administer.model.HG_PromotionProject_Bean;
import cardPoint.model.dao.CardPointDAO_JDBC;

public class CardPointService {
	private CardPointDAO pointDAO = new CardPointDAO_JDBC();
	private HG_PromotionBonus_Service pbService = new HG_PromotionBonus_Service();
	private HG_PromotionMethod_Service pmService = new HG_PromotionMethod_Service();
	private CustomerService custService = new CustomerService();
	
	private DayDevice dayDevice = new DayDevice();
	private String today = dayDevice.getToday();//今天yyyymmdd
	private String unUse = "1";//HG_DataProfile 未使用
	private String used = "0";//HG_DataProfile 已使用
	private String updateUser = "lib0405";//目前寫死 還沒寫
	private int lifeDay = 30;//dDate=today+lifeDay 目前寫死 should select from HG_DataProfile	
	
	public static void main(String[] args) {
		CardPointService service = new CardPointService();
		String memberId = "jdbc01";
		String dDate = service.today;
		//String dDate = "20161113";
		String status = "1";
		
		//System.out.println(service.dayDevice.calculateAfterDate(dDate,service.lifeDay));
		//System.out.println(service.calculateAddPoint(-200));
		/*System.out.println(service.parseMMdd("20071101"));
		System.out.println(service.parseMM("15750324"));*/
		String strValue = "03";
		
		/*List<CardPointBean> cpb = service.selectPoint(memberId, dDate, status);
		for(CardPointBean bean : cpb)
			System.out.println(bean);*/
		/*List<CardPointBean> cpb1 = service.unUsePoint(memberId);
		for(CardPointBean bean : cpb1)
			System.out.println(bean);*/
		/*int totalPoint = service.totalPoint(memberId);
		System.out.println("totalPoint= "+totalPoint);*/
		//System.out.println(service.LastPoint(memberId));
		//更改未使用點數狀態
		/*boolean updateUsePoint = service.updateUsePoint(54, cpb, 2016051300000001L);
		if(updateUsePoint){
			System.out.println("updateUsePoint OK");
		}else{
			System.out.println("updateUsePoint error");
		}*/
		//取消交易
		/*boolean cancelOk = service.cancelTran(201604110002L);
		if(cancelOk){
			System.out.println("cancelTran OK");
		}else{
			System.out.println("cancelTran error");
		}*/
		
		HG_PromotionProject_Bean proBean = new HG_PromotionProject_Bean();
		proBean.setPTP_PROJID(4);
		proBean.setPTP_CREATEDATE("20160301");
		proBean.setPTP_DELDATE("20160401");
		int cost = 100;
		int point = 30;
		//System.out.println(service.bonus(cost, point, proBean));
		System.out.println(service.confirm(memberId, proBean));
	}
	
	public List<CardPointBean> selectPoint(String memberId, String dDate, String status){
		List<CardPointBean> result = new ArrayList<CardPointBean>();
		result = pointDAO.selectPoint(memberId, dDate, status);
		return result;
	}
	
	public List<CardPointBean> unUsePoint(String memberId){
		List<CardPointBean> result = new ArrayList<CardPointBean>();
		result = pointDAO.selectPoint(memberId, today, unUse);
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
	
	public boolean updateUsePoint(int usePoint, List<CardPointBean> listBean, long useTranId){
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
			bean.setUseTranId(useTranId);
			bean.setUpdateUser(updateUser);
			boolean updateOk = pointDAO.update(bean);
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
				newBean.setUseTranId(useTranId);
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
	
	public boolean ddddddddd(String memberId, int totalCost, int discount){
		if( this.totalPoint(memberId) >= discount ){
			
		
		
		
		
			this.selectPoint(memberId, today, unUse);
		
			int cost = this.calculateCost(totalCost, discount);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean cancelTran(long tranId){
		//XXXXXXXXXXXXX-------------> update HG_Shopping's SOP_STATUS
		
		CardPointBean bean = new CardPointBean();
		CardPointBean newBean = new CardPointBean();
		bean = pointDAO.selectByTran(tranId);
		//update status
		bean.setStatus(used);
		bean.setUpdateUser(updateUser);
		boolean updateOk = pointDAO.update(bean);
		System.out.println("CardPointService cancelTran update:"+bean);
		//insert new point
		if (bean.getPointDre()>0 && updateOk) {
			newBean.setTranId(Long.parseLong(today));//目前暫訂
			newBean.setdDate(dayDevice.calculateAfterDate(today,this.lifeDay));
			newBean.setPointAdd(bean.getPointDre());
			newBean.setTranDate(today);
			newBean.setMemberId(bean.getMemberId());
			newBean.setStatus(unUse);
			newBean.setUpdateUser(updateUser);
			pointDAO.insert(newBean);
			System.out.println("CardPointService cancelTran insert:"+newBean);
			return true;
		} else if(bean.getPointDre()==0 && updateOk){
			return true;
		}
		return false;
	}
	//=================================================
	public int parseMMdd(String yyyyMMdd){
		String strMMdd = yyyyMMdd.substring(4);
		int MMdd = Integer.parseInt(strMMdd);
		return MMdd;
	}
	public int parseMM(String yyyyMMdd){
		String strMM = yyyyMMdd.substring(4, 6);
		int MM = Integer.parseInt(strMM);
		return MM;
	}
	//=================================================
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
	//--------------------------------------
	public int pointAdd(String memberId, int cost,List<HG_PromotionProject_Bean> proLisBean){
		int point = 0;
		
		int useProjID ;
		Map<Integer,Integer> returnMap = new TreeMap<Integer, Integer>();
		
		int originProBonus = 0;
		for(HG_PromotionProject_Bean proBean:proLisBean){//取原本永久活動
			if(proBean.getPTP_DELDATE()=="20991231"){
				originProBonus = this.floorBonus(cost, pbService.select(proBean.getPTP_PROJID()) );
			}
		}
		
		Map<Integer,Integer> pointMap = new TreeMap<Integer, Integer>();
		
		for(HG_PromotionProject_Bean proBean:proLisBean){
			int projId = proBean.getPTP_PROJID();
			point = this.bonus(memberId, cost, originProBonus, proBean);
			pointMap.put(projId, point);
		}
		
		
		for(int i=1; i<=pointMap.size() ; i++){
			useProjID = pointMap.keySet();
			point = pointMap.get(useProjID);
		}
		for(int key : pointMap.keySet()){
			useProjID = key;
			point = pointMap.get(key);
		}
		returnMap.put(useProjID, point);
		
			
			
		return point;
	}
	public int bonus(String memberId, int cost, int originProBonus, HG_PromotionProject_Bean proBean){
		int bonus = 0;
		List<HG_PromotionMethod_Bean> PMListBean = pmService.select(proBean.getPTP_PROJID());//dao
		List<HG_PromotionBonus_Bean> PBListBean = pbService.select(proBean.getPTP_PROJID());//dao ;use proBean.getId();
		
		bonus = this.floorBonus(cost, PBListBean);
		if(bonus==0){
			bonus = originProBonus;
		}
		
		bonus += this.confirmBonus(memberId, bonus, PMListBean);
				
		int fixPoint = proBean.getPTP_FIXPOINT();
		System.out.println("CardPointService bonus() fixPoint:"+fixPoint);
		if(fixPoint > 0){
			bonus += fixPoint;
		}
		return bonus;
	}
	
	public int floorBonus(int cost, List<HG_PromotionBonus_Bean> PBListBean){
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
	public int confirmBonus(String memberId, int bonus, List<HG_PromotionMethod_Bean> PMListBean){
		for(HG_PromotionMethod_Bean proMBean:PMListBean){
			if(this.confirm(memberId, proMBean)){
				String model = proMBean.getPTM_NAME();
				
				if(model == "1"){
					bonus += proMBean.getPTM_VARDATE();
				}else if(model == "2"){
					bonus = bonus*proMBean.getPTM_VARDATE();
				}
				
			}
		}
		
		return bonus;
	}
	//------------------------------------------
	public boolean confirm(String memberId, HG_PromotionMethod_Bean proMBean){
		CustomerBean memberBean = custService.login(memberId);//dao
		
		String model = proMBean.getPTM_model();
		switch (model) {
			case "1":
				if(!this.confirmMod1(memberBean, proMBean))
					return false;
				break;
			case "2":
				if(!this.confirmMod2(memberBean, proMBean))
					return false;
				break;
			case "3":
				if(!this.confirmMod3(memberBean, proMBean))
					return false;
				break;
			default:
				break;
		}
		
		return true;
	}
	
	public boolean confirmMod1(CustomerBean memberBean , HG_PromotionMethod_Bean proMBean){
		String birthday = memberBean.getMBR_BIRTHDAY();//生日mod
		String value = proMBean.getPTM_VALUE();
		System.out.println("CardPointService confirmMod1");
		switch (value) {
			case "1":
				int birthMMdd = this.parseMMdd(birthday);
				int todayMMdd = this.parseMMdd(today);
				System.out.println("CardPointService confirmMod1 case1");
				if(birthMMdd == todayMMdd){
					return true;
				}
				break;
			case "2":
				int birthMM = this.parseMM(birthday);
				int todayMM = this.parseMM(today);
				System.out.println("CardPointService confirmMod1 case2");
				if( birthMM == todayMM){
					return true;
				}
				break;
			default:
				break;
		}
		return false;
	}
	
	public boolean confirmMod2(CustomerBean memberBean , HG_PromotionMethod_Bean proMBean){
		String sex = memberBean.getMBR_SEX();//男女mod
		String value = proMBean.getPTM_VALUE();
		System.out.println("CardPointService confirmMod2");
		if(sex==value){
			return true;
		}
		return false;
	}
	public boolean confirmMod3(CustomerBean memberBean , HG_PromotionMethod_Bean proMBean){
		String memberId = memberBean.getMBR_MEMBERID();//介紹人mod
		int num = 0;//推薦數 目前寫死還沒寫
		//String strOper = proMBean.getPTM_OPER();
		String strValue = proMBean.getPTM_VALUE();
		int value = Integer.parseInt(strValue);
		System.out.println("CardPointService confirmMod3");
		if(num == value){
			return true;
		}
		return false;
	}
		
}
