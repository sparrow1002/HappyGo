package Administer.model;

public class HG_PromotionMethod_Bean {
	private int PTM_ID;
	private String PTM_NAME;
	private String PTM_DESC;
	private String PTM_model;
	private String PTM_OPER; //代碼表
	private String PTM_VALUE;
	private int PTM_VARDATE;//日期加減值
	private int PTM_PROJID;
	private java.util.Date PTM_UPDATETIME;
	private String PTM_UPDATEUSER;
	// 10個屬性
	public int getPTM_ID() {
		return PTM_ID;
	}
	public void setPTM_ID(int pTM_ID) {
		PTM_ID = pTM_ID;
	}
	public String getPTM_NAME() {
		return PTM_NAME;
	}
	public void setPTM_NAME(String pTM_NAME) {
		PTM_NAME = pTM_NAME;
	}
	public String getPTM_DESC() {
		return PTM_DESC;
	}
	public void setPTM_DESC(String pTM_DESC) {
		PTM_DESC = pTM_DESC;
	}
	public String getPTM_model() {
		return PTM_model;
	}
	public void setPTM_model(String pTM_model) {
		PTM_model = pTM_model;
	}
	public String getPTM_OPER() {
		return PTM_OPER;
	}
	public void setPTM_OPER(String pTM_OPER) {
		PTM_OPER = pTM_OPER;
	}
	public String getPTM_VALUE() {
		return PTM_VALUE;
	}
	public void setPTM_VALUE(String pTM_VALUE) {
		PTM_VALUE = pTM_VALUE;
	}
	public int getPTM_VARDATE() {
		return PTM_VARDATE;
	}
	public void setPTM_VARDATE(int pTM_VARDATE) {
		PTM_VARDATE = pTM_VARDATE;
	}
	public int getPTM_PROJID() {
		return PTM_PROJID;
	}
	public void setPTM_PROJID(int pTM_PROJID) {
		PTM_PROJID = pTM_PROJID;
	}
	public java.util.Date getPTM_UPDATETIME() {
		return PTM_UPDATETIME;
	}
	public void setPTM_UPDATETIME(java.util.Date pTM_UPDATETIME) {
		PTM_UPDATETIME = pTM_UPDATETIME;
	}
	public String getPTM_UPDATEUSER() {
		return PTM_UPDATEUSER;
	}
	public void setPTM_UPDATEUSER(String pTM_UPDATEUSER) {
		PTM_UPDATEUSER = pTM_UPDATEUSER;
	}
	@Override
	public String toString() {
		return "HG_PromotionMethod_Bean [PTM_ID=" + PTM_ID + ", PTM_NAME="
				+ PTM_NAME + ", PTM_DESC=" + PTM_DESC + ", PTM_model="
				+ PTM_model + ", PTM_OPER=" + PTM_OPER + ", PTM_VALUE="
				+ PTM_VALUE + ", PTM_VARDATE=" + PTM_VARDATE + ", PTM_PROJID="
				+ PTM_PROJID + ", PTM_UPDATETIME=" + PTM_UPDATETIME
				+ ", PTM_UPDATEUSER=" + PTM_UPDATEUSER + "]";
	}
		
}
