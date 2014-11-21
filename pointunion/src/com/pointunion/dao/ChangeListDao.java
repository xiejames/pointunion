package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.ChangeList;

public interface ChangeListDao {
	public Collection getChangeListBySeq(Long changeSeq) throws DataAccessException;

	public void insertChangeList(ChangeList changeList) throws DataAccessException;

	public void updateChangeList(ChangeList changeList) throws DataAccessException;

	public void deleteChangeList(Long changeSeq) throws DataAccessException;
	
	public Collection getTopChangedProducts(int size) throws DataAccessException;
}
