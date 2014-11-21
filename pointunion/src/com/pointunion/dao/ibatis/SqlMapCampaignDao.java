package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.CampaignDao;
import com.pointunion.domain.dto.Campaign;
import com.pointunion.domain.qc.CampaignQC;

public class SqlMapCampaignDao extends SqlMapClientDaoSupport implements CampaignDao {
	public Campaign getCampaignByPK(String campaignNo) throws DataAccessException {
		return (Campaign) getSqlMapClientTemplate().queryForObject("getCampaignByPK", campaignNo);
	}

	public void insertCampaign(Campaign campaign) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertCampaign", campaign);
	}

	public void updateCampaign(Campaign campaign) throws DataAccessException {
		getSqlMapClientTemplate().update("updateCampaign", campaign, 1);
	}

	public void deleteCampaign(String campaignNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCampaign", campaignNo, 1);
	}

	public Collection getCampaigns(CampaignQC campaignQC) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getCampaignsByQC", campaignQC);
	}

	public int getCampaignsCount(CampaignQC campaignQC) throws DataAccessException {
		campaignQC.setCountFlag("Y");
		Campaign c = (Campaign) getSqlMapClientTemplate().queryForObject("getCampaignsByQC", campaignQC);
		return c.getTotalCountForCounter();
	}

}
