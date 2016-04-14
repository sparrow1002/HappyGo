package shoppingCart.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import products.model.MyOrderItemBean;

public class ShoppingCart {
	private Map<String, MyOrderItemBean> cart = new LinkedHashMap< >();
	public ShoppingCart() {
	}
	public Map<String, MyOrderItemBean>  getContent() {  //Shopping Cart.view ${ShoppingCart.content}
		return cart;
	}
	public void addToCart(String PD_ID, MyOrderItemBean  oi) {
		if (oi.getQty() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(PD_ID) == null ) {
		    cart.put(PD_ID, oi);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			MyOrderItemBean moib = cart.get(PD_ID);
			// 加購的數量：oi.getQty()
			// 原有的數量：oib.getQty()			
			moib.setQty(oi.getQty() + moib.getQty());
		}
	}
	// 修改商品的數量
	public boolean modifyQty(String PD_ID, MyOrderItemBean  oi) {
		if ( cart.get(PD_ID) != null && oi.getQty() > 0 ) {
	       cart.put(PD_ID, oi);
	       return true;
		} else {
		   return false;
		}
	}
	public boolean modifyQty(String PD_ID, int newQty) {
		if ( cart.get(PD_ID) != null ) {
			MyOrderItemBean  oi = (MyOrderItemBean)cart.get(PD_ID);
		   oi.setQty(newQty);
	       cart.put(PD_ID, oi);
	       return true;
		} else {
		   return false;
		}
	}
	// 刪除某項商品
	public int deleteBook(String PD_ID) {
		if ( cart.get(PD_ID) != null ) {
	       cart.remove(PD_ID);  // Map介面的remove()方法
	       return 1;
		} else {
		   return 0;
		}
	}
	public int getItemNumber(){
		return cart.size();
	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal(){
		
		double subTotal = 0 ;
		Set<String> set = cart.keySet();
		for(String n : set){
			double price    = cart.get(n).getPrice();
			int    qty      = cart.get(n).getQty();
			subTotal +=  price * qty;
			System.out.println("hello this is shopping cart demo subTotal=" + subTotal);

		}
		return subTotal;
	}
	public void listCart() {
		Set<String> set = cart.keySet();
		for(String k : set){
			System.out.printf("PD_ID=%3d,  Qty=%3d,  price=%5.2f," , k , cart.get(k).getQty(), cart.get(k).getPrice());
		}
		System.out.println("------------------");
	}
}
