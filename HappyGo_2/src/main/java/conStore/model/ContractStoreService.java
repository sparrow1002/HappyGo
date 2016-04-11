package conStore.model;

import java.util.ArrayList;
import java.util.List;

import conStore.model.dao.ContractStoreDAOJdbc;

public class ContractStoreService {
	private ContractStoreDAO contractStoreDao = new ContractStoreDAOJdbc();
	public static void main(String[] args) {
		ContractStoreService service = new ContractStoreService();
		List<ContractStoreBean> beans = service.select(null);
		System.out.println(beans);
	}
	
	public List<ContractStoreBean> select (ContractStoreBean bean){
		List<ContractStoreBean> result = null;
		if(bean!=null && bean.getCos_storeid().length()!=0){
			ContractStoreBean  temp = contractStoreDao.select(bean.getCos_storeid());
			if(temp!= null){
				result = new ArrayList<>();
				result.add(temp);
			}
		}else{
			result = contractStoreDao.select();
		}
		return result;
	}
	
	public ContractStoreBean insert(ContractStoreBean bean){
		ContractStoreBean result = null;
		if(bean!=null){
			result = contractStoreDao.insert(bean);
		}
		return result;
	}
	
	public ContractStoreBean update(ContractStoreBean bean){
		ContractStoreBean result = null;
		if(bean!=null){
			result = contractStoreDao.update(bean);
		}
		return result;
	}
	
	public boolean delete(ContractStoreBean bean){
		boolean result = false;
		if(bean!=null){
			result = contractStoreDao.delete(bean.getCos_storeid());
		}
		return result;
	}
}
