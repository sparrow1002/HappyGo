package shoppingCart.model;

import java.sql.Date;

public class TotalOrderItem {

	String ORD_seqno; //哪一次購買的序列編號
	String ORD_no;
	String PD_ID;
	String PD_descriptions;
	int ORD_amount;
	double ORD_unitPrice;
	
	public TotalOrderItem() {
		super();
	}
	
	public TotalOrderItem(String oRD_seqno, String oRD_no, String pD_ID, String pD_descriptions, int oRD_amount,
			double oRD_unitPrice) {
		super();
		ORD_seqno = oRD_seqno;
		ORD_no = oRD_no;
		PD_ID = pD_ID;
		PD_descriptions = pD_descriptions;
		ORD_amount = oRD_amount;
		ORD_unitPrice = oRD_unitPrice;
	}

	@Override
	public String toString() {
		return "TotalOrderItem [ORD_seqno=" + ORD_seqno + ", ORD_no=" + ORD_no + ", PD_ID=" + PD_ID
				+ ", PD_descriptions=" + PD_descriptions + ", ORD_amount=" + ORD_amount + ", oRD_unitPrice="
				+ ORD_unitPrice + "]";
	}
	
	public String getORD_seqno() {
		return ORD_seqno;
	}
	public void setORD_seqno(String oRD_seqno) {
		ORD_seqno = oRD_seqno;
	}
	public String getORD_no() {
		return ORD_no;
	}
	public void setORD_no(String oRD_no) {
		ORD_no = oRD_no;
	}
	public String getPD_ID() {
		return PD_ID;
	}
	public void setPD_ID(String pD_ID) {
		PD_ID = pD_ID;
	}
	public String getPD_descriptions() {
		return PD_descriptions;
	}
	public void setPD_descriptions(String pD_descriptions) {
		PD_descriptions = pD_descriptions;
	}
	public int getORD_amount() {
		return ORD_amount;
	}
	public void setORD_amount(int oRD_amount) {
		ORD_amount = oRD_amount;
	}
	public double getORD_unitPrice() {
		return ORD_unitPrice;
	}
	public void setORD_unitPrice(double oRD_unitPrice) {
		ORD_unitPrice = oRD_unitPrice;
	}
	
}
