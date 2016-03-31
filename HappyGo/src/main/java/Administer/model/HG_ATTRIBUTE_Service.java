package Administer.model;

public class HG_ATTRIBUTE_Service {
	private int ATR_ATRID;
	private String ATR_TABLE; //對應資料表
	private String ATR_COL;
	private String ATR_COLDESC;
	private String ATR_COLTYPE;
	// 5個屬性
	public int getATR_ATRID() {
		return ATR_ATRID;
	}
	public void setATR_ATRID(int aTR_ATRID) {
		ATR_ATRID = aTR_ATRID;
	}
	public String getATR_TABLE() {
		return ATR_TABLE;
	}
	public void setATR_TABLE(String aTR_TABLE) {
		ATR_TABLE = aTR_TABLE;
	}
	public String getATR_COL() {
		return ATR_COL;
	}
	public void setATR_COL(String aTR_COL) {
		ATR_COL = aTR_COL;
	}
	public String getATR_COLDESC() {
		return ATR_COLDESC;
	}
	public void setATR_COLDESC(String aTR_COLDESC) {
		ATR_COLDESC = aTR_COLDESC;
	}
	public String getATR_COLTYPE() {
		return ATR_COLTYPE;
	}
	public void setATR_COLTYPE(String aTR_COLTYPE) {
		ATR_COLTYPE = aTR_COLTYPE;
	}
	@Override
	public String toString() {
		return "HG_ATTRIBUTE_Bean [ATR_ATRID=" + ATR_ATRID + ", ATR_TABLE=" + ATR_TABLE + ", ATR_COL=" + ATR_COL
				+ ", ATR_COLDESC=" + ATR_COLDESC + ", ATR_COLTYPE=" + ATR_COLTYPE + "]";
	}
}
