package login.model;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String MBR_MEMBERID;
	String MBR_NAME;
	String MBR_PWD;
	String MBR_SEX;
	String MBR_BIRTHDAY;
	String MBR_IDENTITY;
	String MBR_ARRDESS;
	String MBR_MOBIL;
	String MBR_EMAIL;
	
	public CustomerBean() {
		
	}
	
	
	public CustomerBean (String MBR_MEMBERID,String MBR_NAME,String MBR_PWD,String MBR_SEX,String MBR_BIRTHDAY,String MBR_IDENTITY,
							String MBR_ARRDESS,String MBR_MOBIL,String MBR_EMAIL) {
		super();
		this.MBR_MEMBERID = MBR_MEMBERID;
		this.MBR_NAME = MBR_NAME;
		this.MBR_PWD = MBR_PWD;
		this.MBR_SEX = MBR_SEX;
		this.MBR_BIRTHDAY = MBR_BIRTHDAY;
		this.MBR_IDENTITY = MBR_IDENTITY;
		this.MBR_ARRDESS = MBR_ARRDESS;
		this.MBR_MOBIL = MBR_MOBIL;
		this.MBR_EMAIL = MBR_EMAIL;
	} 
	
	
	@Override
	public String toString() {
		return "CustomerBean [MBR_NAME=" + MBR_NAME + ", MBR_PWD=" + MBR_PWD + ", MBR_SEX=" + MBR_SEX
				+ ", MBR_BIRTHDAY=" + MBR_BIRTHDAY + ", MBR_IDENTITY=" + MBR_IDENTITY + ", MBR_ARRDESS=" + MBR_ARRDESS
				+ ", MBR_MOBIL=" + MBR_MOBIL + ", MBR_EMAIL=" + MBR_EMAIL + ", MBR_MEMBERID=" + MBR_MEMBERID + "]";
	}
	
	public String getMBR_MEMBERID() {
		return MBR_MEMBERID;
	}
	public void setMBR_MEMBERID(String MBR_MEMBERID) {
		this.MBR_MEMBERID = MBR_MEMBERID;
	}
	
	public String getMBR_NAME() {
		return MBR_NAME;
	}
	public void setMBR_NAME(String MBR_NAME) {
		this.MBR_NAME = MBR_NAME;
	}
	
	public String getMBR_PWD() {
		return MBR_PWD;
	}
	public void setMBR_PWD(String MBR_PWD) {
		this.MBR_PWD = MBR_PWD;
	}
	
	public String getMBR_SEX() {
		return MBR_SEX;
	}
	public void setMBR_SEX(String MBR_SEX) {
		this.MBR_SEX = MBR_SEX;
	}
	
	public String getMBR_BIRTHDAY() {
		return MBR_BIRTHDAY;
	}
	public void setMBR_BIRTHDAY(String MBR_BIRTHDAY) {
		this.MBR_BIRTHDAY = MBR_BIRTHDAY;
	}
	
	public String getMBR_IDENTITY() {
		return MBR_IDENTITY;
	}
	public void setMBR_IDENTITY(String MBR_IDENTITY) {
		this.MBR_IDENTITY = MBR_IDENTITY;
	}
	
	public String getMBR_ARRDESS() {
		return MBR_ARRDESS;
	}
	public void setMBR_ARRDESS(String MBR_ARRDESS) {
		this.MBR_ARRDESS = MBR_ARRDESS;
	}
	
	public String getMBR_MOBIL() {
		return MBR_MOBIL;
	}
	public void setMBR_MOBIL(String MBR_MOBIL) {
		this.MBR_MOBIL = MBR_MOBIL;
	}
	
	public String getMBR_EMAIL() {
		return MBR_EMAIL;
	}
	public void setMBR_EMAIL(String MBR_EMAIL) {
		this.MBR_EMAIL = MBR_EMAIL;
	}
}
