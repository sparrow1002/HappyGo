package report.model;

import java.math.BigDecimal;

public class reportDAOBean {
	private String SOP_MEMBERID;
	private String COS_NAME;
	private String CPT_TRANDATE;
	private BigDecimal SOP_TRANAMT;
	private BigDecimal SOP_DISCOUNT;
	private BigDecimal CPT_POINTADD;
	private BigDecimal CPT_POINTDRE;
	private int SOP_overPoint;
	private String SOP_TRANID;
	private String SOP_STATUS;
	private String transation;
	public String getSOP_MEMBERID() {
		return SOP_MEMBERID;
	}
	public void setSOP_MEMBERID(String sOP_MEMBERID) {
		SOP_MEMBERID = sOP_MEMBERID;
	}
	public String getCOS_NAME() {
		return COS_NAME;
	}
	public void setCOS_NAME(String cOS_NAME) {
		COS_NAME = cOS_NAME;
	}
	public String getCPT_TRANDATE() {
		return CPT_TRANDATE;
	}
	public void setCPT_TRANDATE(String cPT_TRANDATE) {
		CPT_TRANDATE = cPT_TRANDATE;
	}
	public BigDecimal getSOP_TRANAMT() {
		return SOP_TRANAMT;
	}
	public void setSOP_TRANAMT(BigDecimal sOP_TRANAMT) {
		SOP_TRANAMT = sOP_TRANAMT;
	}
	public BigDecimal getSOP_DISCOUNT() {
		return SOP_DISCOUNT;
	}
	public void setSOP_DISCOUNT(BigDecimal sOP_DISCOUNT) {
		SOP_DISCOUNT = sOP_DISCOUNT;
	}
	public BigDecimal getCPT_POINTADD() {
		return CPT_POINTADD;
	}
	public void setCPT_POINTADD(BigDecimal cPT_POINTADD) {
		CPT_POINTADD = cPT_POINTADD;
	}
	public BigDecimal getCPT_POINTDRE() {
		return CPT_POINTDRE;
	}
	public void setCPT_POINTDRE(BigDecimal cPT_POINTDRE) {
		CPT_POINTDRE = cPT_POINTDRE;
	}
	public int getSOP_overPoint() {
		return SOP_overPoint;
	}
	public void setSOP_overPoint(int sOP_overPoint) {
		SOP_overPoint = sOP_overPoint;
	}
	public String getSOP_TRANID() {
		return SOP_TRANID;
	}
	public void setSOP_TRANID(String sOP_TRANID) {
		SOP_TRANID = sOP_TRANID;
	}
	public String getTransation() {
		return transation;
	}
	public void setTransation(String transation) {
		this.transation = transation;
	}
	public String getSOP_STATUS() {
		return SOP_STATUS;
	}
	public void setSOP_STATUS(String sOP_STATUS) {
		SOP_STATUS = sOP_STATUS;
	}
	
	

	
}
