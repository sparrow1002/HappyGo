package MemberInfo.model;

import java.util.Arrays;

import MemberInfo.dao.MemberDAOJdbc;
import model.CustomerDAO;
import model.dao.CustomerDAOJdbc;

public class MemberService {
	private MemberDAOJdbc dao = new MemberDAOJdbc();

	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean bean = service.login("b00003");
		System.out.println(bean);
	}
	
	public MemberBean login(String MBR_MEMBERID) {
		MemberBean result = dao.select(MBR_MEMBERID);
		return result;
	}

	public boolean insert(String MBR_MEMBERID, String MBR_NAME,
			String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL){
		boolean b = dao.insert(MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_MOBIL, MBR_EMAIL);
		return b;
	}
	
	public MemberBean update(String MBR_MEMBERID, String MBR_NAME,
			String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL){
		MemberBean bean = dao.update(MBR_MEMBERID, MBR_NAME, MBR_PWD, MBR_MOBIL, MBR_EMAIL);
		return bean;
	}	
}
