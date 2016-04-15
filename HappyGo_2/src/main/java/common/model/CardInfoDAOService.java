package common.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service(value = "cardInfoDAOService")
public class CardInfoDAOService {
	private CardInfoDAO cardInfoDAO;

	public CardInfoDAOService(CardInfoDAO cardInfoDAO) {
		this.cardInfoDAO = cardInfoDAO;
	}
	
	public List<CardInfoDAOBean> select() {
		List<CardInfoDAOBean> result=null;		
		result = cardInfoDAO.select();
		return result;
	}
	
	public CardInfoDAOBean select(CardInfoDAOBean bean){
		CardInfoDAOBean result=null;
		result = cardInfoDAO.select(bean);
		return result;
	}
	
	public CardInfoDAOBean insert(CardInfoDAOBean bean){
		CardInfoDAOBean result=null;
		result = cardInfoDAO.select(bean);
		return result;
	}
	
	public CardInfoDAOBean delete(CardInfoDAOBean bean){
		CardInfoDAOBean result=null;
		result = cardInfoDAO.delete(bean);
		return result;
	}
	
	public CardInfoDAOBean update(CardInfoDAOBean bean){
		CardInfoDAOBean result=null;
		result = cardInfoDAO.update(bean);
		return result;
	}
}
