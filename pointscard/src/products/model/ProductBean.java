package products.model;

import java.sql.Blob;

public class ProductBean {
	
	@Override
	public String toString() {
		return "productBean [getPD_no()=" + getPD_no() + ", getPD_name()=" + getPD_name() + ", getPD_ID()=" + getPD_ID()
				+ ", PD_discriptions()=" + getPD_discriptions() + ", getPD_amount()=" + getPD_amount()
				+ ", getPD_price()=" + getPD_price() + ", getPD_fileName()=" + getPD_fileName() + "]";
	}
	
	public ProductBean(String pD_no, String pD_name, String pD_ID, String PD_discriptions, int pD_amount,
			double pD_price, String pD_fileName) {
		super();
		this.PD_no = pD_no;
		this.PD_name = pD_name;
		this.PD_ID = pD_ID;
		this.PD_discriptions = PD_discriptions;
		this.PD_amount = pD_amount;
		this.PD_price = pD_price;
		this.PD_fileName = pD_fileName;
	}
	
	public ProductBean(){
		
	};
	
	private String PD_no;
	private String PD_name;
	private String PD_ID;
	private String PD_discriptions;
	private int PD_amount;
	private double PD_price;
	private String PD_fileName;
	private Blob PD_image;
	
	
	public String getPD_no() {
		return PD_no;
	}
	public void setPD_no(String pD_no) {
		this.PD_no = pD_no;
	}
	public String getPD_name() {
		
		return PD_name;
	}
	public void setPD_name(String pD_name) {
		this.PD_name = pD_name;
	}
	public String getPD_ID() {
		System.out.println("11111111111111111111111111");
		return PD_ID;
	}
	public void setPD_ID(String pD_ID) {
		this.PD_ID = pD_ID;
	}
	public String getPD_discriptions() {
		return PD_discriptions;
	}
	public void setPD_discriptions(String PD_discriptions) {
		this.PD_discriptions = PD_discriptions;
	}
	public int getPD_amount() {
		return PD_amount;
	}
	public void setPD_amount(int pD_amount) {
		this.PD_amount = pD_amount;
	}
	public double getPD_price() {
		return PD_price;
	}
	public void setPD_price(double pD_price) {
		this.PD_price = pD_price;
	}
	public String getPD_fileName() {
		return PD_fileName;
	}
	public void setPD_fileName(String pD_fileName) {
		this.PD_fileName = pD_fileName;
	}
	public Blob getPD_image() {
		return PD_image;
	}
	public void setPD_image(Blob pD_image) {
		this.PD_image = pD_image;
	}
}
