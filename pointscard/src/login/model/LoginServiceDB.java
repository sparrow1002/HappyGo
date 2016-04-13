package login.model;


//20160330 尚未加加解密的功能，尚未測試。
public class LoginServiceDB  {	
	private LoginDAO dao = new LoginJDBC();
	
	public CustomerBean login(String MBR_MEMBERID, String MBR_PWD) {
		
		System.out.println("LoginServiceTest    " + MBR_MEMBERID + "  " + MBR_PWD);
		
		CustomerBean bean = dao.select(MBR_MEMBERID);
		if(bean!=null) {
			String ps = bean.getMBR_PWD();
			
			String userPass = MBR_PWD;
			
			if(ps.equals(userPass)) {
				
				return bean;	
			}
		}		
		return null;
	}
}
