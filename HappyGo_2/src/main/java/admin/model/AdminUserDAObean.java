package admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HG_AdminUser")
public class AdminUserDAObean implements java.io.Serializable {
	private String ADM_ID;
	private String ADM_PWD;
	private String ADM_NAME;
	private String ADM_ROLEID;
	private java.util.Date ADM_UPDATETIME;
	private String ADM_UPDATEUSER;
	@Id
	@Column(name = "ADM_ID")
	public String getADM_ID() {
		return ADM_ID;
	}
	public void setADM_ID(String ADM_ID) {
		this.ADM_ID = ADM_ID;
	}
	@Column(name = "ADM_PWD")
	public String getADM_PWD() {
		return ADM_PWD;
	}
	public void setADM_PWD(String ADM_PWD) {
		this.ADM_PWD = ADM_PWD;
	}
	@Column(name = "ADM_NAME")
	public String getADM_NAME() {
		return ADM_NAME;
	}
	public void setADM_NAME(String ADM_NAME) {
		this.ADM_NAME = ADM_NAME;
	}
	@Column(name = "ADM_ROLEID")
	public String getADM_ROLEID() {
		return ADM_ROLEID;
	}
	public void setADM_ROLEID(String ADM_ROLEID) {
		this.ADM_ROLEID = ADM_ROLEID;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ADM_UPDATETIME", columnDefinition="DATETIME")
	public java.util.Date getADM_UPDATETIME() {
		return ADM_UPDATETIME;
	}
	public void setADM_UPDATETIME(java.util.Date ADM_UPDATETIME) {
		this.ADM_UPDATETIME = ADM_UPDATETIME;
	}
	@Column(name = "ADM_UPDATEUSER")
	public String getADM_UPDATEUSER() {
		return ADM_UPDATEUSER;
	}
	public void setADM_UPDATEUSER(String ADM_UPDATEUSER) {
		this.ADM_UPDATEUSER = ADM_UPDATEUSER;
	}	
}
