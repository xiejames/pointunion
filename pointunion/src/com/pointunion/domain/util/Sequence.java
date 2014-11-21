package com.pointunion.domain.util;

import java.io.Serializable;

public class Sequence implements Serializable {
	private String seqName;
	private long nextSeq;
	public Sequence() {
	}

	public long getNextSeq() {
		return nextSeq;
	}

	public void setNextSeq(long nextSeq) {
		this.nextSeq = nextSeq;
	}

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
}
