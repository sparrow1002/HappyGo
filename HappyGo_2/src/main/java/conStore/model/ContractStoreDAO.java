package conStore.model;

import java.util.List;

public interface ContractStoreDAO {
//CURD
	public abstract ContractStoreBean select(String storeId); 
	
	public abstract List<ContractStoreBean> select();
	
	public abstract ContractStoreBean insert(ContractStoreBean bean);
	
/*	public abstract ContractStoreBean update(String cos_storeid, String cos_name, String cos_pwd, String cos_taxcode,
			String cos_address, String cos_status, String cos_phone, String cos_contact, String cos_createtime,
			String cos_deletime, String  cos_updatetime, String cos_updateuser);*/
	public abstract ContractStoreBean update(ContractStoreBean bean);
	
	
	public abstract boolean delete(String storeId);
		
}
