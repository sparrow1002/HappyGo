package admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HG_Right")
public class RightDAOBean implements java.io.Serializable{
	private String RIG_RIGHTID;
	private String RIG_DESC;
	private String RIG_FUNTION;
	private java.util.Date RIG_UPDATETIME;
	private String RIG_UPDATEUSER;
	@Id
	@Column(name = "RIG_RIGHTID")
	public String getRIG_RIGHTID() {
		return RIG_RIGHTID;
	}
	public void setRIG_RIGHTID(String rIG_RIGHTID) {
		RIG_RIGHTID = rIG_RIGHTID;
	}
	
	@Column(name = "RIG_DESC")
	public String getRIG_DESC() {
		return RIG_DESC;
	}
	public void setRIG_DESC(String rIG_DESC) {
		RIG_DESC = rIG_DESC;
	}
	@Column(name = "RIG_FUNTION")
	public String getRIG_FUNTION() {
		return RIG_FUNTION;
	}
	public void setRIG_FUNTION(String rIG_FUNTION) {
		RIG_FUNTION = rIG_FUNTION;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RIG_UPDATETIME", columnDefinition="DATETIME")
	public java.util.Date getRIG_UPDATETIME() {
		return RIG_UPDATETIME;
	}
	public void setRIG_UPDATETIME(java.util.Date rIG_UPDATETIME) {
		RIG_UPDATETIME = rIG_UPDATETIME;
	}
	@Column(name = "RIG_UPDATEUSER")
	public String getRIG_UPDATEUSER() {
		return RIG_UPDATEUSER;
	}
	public void setRIG_UPDATEUSER(String rIG_UPDATEUSER) {
		RIG_UPDATEUSER = rIG_UPDATEUSER;
	}
	

}
