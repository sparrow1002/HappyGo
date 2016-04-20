package admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HG_DataProfile")
public class DataProfileDAOBean implements java.io.Serializable{
	private String DAP_GROUP;
	private String DAP_ID;
	private String DAP_VALUE;
	private String DAP_DESC;
	private java.util.Date DAP_UPDATETIME;
	private String DAP_UPDATEUSER;
	@Id
	@Column(name = "DAP_GROUP")	
	public String getDAP_GROUP() {
		return DAP_GROUP;
	}

	public void setDAP_GROUP(String dAP_GROUP) {
		DAP_GROUP = dAP_GROUP;
	}
	@Id
	@Column(name = "DAP_ID")	
	public String getDAP_ID() {
		return DAP_ID;
	}

	public void setDAP_ID(String dAP_ID) {
		DAP_ID = dAP_ID;
	}
	@Column(name = "DAP_VALUE")
	public String getDAP_VALUE() {
		return DAP_VALUE;
	}

	public void setDAP_VALUE(String dAP_VALUE) {
		DAP_VALUE = dAP_VALUE;
	}
	@Column(name = "DAP_DESC")
	public String getDAP_DESC() {
		return DAP_DESC;
	}

	public void setDAP_DESC(String dAP_DESC) {
		DAP_DESC = dAP_DESC;
	}

	public java.util.Date getDAP_UPDATETIME() {
		return DAP_UPDATETIME;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAP_UPDATETIME", columnDefinition="DATETIME")
	public void setDAP_UPDATETIME(java.util.Date dAP_UPDATETIME) {
		DAP_UPDATETIME = dAP_UPDATETIME;
	}
	@Column(name = "DAP_UPDATEUSER")
	public String getDAP_UPDATEUSER() {
		return DAP_UPDATEUSER;
	}

	public void setDAP_UPDATEUSER(String dAP_UPDATEUSER) {
		DAP_UPDATEUSER = dAP_UPDATEUSER;
	}

}
