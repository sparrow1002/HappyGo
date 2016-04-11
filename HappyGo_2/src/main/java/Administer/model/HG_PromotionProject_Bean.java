package Administer.model;

import java.util.Arrays;

public class HG_PromotionProject_Bean {
	private int PTP_PROJID;
	private String PTP_NAME;
	private String PTP_CREATEDATE;
	private String PTP_DELDATE;
	private String PTP_STATUS;
	private String PTP_DESC;
	private byte[] PTP_COVER;
	private int PTP_FIXPOINT;
	private java.sql.Date PTP_UPDATETIME; //insert用不到，select要
	private String PTP_UPDATEUSER;
	
	// 10個屬性
	
	public int getPTP_PROJID() {
		return PTP_PROJID;
	}
	public void setPTP_PROJID(int pTP_PROJID) {
		PTP_PROJID = pTP_PROJID;
	}
	public String getPTP_NAME() {
		return PTP_NAME;
	}
	public void setPTP_NAME(String pTP_NAME) {
		PTP_NAME = pTP_NAME;
	}
	public String getPTP_CREATEDATE() {
		return PTP_CREATEDATE;
	}
	public void setPTP_CREATEDATE(String pTP_CREATEDATE) {
		PTP_CREATEDATE = pTP_CREATEDATE;
	}
	public String getPTP_DELDATE() {
		return PTP_DELDATE;
	}
	public void setPTP_DELDATE(String pTP_DELDATE) {
		PTP_DELDATE = pTP_DELDATE;
	}
	public String getPTP_STATUS() {
		return PTP_STATUS;
	}
	public void setPTP_STATUS(String pTP_STATUS) {
		PTP_STATUS = pTP_STATUS;
	}
	public String getPTP_DESC() {
		return PTP_DESC;
	}
	public void setPTP_DESC(String pTP_DESC) {
		PTP_DESC = pTP_DESC;
	}
	public byte[] getPTP_COVER() {
		return PTP_COVER;
	}
	public void setPTP_COVER(byte[] pTP_COVER) {
		PTP_COVER = pTP_COVER;
	}
	public int getPTP_FIXPOINT() {
		return PTP_FIXPOINT;
	}
	public void setPTP_FIXPOINT(int pTP_FIXPOINT) {
		PTP_FIXPOINT = pTP_FIXPOINT;
	}
	public java.sql.Date getPTP_UPDATETIME() {
		return PTP_UPDATETIME;
	}
	public void setPTP_UPDATETIME(java.sql.Date pTP_UPDATETIME) {
		PTP_UPDATETIME = pTP_UPDATETIME;
	}
	public String getPTP_UPDATEUSER() {
		return PTP_UPDATEUSER;
	}
	public void setPTP_UPDATEUSER(String pTP_UPDATEUSER) {
		PTP_UPDATEUSER = pTP_UPDATEUSER;
	}
	@Override
	public String toString() {
		return "HG_PromotionProject_Bean [PTP_PROJID=" + PTP_PROJID + ", PTP_NAME=" + PTP_NAME + ", PTP_CREATEDATE="
				+ PTP_CREATEDATE + ", PTP_DELDATE=" + PTP_DELDATE + ", PTP_STATUS=" + PTP_STATUS + ", PTP_DESC="
				+ PTP_DESC + ", PTP_COVER=" + Arrays.toString(PTP_COVER) + ", PTP_FIXPOINT=" + PTP_FIXPOINT
				+ ", PTP_UPDATETIME=" + PTP_UPDATETIME + ", PTP_UPDATEUSER=" + PTP_UPDATEUSER + "]";
	}
}
