package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.MetaCard;

public interface MetaCardDao {
	public MetaCard getMetaCardByPK(String cardCategory) throws DataAccessException;
	
	public Collection getMetaCards() throws DataAccessException;
	
	public void insertMetaCard(MetaCard metaCard) throws DataAccessException;

	public void updateMetaCard(MetaCard metaCard) throws DataAccessException;

	public void deleteMetaCard(String cardCategory) throws DataAccessException;
}
