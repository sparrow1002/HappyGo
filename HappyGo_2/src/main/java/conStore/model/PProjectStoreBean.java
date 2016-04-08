package conStore.model;

public class PProjectStoreBean {
	private String pps_projid;	//varchar(10) not null,
	private String pps_storgpid;	//varchar(10) not null,
	private String pps_storeid;	//varchar(10) not null,
	private java.util.Date pps_updatetime;	//datetime NOT NULL DEFAULT GETDATE(),
	private String pps_updateuser;	//varchar(10)	
	
	@Override
	public String toString() {
		return "HG_PProjectStoreBean [pps_projid=" + pps_projid
				+ ", pps_storgpid=" + pps_storgpid + ", pps_storeid="
				+ pps_storeid + ", pps_updatetime=" + pps_updatetime
				+ ", pps_updateuser=" + pps_updateuser + "]";
	}
	
	public String getPps_projid() {
		return pps_projid;
	}
	public void setPps_projid(String pps_projid) {
		this.pps_projid = pps_projid;
	}
	public String getPps_storgpid() {
		return pps_storgpid;
	}
	public void setPps_storgpid(String pps_storgpid) {
		this.pps_storgpid = pps_storgpid;
	}
	public String getPps_storeid() {
		return pps_storeid;
	}
	public void setPps_storeid(String pps_storeid) {
		this.pps_storeid = pps_storeid;
	}
	public java.util.Date getPps_updatetime() {
		return pps_updatetime;
	}
	public void setPps_updatetime(java.util.Date pps_updatetime) {
		this.pps_updatetime = pps_updatetime;
	}
	public String getPps_updateuser() {
		return pps_updateuser;
	}
	public void setPps_updateuser(String pps_updateuser) {
		this.pps_updateuser = pps_updateuser;
	}		
}
