package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.PointChangeDao;
import com.pointunion.domain.dto.PointChange;
import com.pointunion.domain.qc.PointChangeQC;

public class SqlMapPointChangeDao extends SqlMapClientDaoSupport implements PointChangeDao {
	public PointChange getPointChangeByPK(Long changeSeq) throws DataAccessException {
		return (PointChange) getSqlMapClientTemplate().queryForObject("getPointChangeByPK", changeSeq);
	}

	public void insertPointChange(PointChange pointChange) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertPointChange", pointChange);
	}

	public void updatePointChange(PointChange pointChange) throws DataAccessException {
		getSqlMapClientTemplate().update("updatePointChange", pointChange, 1);
	}

	public void deletePointChange(Long changeSeq) throws DataAccessException {
		getSqlMapClientTemplate().delete("deletePointChange", changeSeq, 1);
	}

	public Collection getPointChanges(PointChangeQC pointChangeQC) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getPointChangesByQC", pointChangeQC);
	}	
}
