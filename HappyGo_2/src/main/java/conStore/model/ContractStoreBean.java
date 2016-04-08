package conStore.model;

public class ContractStoreBean {
	private String cos_storeid; 	//varchar(10) not null,特店代號
	private String cos_name;	//nvarchar(30),特店名稱
	private String cos_pwd;	//varchar(10) not null,特店密碼
	private String cos_taxcode;	//char(8),統一編號
	private String cos_address;	//nvarchar(50),特店地址
	private String cos_status;	//char(1),特店狀態
	private String cos_phone;	//varchar(10),連絡電話
	private String cos_contact;	//nvarchar(10),聯絡人
	private String cos_createtime;	//char(8),特店生效日
	private String cos_deletime;	//char(8),特店失效日
	private String cos_updatetime;	//datetime not null default getdate(),異動日期
	private String cos_updateuser;	//varchar(10) 異動者

	@Override
	public String toString() {
		return "HG_ContractStoreBean [cos_storeid=" + cos_storeid
				+ ", cos_name=" + cos_name + ", cos_pwd=" + cos_pwd
				+ ", cos_taxcode=" + cos_taxcode + ", cos_address="
				+ cos_address + ", cos_status=" + cos_status + ", cos_phone="
				+ cos_phone + ", cos_contact=" + cos_contact
				+ ", cos_createtime=" + cos_createtime + ", cos_deletime="
				+ cos_deletime + ", cos_updatetime=" + cos_updatetime
				+ ", cos_updateuser=" + cos_updateuser + "]";
	}

	public String getCos_storeid() {
		return cos_storeid;
	}

	public void setCos_storeid(String cos_storeid) {
		this.cos_storeid = cos_storeid;
	}

	public String getCos_name() {
		return cos_name;
	}

	public void setCos_name(String cos_name) {
		this.cos_name = cos_name;
	}

	public String getCos_pwd() {
		return cos_pwd;
	}

	public void setCos_pwd(String cos_pwd) {
		this.cos_pwd = cos_pwd;
	}

	public String getCos_taxcode() {
		return cos_taxcode;
	}

	public void setCos_taxcode(String cos_taxcode) {
		this.cos_taxcode = cos_taxcode;
	}

	public String getCos_address() {
		return cos_address;
	}

	public void setCos_address(String cos_address) {
		this.cos_address = cos_address;
	}

	public String getCos_status() {
		return cos_status;
	}

	public void setCos_status(String cos_status) {
		this.cos_status = cos_status;
	}

	public String getCos_phone() {
		return cos_phone;
	}

	public void setCos_phone(String cos_phone) {
		this.cos_phone = cos_phone;
	}

	public String getCos_contact() {
		return cos_contact;
	}

	public void setCos_contact(String cos_contact) {
		this.cos_contact = cos_contact;
	}

	public String getCos_createtime() {
		return cos_createtime;
	}

	public void setCos_createtime(String cos_createtime) {
		this.cos_createtime = cos_createtime;
	}

	public String getCos_deletime() {
		return cos_deletime;
	}

	public void setCos_deletime(String cos_deletime) {
		this.cos_deletime = cos_deletime;
	}

	public String getCos_updatetime() {
		return cos_updatetime;
	}

	public void setCos_updatetime(String cos_updatetime) {
		this.cos_updatetime = cos_updatetime;
	}

	public String getCos_updateuser() {
		return cos_updateuser;
	}

	public void setCos_updateuser(String cos_updateuser) {
		this.cos_updateuser = cos_updateuser;
	}
	
	
}
