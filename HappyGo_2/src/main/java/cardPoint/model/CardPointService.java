package cardPoint.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.hibernate.type.SortedMapType;

import shopping.model.ShoppingBean;
import shopping.model.ShoppingDAO;
import shopping.model.dao.ShoppingDAO_JDBC;
import model.CustomerBean;
import model.CustomerService;
import AAA000.DayDevice;
import API.APIIntoBean;
import API.APIReturnBean;
import Administer.model.HG_PromotionBonus_Bean;
import Administer.model.HG_PromotionBonus_Service;
import Administer.model.HG_PromotionMethod_Bean;
import Administer.model.HG_PromotionMethod_Service;
import Administer.model.HG_PromotionProject_Bean;
import Administer.model.HG_PromotionProject_Service;
import Administer.model.dao.HG_PromotionProject_DAOJdbc;
import cardPoint.model.dao.CardPointDAO_JDBC;

@Path("/pointsAPI")
public class CardPointService {
	private CardPointDAO pointDAO = new CardPointDAO_JDBC();
	private ShoppingDAO shoppingDAO = new ShoppingDAO_JDBC();
	private HG_PromotionProject_DAOJdbc projDAO = new HG_PromotionProject_DAOJdbc();
	private static HG_PromotionProject_Service proService = new HG_PromotionProject_Service();
	private static HG_PromotionBonus_Service pbService = new HG_PromotionBonus_Service();
	private static HG_PromotionMethod_Service pmService = new HG_PromotionMethod_Service();
	private static CustomerService custService = new CustomerService();
	
	private DayDevice dayDevice = new DayDevice();
	private String today = dayDevice.getToday();//今天yyyymmdd
	private String unUse = "1";//HG_DataProfile 未使用
	private String used = "0";//HG_DataProfile 已使用
	private String tranOkStatus = "1";
	private String cancelTranStatus = "0";
	private String updateUser = "lib0405";//目前寫死 還沒寫
	private int lifeDay = 30;//dDate=today+lifeDay 目前寫死 should select from HG_DataProfile	
	private int exchangePoint = 10;//目前寫死 還沒寫 HG_DataProfile 點數換現金比例
	
	public static void main(String[] args) {
		CardPointService service = new CardPointService();
		String memberId = "mb01";
		String today = service.today;
		String dDate = today;
		//String dDate = "20161113";
		String status = "1";
		String storeId = "001";
		//System.out.println(service.dayDevice.calculateAfterDate(dDate,service.lifeDay));
		//System.out.println(service.calculateAddPoint(-200));
		/*System.out.println(service.parseMMdd("20071101"));
		System.out.println(service.parseMM("15750324"));*/
		String strValue = "03";
		String sex = "1";
		//System.out.println(sex.equals(status));
		
		/*List<CardPointBean> cpb = service.selectPoint(memberId, dDate, status);
		for(CardPointBean bean : cpb)
			System.out.println(bean);*/
		/*List<CardPointBean> cpb1 = service.unUsePoint(memberId);
		for(CardPointBean bean : cpb1)
			System.out.println(bean);*/
		int totalPoint = service.totalPoint(memberId);
		System.out.println("totalPoint= "+totalPoint);
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
		/*List<HG_PromotionProject_Bean> proListBean = proService.selectToday(today,storeId);
		HG_PromotionProject_Bean proBean = proListBean.get(0);
		System.out.println(proBean);*/
//		HG_PromotionProject_Bean proBean = new HG_PromotionProject_Bean();
//		proBean.setPTP_PROJID(4);
//		proBean.setPTP_FIXPOINT(10);
//		proBean.setPTP_CREATEDATE("20160301");
//		proBean.setPTP_DELDATE("20160401");
		int cost = 500;
		int point = 30;
		//System.out.println(service.bonus(cost, point, proBean));
		/*int projId = proBean.getPTP_PROJID();
		HG_PromotionMethod_Bean proMBean = pmService.select(projId).get(0);
		System.out.println(service.confirm(memberId, proMBean));*/
		System.out.println("----------------------");
		
		/*List<HG_PromotionMethod_Bean> PMListBean = new ArrayList<HG_PromotionMethod_Bean>();
		PMListBean.add(proMBean);
		for(HG_PromotionMethod_Bean bean:PMListBean)
			System.out.println(bean);
		System.out.println(service.confirmBonus(memberId, 0, PMListBean));*/
		
		/*List<HG_PromotionBonus_Bean> PBListBean = new ArrayList<HG_PromotionBonus_Bean>();
		PBListBean = pbService.select(projId);
		System.out.println(service.floorBonus(cost, PBListBean));*/
		
		//System.out.println(service.bonus(memberId, cost, 10, proBean));
		
		//System.out.println(service.pointAdd(memberId, cost, proListBean));
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
	
	@POST
	@Produces("text/plain")
	public int totalPoint(@QueryParam("memberId") String memberId){
		int point = 0;
		for(CardPointBean bean : this.selectPoint(memberId, today, unUse)){
			point = point + bean.getPointAdd();
		}
		return point;
	}
	
	public CardPointBean LastPoint(String memberId){
		return pointDAO.selectLastPoint(memberId, today, unUse);
	}
	
	@GET
	@Path("/{point}")
	@Produces("text/plain")
	public int calculateDiscount(@PathParam("point") int point){
		int discount = point/exchangePoint;
		return discount;
	}
	
	public boolean updateUsePoint(int usePoint, List<CardPointBean> listBean, String useTranId){
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
	
	@POST
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public APIReturnBean transactionAPI(APIIntoBean apiIntoBean){
		String tranId = apiIntoBean.getTranId();//SOP_TRANID
		String memberId = apiIntoBean.getMemberId();
		String storeId = apiIntoBean.getStoreId();//SOP_STOREID
		int usePoint = apiIntoBean.getUsePoint();//CPT_POINTDRE
		int cost = apiIntoBean.getCost();//SOP_TRANAMT
		int discount = this.calculateDiscount(usePoint);//SOP_DISCOUNT
		
		int totalPoint = this.totalPoint(memberId);
		
		APIReturnBean apiReturnBean = new APIReturnBean();
		
		
		if( totalPoint >= usePoint ){
			List<HG_PromotionProject_Bean> proListBean = proService.selectToday(today,storeId);
			PointAddBean pointAddBean = this.pointAdd(memberId, cost, proListBean);
			int projId = pointAddBean.getProjId();//SOP_PROJID
			int pointAdd = pointAddBean.getPointAdd();//CPT_POINTADD
			int overPoint = totalPoint - usePoint;//SOP_overPoint
			
			ShoppingBean shopBean = new ShoppingBean();
			shopBean.setTranId(tranId);
			shopBean.setTranAmt(cost);
			shopBean.setDisCount(discount);
			shopBean.setMemberId(memberId);
			shopBean.setStatus(tranOkStatus);
			shopBean.setProjId(projId);
			shopBean.setStoreId(storeId);
			shopBean.setOverPoint(overPoint);
			shopBean.setTranDate(today);
			shopBean.setUpdateUser(updateUser);
			boolean shopInsertResult = shoppingDAO.insert(shopBean);
			if(!shopInsertResult){
				apiReturnBean.setResult(false);
				apiReturnBean.setOverPoint(totalPoint);
				return apiReturnBean;
			}
			String dDate = today + lifeDay;
			CardPointBean pointBean = new CardPointBean();
			pointBean.setTranId(tranId);
			pointBean.setdDate(dDate);
			pointBean.setPointAdd(pointAdd);
			pointBean.setPointDre(usePoint);
			pointBean.setTranDate(today);
			pointBean.setMemberId(memberId);
			pointBean.setStatus(unUse);
			//useTranId
			pointBean.setUpdateUser(updateUser);
			boolean pointInsertResult = pointDAO.insert(pointBean);
			if(!pointInsertResult){
				apiReturnBean.setResult(false);
				apiReturnBean.setOverPoint(totalPoint);
				return apiReturnBean;
			}
			
			List<CardPointBean> pointListBean = this.selectPoint(memberId, today, unUse);
			boolean updateUsePointResult= this.updateUsePoint(usePoint, pointListBean, tranId);
			if(!updateUsePointResult){
				apiReturnBean.setResult(false);
				apiReturnBean.setOverPoint(totalPoint);
				return apiReturnBean;
			}
			
			apiReturnBean.setOverPoint(overPoint);
			apiReturnBean.setResult(true);
			
			return apiReturnBean;
		}else{
			apiReturnBean.setResult(false);
			apiReturnBean.setOverPoint(totalPoint);
			return apiReturnBean;
		}
	}
	
	public boolean cancelTran(String tranId){
		//-------update HG_Shopping's SOP_STATUS------
		ShoppingBean shopBean = new ShoppingBean();
		shopBean.setTranId(tranId);
		shopBean.setUpdateUser(updateUser);
		boolean shopUpdateOk = shoppingDAO.update(cancelTranStatus, shopBean);
		
		//----------HG_CardPoint--------
		CardPointBean bean = new CardPointBean();
		CardPointBean newBean = new CardPointBean();
		bean = pointDAO.selectByTran(tranId);
		//update status
		bean.setStatus(used);
		bean.setUpdateUser(updateUser);
		boolean pointUpdateOk = pointDAO.update(bean);
		System.out.println("CardPointService cancelTran update:"+bean);
		//insert new point
		if (bean.getPointDre()>0 && pointUpdateOk) {
			newBean.setTranId(tranId);
			newBean.setdDate(dayDevice.calculateAfterDate(today,this.lifeDay));
			newBean.setPointAdd(bean.getPointDre());
			newBean.setTranDate(today);
			newBean.setMemberId(bean.getMemberId());
			newBean.setStatus(unUse);
			newBean.setUpdateUser(updateUser);
			pointDAO.insert(newBean);
			System.out.println("CardPointService cancelTran insert:"+newBean);
			return true;
		} else if(bean.getPointDre()==0 && pointUpdateOk){
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
	
//	public int calculateAddPoint(int cost){
//		int addPoint=0;
//		int floorHeight = 100;//HG_DataProfile
//		int point = 10;//HG_DataProfile
//		int i=1;
//		while(cost/(floorHeight*i) > 0){
//			addPoint += point ; 
//			i++ ;
//		}
//		return addPoint;
//	}
	//--------------------------------------
	
	public PointAddBean pointAdd(String memberId, int cost,List<HG_PromotionProject_Bean> proListBean){
		int point = 0;
		//Map<Integer,Integer> returnMap = new TreeMap<Integer, Integer>();
		PointAddBean pointAddbean = new PointAddBean(); 
		
		int originProBonus = 0;
		List<HG_PromotionProject_Bean> proForeverListBean = projDAO.selectforever();
		HG_PromotionProject_Bean proForeverBean = proForeverListBean.get(0);
		originProBonus = this.floorBonus(cost, pbService.select(proForeverBean.getPTP_PROJID()) );
//		for(HG_PromotionProject_Bean proBean:proListBean){//取原本永久活動
//			if(proBean.getPTP_DELDATE()=="20991231"){
//				originProBonus = this.floorBonus(cost, pbService.select(proBean.getPTP_PROJID()) );
//			}
//		}
		
		int max_point=0, max_projId = 0;
		for(HG_PromotionProject_Bean proBean:proListBean){
			int projId = proBean.getPTP_PROJID();
			point = this.bonus(memberId, cost, originProBonus, proBean);
			System.err.println("CardPointService pointAdd Map:(projId:"+projId+",point:"+point+")");
			if(point >= max_point){
				max_point = point;
				max_projId = projId;
			}
		}
		pointAddbean.setProjId(max_projId);
		pointAddbean.setPointAdd(max_point);
		return pointAddbean;
	}
	
	public int bonus(String memberId, int cost, int originProBonus, HG_PromotionProject_Bean proBean){
		int bonus = 0;
		List<HG_PromotionBonus_Bean> PBListBean = pbService.select(proBean.getPTP_PROJID());//dao ;use proBean.getId();
		List<HG_PromotionMethod_Bean> PMListBean = pmService.select(proBean.getPTP_PROJID());//dao
		
		
		if(PBListBean.size()>0){
			bonus = this.floorBonus(cost, PBListBean);
			System.out.println("CardPointService bonus floorBonus bonus:"+bonus);
		}
		
		if(bonus==0){
			bonus = originProBonus;			
		}
		
		System.out.println("CardPointService bonus:"+bonus);
		
		if(PMListBean.size()>0){
			bonus = this.confirmBonus(memberId, bonus, PMListBean);
			System.out.println("CardPointService bonus confirmBonus bonus:"+bonus);
		}
		System.out.println("CardPointService bonus:"+bonus);
		
		if(proBean.getPTP_FIXPOINT()>0){
			int fixPoint = proBean.getPTP_FIXPOINT();
			System.out.println("CardPointService bonus fixPoint:"+fixPoint);
			bonus += fixPoint;
			System.out.println("CardPointService bonus fixPoint bonus:"+bonus);			
		}
		System.out.println("CardPointService bonus:"+bonus);
//		if(fixPoint > 0){
//			
//		}
		return bonus;
	}
	
	public int floorBonus(int cost, List<HG_PromotionBonus_Bean> PBListBean){
		int bonus = 0;
		for(HG_PromotionBonus_Bean bean:PBListBean){
			if(cost >= bean.getPTB_VALUE() ){
				System.out.println("CardPointService floorBonus bonusInto:"+bonus);
				bonus = bean.getPTB_POINT();
				System.out.println("CardPointService floorBonus bonusReturn:"+bonus);
				
			}else if(cost < bean.getPTB_VALUE() ){
				System.out.println("CardPointService floorBonus break");
				break;
			}
		}
		return bonus;
	}
	public int confirmBonus(String memberId, int bonus, List<HG_PromotionMethod_Bean> PMListBean){
		for(HG_PromotionMethod_Bean proMBean:PMListBean){
			if(this.confirm(memberId, proMBean)){
				String model = proMBean.getPTM_NAME();
				System.out.println("CardPointService confirmBonus model:"+model);
				switch (model) {
					case "1":
						System.out.println("CardPointService confirmBonus model'1' bonusInto:"+bonus);
						bonus += proMBean.getPTM_VARDATE();
						System.out.println("CardPointService confirmBonus model'1' bonusReturn:"+bonus);
						break;
					case "2":
						System.out.println("CardPointService confirmBonus model'2' bonusInto:"+bonus);
						bonus = bonus*proMBean.getPTM_VARDATE();
						System.out.println("CardPointService confirmBonus model'2' bonusReturn:"+bonus);
						break;
					default:
						System.out.println("CardPointService confirmBonus model'default' break ");
						break;
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
				if(birthMMdd == todayMMdd){
					System.out.println("CardPointService confirmMod1 MMdd");
					return true;
				}
				break;
			case "2":
				int birthMM = this.parseMM(birthday);
				int todayMM = this.parseMM(today);
				if( birthMM == todayMM){
					System.out.println("CardPointService confirmMod1 MM");
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
		if(sex.equals(value)){
			System.out.println("CardPointService confirmMod2");
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
		if(num == value){
			System.out.println("CardPointService confirmMod3");
			return true;
		}
		return false;
	}
		
}
