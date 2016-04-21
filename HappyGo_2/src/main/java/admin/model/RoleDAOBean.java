package admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "HG_Role")
@IdClass(RoleDAOBeanPK.class)
public class RoleDAOBean  implements java.io.Serializable{
	private String ROL_ROLEID;
	private String ROL_RIGHTID;
	private java.util.Date ROL_UPDATETIME;
	private String ROL_UPDATEUSER;
	
	@Id
	@Column(name = "ROL_ROLEID")		
	public String getROL_ROLEID() {
		return ROL_ROLEID;
	}
	public void setROL_ROLEID(String rOL_ROLEID) {
		ROL_ROLEID = rOL_ROLEID;
	}
	@Id
	@Column(name = "ROL_RIGHTID")
	public String getROL_RIGHTID() {
		return ROL_RIGHTID;
	}
	public void setROL_RIGHTID(String rOL_RIGHTID) {
		ROL_RIGHTID = rOL_RIGHTID;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROL_UPDATETIME", columnDefinition="DATETIME")
	public java.util.Date getROL_UPDATETIME() {
		return ROL_UPDATETIME;
	}
	
	public void setROL_UPDATETIME(java.util.Date rOL_UPDATETIME) {
		ROL_UPDATETIME = rOL_UPDATETIME;
	}
	
	@Column(name = "ROL_UPDATEUSER")
	public String getROL_UPDATEUSER() {
		return ROL_UPDATEUSER;
	}	
	
	public void setROL_UPDATEUSER(String rOL_UPDATEUSER) {
		ROL_UPDATEUSER = rOL_UPDATEUSER;
	}	
}
