package conStore.model;

public class ContractStoreGroupBean {
	private String csg_storgpid;	//varchar(10) not null,
	private String csg_storeid;	//varchar(10) not null,
	private String csg_name;	//nvarchar(30),
	private java.util.Date csg_updatetime;	//datetime not null default getdate(),
	private String csg_updateuser;	//varchar(10)
	
	@Override
	public String toString() {
		return "HG_ContractStoreGroupBean [csg_storgpid=" + csg_storgpid
				+ ", csg_storeid=" + csg_storeid + ", csg_name=" + csg_name
				+ ", csg_updatetime=" + csg_updatetime + ", csg_updateuser="
				+ csg_updateuser + "]";
	}

	public String getCsg_storgpid() {
		return csg_storgpid;
	}

	public void setCsg_storgpid(String csg_storgpid) {
		this.csg_storgpid = csg_storgpid;
	}

	public String getCsg_storeid() {
		return csg_storeid;
	}

	public void setCsg_storeid(String csg_storeid) {
		this.csg_storeid = csg_storeid;
	}

	public String getCsg_name() {
		return csg_name;
	}

	public void setCsg_name(String csg_name) {
		this.csg_name = csg_name;
	}

	public java.util.Date getCsg_updatetime() {
		return csg_updatetime;
	}

	public void setCsg_updatetime(java.util.Date csg_updatetime) {
		this.csg_updatetime = csg_updatetime;
	}

	public String getCsg_updateuser() {
		return csg_updateuser;
	}

	public void setCsg_updateuser(String csg_updateuser) {
		this.csg_updateuser = csg_updateuser;
	}	
	
}
