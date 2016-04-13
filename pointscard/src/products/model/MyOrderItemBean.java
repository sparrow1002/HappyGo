package products.model;
//此類別沒有資料庫內容
public class MyOrderItemBean {
	String PD_name;
	int qty = 0 ; 
	String PD_ID;
	double price = 0 ; 

	public MyOrderItemBean() {
	}
	
	public MyOrderItemBean(String pD_name, int qty, String pD_ID, double price) {
		super();
		PD_name = pD_name;
		this.qty = qty;
		PD_ID = pD_ID;
		this.price = price;
	}
	
	public String getPD_name() {
		return PD_name;
	}
	public void setPD_name(String pD_name) {
		PD_name = pD_name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getPD_ID() {
		return PD_ID;
	}
	public void setPD_ID(String pD_ID) {
		PD_ID = pD_ID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
