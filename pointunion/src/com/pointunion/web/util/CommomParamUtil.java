package com.pointunion.web.util;

import java.util.Map;
import java.util.TreeMap;

public class CommomParamUtil implements java.io.Serializable {
	private String[][] industyArr = new String[][] { 
			{"0001", "航天"},
			{"0002", "农业/化工/林业产品"},
			{"0003", "汽车"},
			{"0004", "计算机/电子产品"},
			{"0005", "建筑"},
			{"0006", "消费品"},
			{"0007", "教育(包括学生)"},
			{"0008", "能源/采矿"},
			{"0009", "金融/保险/房地产"},
			{"0010", "政府/军事/公共服务"},
			{"0011", "招待"},
			{"0012", "传媒/出版/娱乐"},
			{"0013", "医疗/保健服务"},
			{"0014", "制药"},
			{"0015", "零售"},
			{"0016", "服务"},
			{"0017", "电信/网络"},
			{"0018", "旅游/交通"},
			{"0019", "广告/营销/公关"},
			{"9990", "其他"}				
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
