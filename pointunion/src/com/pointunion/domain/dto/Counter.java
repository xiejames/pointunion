package com.pointunion.domain.dto;

import java.io.Serializable;

public class Counter implements Serializable {
	private int totalCountForCounter;

	public int getTotalCountForCounter() {
		return totalCountForCounter;
	}

	public void setTotalCountForCounter(int totalCountForCounter) {
		this.totalCountForCounter = totalCountForCounter;
	}
}
