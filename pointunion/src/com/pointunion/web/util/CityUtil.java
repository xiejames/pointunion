package com.pointunion.web.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CityUtil implements java.io.Serializable  {
	private String[][] cityArr = new String[][]{
			{"����",	"�Ϸ�|����|����|��ɽ|��ɽ|����|����|ͭ��|�ߺ�|����|����|����|����|���|����|����|����|����|�쳤|����|����"},
			{"����",	"����"},
			{"����",	"����"},
			{"����",	"����|����|Ȫ��|����|��ƽ|����|����|����|����|����ɽ|����|ʯʨ|����"},
			{"����",	"����|������|���|����|��ˮ|����|�ػ�|����|��Ҵ|ƽ��|����|��Ȫ|����|����"},
			{"�㶫",	"����|����|�麣|�ع�|����|��ͷ|����|տ��|��ɽ|�»�|��Դ|����|����|�Ϻ�|����"},
			{"����",	"����|����|����|����|��ɽ|ƾ��|����|����|����"},
			{"����",	"����|��˳|����ˮ|����|����|����|ͭ��|����|����|�Ͻ�|��ˮ|�ʻ�|��Զ|����"},
			{"����",	"����|����|��|����|ͨʲ|����"},
			{"�ӱ�",	"ʯ��ׯ|��ɽ|����|�ػʵ�|��̨|����|�żҿ�|�е�|����|����|�ȷ�|����|��|��ˮ|����"},
			{"����",	"֣��|����|����|����|ƽ��ɽ|�ױ�|����|����|����|���|����|����|���|����Ͽ|����|���|פ���|�ܿ�|����"},
			{"������","������|����|��ľ˹|ĵ����|�������|����|�绯|�ں�|�����|��Һ�|����"},
			{"����",	"�人|��ʯ|��ɳ|ʮ��|�差|�˲�|����|�Ƹ�|����|����|�Ϻӿ�|����"},
			{"����",	"��ɳ|����|����|��̶|����|����|����|����|����|����|����|�żҽ�|����"},
			{"����",	"����|����|��Դ|��ƽ|ͨ��|�׳�|��ɽ|����|����|ͼ��|�Ӽ�|����"},
			{"����",	"�Ͼ�|����|���Ƹ�|����|����|����|����|����|��ͨ|���|̩��|ͨ��|����|����|��|����|��̨|̫��|����"},
			{"����",	"�ϲ�|������|Ƽ��|�Ž�|����|����|����|�ٴ�|���|����|����"},
			{"����",	"����|����|����|����|�̽�|��ɽ|��˳|��Ϫ|Ӫ��|����|����|����|����|��«��|����|�˳�|����"},
			{"���ɹ�","���ͺ���|��ͷ|�ں�|���|��ʤ|��������|������|ͨ��|���ֺ���|����|����"},
			{"����",	"����|ʯ��ɽ|����|��ͭϿ|��ԭ|����"},
			{"�ຣ",	"����|�����|���ľ|ǡ��ǡ|��Դ|ͬ��|����"},
			{"ɽ��",	"����|�ൺ|�Ͳ�|��̨|����|����|̩��|Ϋ��|��Ӫ|��ׯ|����|�ĳ�|����|����|����|����|����|����|��ī|�ٳ�|�޳�|��ɽ|̩��|����"},
			{"ɽ��",	"̫ԭ|�ٷ�|��ͬ|��Ȫ|����|����|����|�ܴ�|����|�˳�|˷��|���|����|ƽң|����|����"},
			{"����",	"����|ͭ��|����|����|μ��|����|�Ӱ�|����|����|����|����|����|��ƽ|����"},
			{"�Ϻ�",	"�Ϻ�"},
			{"�Ĵ�",	"�ɶ�|����|��֦��|�Թ�|����|��ɽ|�˱�|�ﴨ|����|����|�ϳ�|����|����|�Ű�|��Ԫ|������|����|����|����|����"},
			{"���",	"���"},
			{"����",	"����|�տ���|��֥|����|����|�޲��ֿ�|����"},
			{"�½�",	"��³ľ��|��������|��³��|ʯ����|����̩|������|�����|��ͼʲ|����|����|��Ȫ|����|��ʲ|����|����|����|����|����|��ɽ|����"},
			{"����",	"����|����|����|����|��Զ|����|����|��|��ͨ|��Ϫ|����|����|��ɽ|˼é|����|����|��ˮ|����"},
			{"�㽭",	"����|����|����|����|��|����|����|��Ϫ|�|����|��Ϫ|��ˮ|�ٺ�|��|����|��ɽ|��Ҧ|��ɽ|����|�ٰ�|ƽ��|����|̨��|����"},
			{"���",	"���|����|�½�|����"},
			{"����",	"����"},
			{"̨��",	"̨��|����|̨��|̨��|��¡|����|����"},
			{"����",	"����"}
	};
	
	private Map provinceMap = new TreeMap();		
	private CityUtil(){
		for (int i = 0; i < cityArr.length; i++) {
			Province p = new Province(cityArr[i][0].trim(), formatInt(i+1));
			String tmpArr[] = cityArr[i][1].split("\\|");
			for (int j = 0; j < tmpArr.length; j++) {
				City c = new City(tmpArr[j], formatInt(j));
				p.getCityMap().put(c.getCityCode(), c);	
			}			
			provinceMap.put(p.getProvinceCode(), p);
		}	
	}	
	
	private static CityUtil instance = new CityUtil();
	public static CityUtil getInstance() {
		return instance;
	}
	
	public Collection getProvinces(){
		return provinceMap.values();
	}
	
	public Province getProvince(String code){
		return (Province)provinceMap.get(code);
	}
	
	public City getCity(String provinceCode, String cityCode){
		Province p = getProvince(provinceCode);
		if(p==null){
			return null;
		}else{
			return (City)p.getCityMap().get(cityCode);
		}
	}
	
	public boolean validateCode(String provinceCode, String cityCode){
		Province p = (Province)provinceMap.get(provinceCode);
		if(p!=null){
			if(p.getCityMap().get(cityCode)!=null){
				return true;
			}
		}		
		return false;
	}	
	
	private String formatInt(int i){
		return ("0000"+i).substring(("0000"+i).length()-4);
	}
	
	public static void main(String args[]) {
		for (Iterator it = CityUtil.getInstance().getProvinces().iterator(); it.hasNext();) {
			Province p = (Province) it.next();
			System.out.println(p.getProvince() + "\t" + p.getProvinceCode());
			for (Iterator iter = p.getCities().iterator(); iter.hasNext();) {
				City c = (City) iter.next();
				System.out.println("\t" + c.getCity() + "\t" + c.getCityCode());
			}
			System.out.println();
		}
		;
	}	
}
