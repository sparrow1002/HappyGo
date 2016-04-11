package cardPoint.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CardPointBean implements Serializable{
	private long tranId;
	private String dDate;
	private int pointAdd;
	private int pointDre;
	private String tranDate;
	private String memberId;
	private String status;
	private long useTranId;

	private Timestamp updateTime;
	private String updateUser;
	
	
	public long getTranId() {
		return tranId;
	}
	public void setTranId(long tranId) {
		this.tranId = tranId;
	}
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String dDate) {
		this.dDate = dDate;
	}
	public int getPointAdd() {
		return pointAdd;
	}
	public void setPointAdd(int pointAdd) {
		this.pointAdd = pointAdd;
	}
	public int getPointDre() {
		return pointDre;
	}
	public void setPointDre(int pointDre) {
		this.pointDre = pointDre;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
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
	public long getUseTranId() {
		return useTranId;
	}
	public void setUseTranId(long useTranId) {
		this.useTranId = useTranId;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
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
		return "CardPointBean [tranId=" + tranId + ", dDate=" + dDate
				+ ", pointAdd=" + pointAdd + ", pointDre=" + pointDre
				+ ", tranDate=" + tranDate + ", memberId=" + memberId
				+ ", status=" + status + ", useTranId=" + useTranId
				+ ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ "]";
	}


}
