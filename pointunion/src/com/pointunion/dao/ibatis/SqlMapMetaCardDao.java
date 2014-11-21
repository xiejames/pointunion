package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.MetaCardDao;
import com.pointunion.domain.dto.MetaCard;

public class SqlMapMetaCardDao extends SqlMapClientDaoSupport implements MetaCardDao {
	public MetaCard getMetaCardByPK(String cardCategory) throws DataAccessException {
		return (MetaCard) getSqlMapClientTemplate().queryForObject("getMetaCardByPK", cardCategory);
	}
	
	public Collection getMetaCards() throws DataAccessException{
		return getSqlMapClientTemplate().queryForList("getMetaCards", null);
	}

	public void insertMetaCard(MetaCard metaCard) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertMetaCard", metaCard);
	}

	public void updateMetaCard(MetaCard metaCard) throws DataAccessException {
		getSqlMapClientTemplate().update("updateMetaCard", metaCard, 1);
	}

	public void deleteMetaCard(String cardCategory) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteMetaCard", cardCategory, 1);
	}

}
