package com.pointunion.dao;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.BuyRecord;

public interface BuyRecordDao {
	public BuyRecord getBuyRecordByPK(Long buySeq) throws DataAccessException;

	public void insertBuyRecord(BuyRecord buyRecord) throws DataAccessException;

	public void updateBuyRecord(BuyRecord buyRecord) throws DataAccessException;

	public void deleteBuyRecord(Long buySeq) throws DataAccessException;
}
