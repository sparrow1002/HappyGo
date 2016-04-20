package admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HG_SysLog")
public class SyslogDAOBean {
	private Integer LOG_NO;
	private String LOG_USERID;
	private String LOG_TYPE;
	private String LOG_DESC;
	private java.util.Date LOG_UPDATETIME;
	private String LOG_UPDATEUSER;
	
	@Id
	@Column(name = "LOG_NO")	
	public Integer getLOG_NO() {
		return LOG_NO;
	}
	public void setLOG_NO(Integer lOG_NO) {
		LOG_NO = lOG_NO;
	}
	@Column(name = "LOG_USERID")
	public String getLOG_USERID() {
		return LOG_USERID;
	}
	public void setLOG_USERID(String lOG_USERID) {
		LOG_USERID = lOG_USERID;
	}
	@Column(name = "LOG_TYPE")
	public String getLOG_TYPE() {
		return LOG_TYPE;
	}
	public void setLOG_TYPE(String lOG_TYPE) {
		LOG_TYPE = lOG_TYPE;
	}
	@Column(name = "LOG_DESC")
	public String getLOG_DESC() {
		return LOG_DESC;
	}
	public void setLOG_DESC(String lOG_DESC) {
		LOG_DESC = lOG_DESC;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOG_UPDATETIME", columnDefinition="DATETIME")
	public java.util.Date getLOG_UPDATETIME() {
		return LOG_UPDATETIME;
	}
	public void setLOG_UPDATETIME(java.util.Date lOG_UPDATETIME) {
		LOG_UPDATETIME = lOG_UPDATETIME;
	}
	@Column(name = "LOG_UPDATEUSER")
	public String getLOG_UPDATEUSER() {
		return LOG_UPDATEUSER;
	}
	public void setLOG_UPDATEUSER(String lOG_UPDATEUSER) {
		LOG_UPDATEUSER = lOG_UPDATEUSER;
	}	
}
