package admin.model;


public class RoleDAOBeanPK implements java.io.Serializable {
	private static final long serialVersionUID = 6060166117433738173L;
	private String ROL_ROLEID;
	private String ROL_RIGHTID;

	public String getROL_ROLEID() {
		return ROL_ROLEID;
	}

	public void setROL_ROLEID(String rOL_ROLEID) {
		ROL_ROLEID = rOL_ROLEID;
	}

	public String getROL_RIGHTID() {
		return ROL_RIGHTID;
	}

	public void setROL_RIGHTID(String rOL_RIGHTID) {
		ROL_RIGHTID = rOL_RIGHTID;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof RoleDAOBeanPK) {
			RoleDAOBeanPK key = (RoleDAOBeanPK) o;
			if (this.ROL_ROLEID == key.getROL_RIGHTID()
					&& this.ROL_RIGHTID.equals(key.getROL_RIGHTID())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.ROL_RIGHTID.hashCode();
	}
}
