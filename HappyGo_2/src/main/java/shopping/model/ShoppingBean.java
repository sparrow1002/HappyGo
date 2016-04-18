package shopping.model;

import java.io.Serializable;
import java.util.Date;

public class ShoppingBean implements Serializable{
	private String tranId;
	private int tranAmt;
	private int disCount;
	private String memberId;
	private String status;
	private int projId;
	private String storeId;
	private int overPoint;
	private String tranDate;
	
	private Date updateTime;
	private String updateUser;
	
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public int getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(int tranAmt) {
		this.tranAmt = tranAmt;
	}
	public int getDisCount() {
		return disCount;
	}
	public void setDisCount(int disCount) {
		this.disCount = disCount;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public int getOverPoint() {
		return overPoint;
	}
	public void setOverPoint(int overPoint) {
		this.overPoint = overPoint;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	@Override
	public String toString() {
		return "ShoppingBean [tranId=" + tranId + ", tranAmt=" + tranAmt
				+ ", disCount=" + disCount + ", memberId=" + memberId
				+ ", status=" + status + ", projId=" + projId + ", storeId="
				+ storeId + ", overPoint=" + overPoint + ", tranDate="
				+ tranDate + ", updateTime=" + updateTime + ", updateUser="
				+ updateUser + "]";
	}


}
