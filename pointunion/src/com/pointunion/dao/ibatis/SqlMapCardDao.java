package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.CardDao;
import com.pointunion.domain.dto.Card;
import com.pointunion.domain.qc.CardQC;

public class SqlMapCardDao extends SqlMapClientDaoSupport implements CardDao {
	public Card getCardByPK(String cardNo) throws DataAccessException {
		return (Card) getSqlMapClientTemplate().queryForObject("getCardByPK", cardNo);
	}

	public void insertCard(Card card) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertCard", card);
	}

	public void updateCard(Card card) throws DataAccessException {
		getSqlMapClientTemplate().update("updateCard", card, 1);
	}

	public void deleteCard(String cardNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCard", cardNo, 1);
	}

	public Collection getCards(CardQC cardQC) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getCardsByQC", cardQC);
	}
}
