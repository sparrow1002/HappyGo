package shoppingCart.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SingleOrderBean {

	String ORD_no;
	String MBR_MEMBERID;
	double ORD_totalAmount;
	String ORD_shippingAddress;
	String ORD_descriptions; 
	Date ORD_date;
	Date ORD_shippingdate;
	String ORD_cancelTag;
	
	List<TotalOrderItem> items = new ArrayList<TotalOrderItem>();
	
	public SingleOrderBean() { //空的建構子
		super();
	}



	public SingleOrderBean(String mBR_MEMBERID, double oRD_totalAmount, String oRD_shippingAddress,
			String oRD_descriptions, Date oRD_date, Date oRD_shippingdate, List<TotalOrderItem> items) {
		super();
		MBR_MEMBERID = mBR_MEMBERID;
		ORD_totalAmount = oRD_totalAmount;
		ORD_shippingAddress = oRD_shippingAddress;
		ORD_descriptions = oRD_descriptions;
		ORD_date = oRD_date;
		ORD_shippingdate = oRD_shippingdate;
		this.items = items;
	}



	public String getORD_no() {
		return ORD_no;
	}

	public void setORD_no(String oRD_no) {
		ORD_no = oRD_no;
	}

	public String getMBR_MEMBERID() {
		return MBR_MEMBERID;
	}

	public void setMBR_MEMBERID(String mBR_MEMBERID) {
		MBR_MEMBERID = mBR_MEMBERID;
	}

	public double getORD_totalAmount() {
		return ORD_totalAmount;
	}

	public void setORD_totalAmount(double oRD_totalAmount) {
		ORD_totalAmount = oRD_totalAmount;
	}

	public String getORD_shippingAddress() {
		return ORD_shippingAddress;
	}

	public void setORD_shippingAddress(String oRD_shippingAddress) {
		ORD_shippingAddress = oRD_shippingAddress;
	}

	public String getORD_descriptions() {
		return ORD_descriptions;
	}

	public void setORD_descriptions(String oRD_descriptions) {
		ORD_descriptions = oRD_descriptions;
	}

	public Date getORD_date() {
		return ORD_date;
	}

	public void setORD_date(Date oRD_date) {
		ORD_date = oRD_date;
	}

	public Date getORD_shippingdate() {
		return ORD_shippingdate;
	}

	public void setORD_shippingdate(Date oRD_shippingdate) {
		ORD_shippingdate = oRD_shippingdate;
	}

	public String getORD_cancelTag() {
		return ORD_cancelTag;
	}

	public void setORD_cancelTag(String oRD_cancelTag) {
		ORD_cancelTag = oRD_cancelTag;
	}

	public List<TotalOrderItem> getItems() {
		return items;
	}

	public void setItems(List<TotalOrderItem> items) {
		this.items = items;
	}
	
	}
