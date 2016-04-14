package model;

import java.sql.Date;
import java.util.Arrays;

public class CustomerBean {
	private String MBR_MEMBERID;	//	MBR_MEMBERID	varchar(10),
	private String MBR_NAME;		//	MBR_NAME	    nvarchar(10),
	private String MBR_PWD;			//	MBR_PWD	        varchar(10),
	private String MBR_SEX;			//	MBR_SEX	        char(1),
	private String MBR_BIRTHDAY;	//	MBR_BIRTHDAY	char(8),	--2016-03-05
	private String MBR_IDENTITY;	//	MBR_IDENTITY char(10),	--2016-03-04
	private String MBR_POST;		//	MBR_POST	    varchar(5),
	private String MBR_ARRDESS;		//	MBR_ARRDESS	    nvarchar(50),
	private String MBR_MARRIED;		//	MBR_MARRIED	    char(1),
	private String MBR_MOBIL;		//	MBR_MOBIL	    varchar(10),
	private String MBR_PHONE;		//	MBR_PHONE	    varchar(10),
	private String MBR_EMAIL;		//	MBR_EMAIL	    varchar(40),	--2016-03-04
	private String MBR_CREATEDATE;	//	MBR_CREATEDATE	char(8),	--2016-03-05	
	private String MBR_DELDATE;		//	MBR_DELDATE	    char(8),	--2016-03-05
	private int MBR_POINTS;		//	MBR_POINTS	    numeric(10),
	private String MBR_STATUS;		//	MBR_STATUS	    char(1),
	private String MBR_INTRODUCER;	//	MBR_INTRODUCER	nvarchar(10),		--2016-03-04
	private Date MBR_UPDATETIME;	//	MBR_UPDATETIME	datetime,	--yyyy/MM/dd hh:mm:ss
	private String MBR_UPDATEUSER;	//	MBR_UPDATEUSER	varchar(10) 
	public String getMBR_MEMBERID() {
		return MBR_MEMBERID;
	}
	public void setMBR_MEMBERID(String mBR_MEMBERID) {
		MBR_MEMBERID = mBR_MEMBERID;
	}
	public String getMBR_NAME() {
		return MBR_NAME;
	}
	public void setMBR_NAME(String mBR_NAME) {
		MBR_NAME = mBR_NAME;
	}
	public String getMBR_PWD() {
		return MBR_PWD;
	}
	public void setMBR_PWD(String mBR_PWD) {
		MBR_PWD = mBR_PWD;
	}
	public String getMBR_SEX() {
		return MBR_SEX;
	}
	public void setMBR_SEX(String mBR_SEX) {
		MBR_SEX = mBR_SEX;
	}
	public String getMBR_BIRTHDAY() {
		return MBR_BIRTHDAY;
	}
	public void setMBR_BIRTHDAY(String mBR_BIRTHDAY) {
		MBR_BIRTHDAY = mBR_BIRTHDAY;
	}
	public String getMBR_IDENTITY() {
		return MBR_IDENTITY;
	}
	public void setMBR_IDENTITY(String mBR_IDENTITY) {
		MBR_IDENTITY = mBR_IDENTITY;
	}
	public String getMBR_POST() {
		return MBR_POST;
	}
	public void setMBR_POST(String mBR_POST) {
		MBR_POST = mBR_POST;
	}
	public String getMBR_ARRDESS() {
		return MBR_ARRDESS;
	}
	public void setMBR_ARRDESS(String mBR_ARRDESS) {
		MBR_ARRDESS = mBR_ARRDESS;
	}
	public String getMBR_MARRIED() {
		return MBR_MARRIED;
	}
	public void setMBR_MARRIED(String mBR_MARRIED) {
		MBR_MARRIED = mBR_MARRIED;
	}
	public String getMBR_MOBIL() {
		return MBR_MOBIL;
	}
	public void setMBR_MOBIL(String mBR_MOBIL) {
		MBR_MOBIL = mBR_MOBIL;
	}
	public String getMBR_PHONE() {
		return MBR_PHONE;
	}
	public void setMBR_PHONE(String mBR_PHONE) {
		MBR_PHONE = mBR_PHONE;
	}
	public String getMBR_EMAIL() {
		return MBR_EMAIL;
	}
	public void setMBR_EMAIL(String mBR_EMAIL) {
		MBR_EMAIL = mBR_EMAIL;
	}
	public String getMBR_CREATEDATE() {
		return MBR_CREATEDATE;
	}
	public void setMBR_CREATEDATE(String mBR_CREATEDATE) {
		MBR_CREATEDATE = mBR_CREATEDATE;
	}
	public String getMBR_DELDATE() {
		return MBR_DELDATE;
	}
	public void setMBR_DELDATE(String mBR_DELDATE) {
		MBR_DELDATE = mBR_DELDATE;
	}
	public int getMBR_POINTS() {
		return MBR_POINTS;
	}
	public void setMBR_POINTS(int mBR_POINTS) {
		MBR_POINTS = mBR_POINTS;
	}
	public String getMBR_STATUS() {
		return MBR_STATUS;
	}
	public void setMBR_STATUS(String mBR_STATUS) {
		MBR_STATUS = mBR_STATUS;
	}
	public String getMBR_INTRODUCER() {
		return MBR_INTRODUCER;
	}
	public void setMBR_INTRODUCER(String mBR_INTRODUCER) {
		MBR_INTRODUCER = mBR_INTRODUCER;
	}
	public Date getMBR_UPDATETIME() {
		return MBR_UPDATETIME;
	}
	public void setMBR_UPDATETIME(Date mBR_UPDATETIME) {
		MBR_UPDATETIME = mBR_UPDATETIME;
	}
	public String getMBR_UPDATEUSER() {
		return MBR_UPDATEUSER;
	}
	public void setMBR_UPDATEUSER(String mBR_UPDATEUSER) {
		MBR_UPDATEUSER = mBR_UPDATEUSER;
	}
	@Override
	public String toString() {
		return "CustomerBean [MBR_MEMBERID=" + MBR_MEMBERID + ", MBR_NAME=" + MBR_NAME + ", MBR_PWD=" + MBR_PWD
				+ ", MBR_SEX=" + MBR_SEX + ", MBR_BIRTHDAY=" + MBR_BIRTHDAY + ", MBR_IDENTITY=" + MBR_IDENTITY
				+ ", MBR_POST=" + MBR_POST + ", MBR_ARRDESS=" + MBR_ARRDESS + ", MBR_MARRIED=" + MBR_MARRIED
				+ ", MBR_MOBIL=" + MBR_MOBIL + ", MBR_PHONE=" + MBR_PHONE + ", MBR_EMAIL=" + MBR_EMAIL
				+ ", MBR_CREATEDATE=" + MBR_CREATEDATE + ", MBR_DELDATE=" + MBR_DELDATE + ", MBR_POINTS=" + MBR_POINTS
				+ ", MBR_STATUS=" + MBR_STATUS + ", MBR_INTRODUCER=" + MBR_INTRODUCER + ", MBR_UPDATETIME="
				+ MBR_UPDATETIME + ", MBR_UPDATEUSER=" + MBR_UPDATEUSER + "]";
	}
	
	
}
