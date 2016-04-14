package MemberInfo.model;

import model.CustomerBean;

public interface MemberDAO {

	MemberBean select(String MBR_MEMBERID);

	MemberBean update(String MBR_MEMBERID, String MBR_EMAIL, String MBR_NAME, String MBR_PWD, String MBR_MOBIL);

	boolean insert(String MBR_MEMBERID, String MBR_NAME, String MBR_PWD, String MBR_MOBIL, String MBR_EMAIL);

	boolean delete(String MBR_MEMBERID);

}