package com.pointunion.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.BuyRecordDao;
import com.pointunion.domain.dto.BuyRecord;

public class SqlMapBuyRecordDao extends SqlMapClientDaoSupport implements BuyRecordDao {
	public BuyRecord getBuyRecordByPK(Long buySeq) throws DataAccessException {
		return (BuyRecord) getSqlMapClientTemplate().queryForObject("getBuyRecordByPK", buySeq);
	}

	public void insertBuyRecord(BuyRecord buyRecord) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertBuyRecord", buyRecord);
	}

	public void updateBuyRecord(BuyRecord buyRecord) throws DataAccessException {
		getSqlMapClientTemplate().update("updateBuyRecord", buyRecord, 1);
	}

	public void deleteBuyRecord(Long buySeq) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteBuyRecord", buySeq, 1);
	}

}
