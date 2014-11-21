package com.pointunion.web.util;

import java.util.Map;
import java.util.TreeMap;

public class CommomParamUtil implements java.io.Serializable {
	private String[][] industyArr = new String[][] { 
			{"0001", "����"},
			{"0002", "ũҵ/����/��ҵ��Ʒ"},
			{"0003", "����"},
			{"0004", "�����/���Ӳ�Ʒ"},
			{"0005", "����"},
			{"0006", "����Ʒ"},
			{"0007", "����(����ѧ��)"},
			{"0008", "��Դ/�ɿ�"},
			{"0009", "����/����/���ز�"},
			{"0010", "����/����/��������"},
			{"0011", "�д�"},
			{"0012", "��ý/����/����"},
			{"0013", "ҽ��/��������"},
			{"0014", "��ҩ"},
			{"0015", "����"},
			{"0016", "����"},
			{"0017", "����/����"},
			{"0018", "����/��ͨ"},
			{"0019", "���/Ӫ��/����"},
			{"9990", "����"}				
	};

	private Map industyMap = new TreeMap();

	private CommomParamUtil() {
		for (int i = 0; i < industyArr.length; i++) {
			industyMap.put(industyArr[i][0], industyArr[i][1]);
		}
	}

	private static CommomParamUtil instance = new CommomParamUtil();

	public static CommomParamUtil getInstance() {
		return instance;
	}

	public Map getIndustyMap() {
		return industyMap;
	}
	
	public String getIndusty(String code) {
		return (String)industyMap.get(code);
	}

	public boolean validateCode(String industyCode) {
		return industyMap.get(industyCode) == null ? false : true;
	}

	public static void main(String args[]) {
		
	}
}
