package API;

public class APIIntoBean {
	private String memberId;
	private int cost;
	private int usePoint;
	private String tranId;
	private String storeId;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "tranIntoBean [memberId=" + memberId + ", cost=" + cost
				+ ", usePoint=" + usePoint + ", tranId=" + tranId
				+ ", storeId=" + storeId + "]";
	}
	
}
