package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.PointChange;
import com.pointunion.domain.qc.PointChangeQC;

public interface PointChangeDao {
	public PointChange getPointChangeByPK(Long changeSeq) throws DataAccessException;

	public void insertPointChange(PointChange pointChange) throws DataAccessException;

	public void updatePointChange(PointChange pointChange) throws DataAccessException;

	public void deletePointChange(Long changeSeq) throws DataAccessException;

	public Collection getPointChanges(PointChangeQC PointChangeQC) throws DataAccessException;
	
}
