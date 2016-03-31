package Administer.model;

public class HG_PromotionProject_Service {
	private int PTP_PROJID;
	private String PTP_NAME;
	private String PTP_CREATEDATE;
	private String PTP_DELDATE;
	private int PTP_STATUS;
	private String PTP_DESC;
	private java.util.Date PTP_COVER;
	private String PTP_UPDATETIME;
	private int PTP_UPDATEUSER;
	
	// 9個屬性
	
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
	public int getPTP_STATUS() {
		return PTP_STATUS;
	}
	public void setPTP_STATUS(int pTP_STATUS) {
		PTP_STATUS = pTP_STATUS;
	}
	public String getPTP_DESC() {
		return PTP_DESC;
	}
	public void setPTP_DESC(String pTP_DESC) {
		PTP_DESC = pTP_DESC;
	}
	public java.util.Date getPTP_COVER() {
		return PTP_COVER;
	}
	public void setPTP_COVER(java.util.Date pTP_COVER) {
		PTP_COVER = pTP_COVER;
	}
	public String getPTP_UPDATETIME() {
		return PTP_UPDATETIME;
	}
	public void setPTP_UPDATETIME(String pTP_UPDATETIME) {
		PTP_UPDATETIME = pTP_UPDATETIME;
	}
	public int getPTP_UPDATEUSER() {
		return PTP_UPDATEUSER;
	}
	public void setPTP_UPDATEUSER(int pTP_UPDATEUSER) {
		PTP_UPDATEUSER = pTP_UPDATEUSER;
	}
	@Override
	public String toString() {
		return "HG_PromotionProject_Bean [PTP_PROJID=" + PTP_PROJID + ", PTP_NAME=" + PTP_NAME + ", PTP_CREATEDATE="
				+ PTP_CREATEDATE + ", PTP_DELDATE=" + PTP_DELDATE + ", PTP_STATUS=" + PTP_STATUS + ", PTP_DESC="
				+ PTP_DESC + ", PTP_COVER=" + PTP_COVER + ", PTP_UPDATETIME=" + PTP_UPDATETIME + ", PTP_UPDATEUSER="
				+ PTP_UPDATEUSER + "]";
	}

}
