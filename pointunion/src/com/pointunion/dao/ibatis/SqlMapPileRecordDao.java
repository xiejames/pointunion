package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.PileRecordDao;
import com.pointunion.domain.dto.PileRecord;
import com.pointunion.domain.qc.PileRecordQC;

public class SqlMapPileRecordDao extends SqlMapClientDaoSupport implements PileRecordDao {
	public PileRecord getPileRecordByPK(Long pileSeq) throws DataAccessException {
		return (PileRecord) getSqlMapClientTemplate().queryForObject("getPileRecordByPK", pileSeq);
	}

	public void insertPileRecord(PileRecord pileRecord) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertPileRecord", pileRecord);
	}

	public void updatePileRecord(PileRecord pileRecord) throws DataAccessException {
		getSqlMapClientTemplate().update("updatePileRecord", pileRecord, 1);
	}

	public void deletePileRecord(Long pileSeq) throws DataAccessException {
		getSqlMapClientTemplate().delete("deletePileRecord", pileSeq, 1);
	}

	public Collection getPileRecords(PileRecordQC pileRecordQC) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getPileRecordsByQC", pileRecordQC);
	}
	
	public int getPileRecordsCount(PileRecordQC pileRecordQC) throws DataAccessException{
		pileRecordQC.setCountFlag("Y");
		PileRecord p = (PileRecord) getSqlMapClientTemplate().queryForObject("getPileRecordsByQC", pileRecordQC);
		return p.getTotalCountForCounter();
	}
}
