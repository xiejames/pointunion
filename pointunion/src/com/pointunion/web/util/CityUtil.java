package com.pointunion.web.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CityUtil implements java.io.Serializable  {
	private String[][] cityArr = new String[][]{
			{"安徽",	"合肥|淮北|蚌埠|马鞍山|黄山|安庆|淮南|铜陵|芜湖|亳州|巢湖|滁州|阜阳|贵池|界首|六安|明光|宿州|天长|宣州|其它"},
			{"北京",	"北京"},
			{"重庆",	"重庆"},
			{"福建",	"福州|厦门|泉州|漳州|南平|三明|莆田|龙岩|晋江|武夷山|永安|石狮|其它"},
			{"甘肃",	"兰州|嘉峪关|金昌|玉门|天水|白银|敦煌|武威|张掖|平凉|临夏|酒泉|西峰|其它"},
			{"广东",	"广州|深圳|珠海|韶关|潮州|汕头|肇庆|湛江|佛山|新会|河源|潮阳|揭阳|南海|其它"},
			{"广西",	"南宁|柳州|桂林|北海|合山|凭祥|梧州|玉林|其它"},
			{"贵州",	"贵阳|安顺|六盘水|遵义|凯里|都匀|铜仁|兴义|清镇|毕节|赤水|仁怀|镇远|其它"},
			{"海南",	"海口|三亚|琼海|儋州|通什|其它"},
			{"河北",	"石家庄|唐山|邯郸|秦皇岛|邢台|保定|张家口|承德|沧州|定州|廊坊|涿州|遵化|衡水|其它"},
			{"河南",	"郑州|焦作|商丘|洛阳|平顶山|鹤壁|新乡|安阳|开封|漯河|南阳|南阳|濮阳|三门峡|信阳|许昌|驻马店|周口|其他"},
			{"黑龙江","哈尔滨|大庆|佳木斯|牡丹江|齐齐哈尔|伊春|绥化|黑河|五大连|绥芬河|其它"},
			{"湖北",	"武汉|黄石|荆沙|十堰|襄樊|宜昌|鄂州|黄冈|随州|荆门|老河口|其它"},
			{"湖南",	"长沙|衡阳|邵阳|湘潭|岳阳|株洲|常德|津市|耒阳|醴陵|益阳|张家界|其它"},
			{"吉林",	"长春|吉林|辽源|四平|通化|白城|白山|珲春|集安|图们|延吉|其它"},
			{"江苏",	"南京|徐州|连云港|苏州|无锡|常州|常熟|淮安|南通|如皋|泰州|通州|扬州|宜兴|镇江|海门|东台|太湖|其它"},
			{"江西",	"南昌|景德镇|萍乡|九江|赣州|新余|吉安|临川|瑞昌|樟树|其它"},
			{"辽宁",	"沈阳|锦州|丹东|大连|盘锦|鞍山|抚顺|本溪|营口|铁岭|朝阳|东港|海城|葫芦岛|辽阳|兴城|其它"},
			{"内蒙古","呼和浩特|包头|乌海|赤峰|东胜|二连浩特|满洲里|通辽|锡林浩特|根河|其它"},
			{"宁夏",	"银川|石嘴山|吴忠|青铜峡|固原|其它"},
			{"青海",	"西宁|德令哈|格尔木|恰卜恰|湟源|同仁|其它"},
			{"山东",	"济南|青岛|淄博|烟台|济宁|德州|泰安|潍坊|东营|枣庄|莱芜|聊城|青州|日照|威海|曲阜|兖州|荷泽|即墨|荣成|邹城|崂山|泰安|其它"},
			{"山西",	"太原|临汾|大同|阳泉|晋城|长治|忻州|榆次|侯马|运城|朔州|新绛|代县|平遥|祁县|其它"},
			{"陕西",	"西安|铜川|宝鸡|汉中|渭南|咸阳|延安|榆林|韩城|安康|华阴|商州|兴平|其它"},
			{"上海",	"上海"},
			{"四川",	"成都|泸州|攀枝花|自贡|阆中|乐山|宜宾|达川|华蓥|江油|南充|万县|西昌|雅安|广元|都江堰|康定|松潘|绵阳|其它"},
			{"天津",	"天津"},
			{"西藏",	"拉萨|日喀则|林芝|昌都|那曲|罗布林卡|其它"},
			{"新疆",	"乌鲁木齐|克拉玛依|吐鲁番|石河子|阿勒泰|阿克苏|库尔勒|阿图什|奎屯|伊宁|米泉|塔城|喀什|哈密|昌吉|博乐|和田|阜康|天山|其它"},
			{"云南",	"昆明|大理|东川|个旧|开远|景洪|瑞丽|畹町|昭通|玉溪|楚雄|曲靖|保山|思茅|宣威|安宁|建水|其它"},
			{"浙江",	"杭州|宁波|温州|绍兴|金华|嘉兴|衢州|慈溪|奉化|海宁|兰溪|丽水|临海|瑞安|上虞|萧山|余姚|舟山|富阳|临安|平湖|嵊州|台州|其它"},
			{"香港",	"香港|九龙|新界|其它"},
			{"澳门",	"澳门"},
			{"台湾",	"台北|高雄|台中|台南|基隆|新竹|其它"},
			{"其它",	"其它"}
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
