/**
 * @author xielingjiang
 * @since 10.06.2006
 */
package com.pointunion.domain.dto;

import java.util.Collection;

public class PointChangeDetail extends PointChange {
	private Collection changeList;

	public PointChangeDetail() {
	}

	public PointChangeDetail(PointChange father) {
		setPointChange(father);
	}

	public void setPointChange(PointChange father) {
		setChangeSeq(father.getChangeSeq());
		setAccountNo(father.getAccountNo());
		setTotalCount(father.getTotalCount());
		setTotalPoint(father.getTotalPoint());
		setChangeTime(father.getChangeTime());
		setAddress(father.getAddress());
		setZip(father.getZip());
		setName(father.getName());
		setTelNo(father.getTelNo());
		setMobile(father.getMobile());
		setStatus(father.getStatus());
		setCreateTime(father.getCreateTime());
		setModifyTime(father.getModifyTime());
	}

	public Collection getChangeList() {
		return changeList;
	}

	public void setChangeList(Collection changeList) {
		this.changeList = changeList;
	}
}