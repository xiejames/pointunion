package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.ChangeListDao;
import com.pointunion.domain.dto.ChangeList;

public class SqlMapChangeListDao extends SqlMapClientDaoSupport implements ChangeListDao {
	public Collection getChangeListBySeq(Long changeSeq) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getChangeListByPK", changeSeq);
	}

	public void insertChangeList(ChangeList changeList) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertChangeList", changeList);
	}

	public void updateChangeList(ChangeList changeList) throws DataAccessException {
		getSqlMapClientTemplate().update("updateChangeList", changeList, 1);
	}

	public void deleteChangeList(Long changeSeq) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteChangeList", changeSeq, 1);
	}
	
	public Collection getTopChangedProducts(int size) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getTopChangedProducts", new Integer(size));
	}
}
