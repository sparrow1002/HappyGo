package shopping.model;

import java.io.Serializable;
import java.util.Date;

public class ShoppingBean implements Serializable{
	private String tranId;
	private int tranAmt;
	private int disCount;
	private String memberId;
	private String status;
	private String projId;
	private String storeId;
	
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
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
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
		return "HG_ShoppingBean [tranId=" + tranId + ", tranAmt=" + tranAmt
				+ ", disCount=" + disCount + ", memberId=" + memberId
				+ ", status=" + status + ", projId=" + projId + ", storeId="
				+ storeId + ", updateTime=" + updateTime + ", updateUser="
				+ updateUser + "]";
	}

}
