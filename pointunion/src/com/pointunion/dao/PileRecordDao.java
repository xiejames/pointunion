package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.PileRecord;
import com.pointunion.domain.qc.PileRecordQC;

public interface PileRecordDao {
	public PileRecord getPileRecordByPK(Long pileSeq) throws DataAccessException;

	public void insertPileRecord(PileRecord pileRecord) throws DataAccessException;

	public void updatePileRecord(PileRecord pileRecord) throws DataAccessException;

	public void deletePileRecord(Long pileSeq) throws DataAccessException;

	public Collection getPileRecords(PileRecordQC pileRecordQC) throws DataAccessException;
	
	public int getPileRecordsCount(PileRecordQC pileRecordQC) throws DataAccessException;
	
}
