package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.Card;
import com.pointunion.domain.qc.CardQC;

public interface CardDao {
	public Card getCardByPK(String cardNo) throws DataAccessException;

	public void insertCard(Card card) throws DataAccessException;

	public void updateCard(Card card) throws DataAccessException;

	public void deleteCard(String cardNo) throws DataAccessException;

	public Collection getCards(CardQC cardQC) throws DataAccessException;
}
