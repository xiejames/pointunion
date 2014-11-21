package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.Campaign;
import com.pointunion.domain.qc.CampaignQC;

public interface CampaignDao {
	public Campaign getCampaignByPK(String campaignNo) throws DataAccessException;

	public void insertCampaign(Campaign campaign) throws DataAccessException;

	public void updateCampaign(Campaign campaign) throws DataAccessException;

	public void deleteCampaign(String campaignNo) throws DataAccessException;

	public Collection getCampaigns(CampaignQC campaignQC) throws DataAccessException;

	public int getCampaignsCount(CampaignQC campaignQC) throws DataAccessException;
}
