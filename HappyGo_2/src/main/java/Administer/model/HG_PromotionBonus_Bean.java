package Administer.model;

public class HG_PromotionBonus_Bean {
	private int PTB_ID;
	private String PTB_OPER; //代碼表
	private int PTB_VALUE;
	private int PTB_POINT;
	private int PTB_PROJID;
	private String PTB_model;
	private java.util.Date PTB_UPDATETIME;
	private String PTB_UPDATEUSER;
	// 7個屬性
	public int getPTB_ID() {
		return PTB_ID;
	}
	public void setPTB_ID(int pTB_ID) {
		PTB_ID = pTB_ID;
	}
	public String getPTB_OPER() {
		return PTB_OPER;
	}
	public void setPTB_OPER(String pTB_OPER) {
		PTB_OPER = pTB_OPER;
	}
	public int getPTB_VALUE() {
		return PTB_VALUE;
	}
	public void setPTB_VALUE(int pTB_VALUE) {
		PTB_VALUE = pTB_VALUE;
	}
	public int getPTB_POINT() {
		return PTB_POINT;
	}
	public void setPTB_POINT(int pTB_POINT) {
		PTB_POINT = pTB_POINT;
	}
	public int getPTB_PROJID() {
		return PTB_PROJID;
	}
	public void setPTB_PROJID(int pTB_PROJID) {
		PTB_PROJID = pTB_PROJID;
	}
	public String getPTB_model() {
		return PTB_model;
	}
	public void setPTB_model(String pTB_model) {
		PTB_model = pTB_model;
	}
	public java.util.Date getPTB_UPDATETIME() {
		return PTB_UPDATETIME;
	}
	public void setPTB_UPDATETIME(java.util.Date pTB_UPDATETIME) {
		PTB_UPDATETIME = pTB_UPDATETIME;
	}
	public String getPTB_UPDATEUSER() {
		return PTB_UPDATEUSER;
	}
	public void setPTB_UPDATEUSER(String pTB_UPDATEUSER) {
		PTB_UPDATEUSER = pTB_UPDATEUSER;
	}
	@Override
	public String toString() {
		return "HG_PromotionBonus_Bean [PTB_ID=" + PTB_ID + ", PTB_OPER="
				+ PTB_OPER + ", PTB_VALUE=" + PTB_VALUE + ", PTB_POINT="
				+ PTB_POINT + ", PTB_PROJID=" + PTB_PROJID + ", PTB_model="
				+ PTB_model + ", PTB_UPDATETIME=" + PTB_UPDATETIME
				+ ", PTB_UPDATEUSER=" + PTB_UPDATEUSER + "]";
	}
	
	
}
