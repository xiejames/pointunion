package gencode;

import java.util.ArrayList;
import java.util.Collection;

public class MetaTable {
	private String name;

	private Collection columnList = new ArrayList();

	private Column pk;

	public Collection getColumnList() {
		return columnList;
	}

	public void add(String field, String type) {
		columnList.add(new Column(field, type));

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String javaFormat(String str) {
		return format(str, false);
	}

	public static String upHeadFormat(String str) {
		return format(str, true);
	}

	public static String format(String str, boolean flag) {
		String arr[] = str.split("_");
		StringBuffer buf = new StringBuffer();

		if (flag) {
			buf.append(upHead(arr[0]));
		} else {
			buf.append(arr[0]);
		}

		for (int i = 1; i < arr.length; i++) {
			buf.append(upHead(arr[i]));
		}

		return buf.toString();
	}

	public static String upHead(String str) {
		return (str.charAt(0) + "").toUpperCase() + str.substring(1);
	}

	public Column getPk() {
		Column c[] = new Column[1];
		c = (Column[]) columnList.toArray(c);
		return c[0];
	}

	public void setPk(Column pk) {
		this.pk = pk;
	}

	public static String getType(String type) {
		if ("string".equalsIgnoreCase(type)) {
			return "String";
		} else if ("timestamp".equalsIgnoreCase(type)) {
			return "Timestamp";
		} else if ("blob".equalsIgnoreCase(type)) {
			return "String";
		} else if ("long".equalsIgnoreCase(type)) {
			return "Long";
		} else if ("int".equalsIgnoreCase(type)) {
			return "Integer";
		} else if ("char".equalsIgnoreCase(type)) {
			return "String";
		} else if ("float".equalsIgnoreCase(type)) {
			return "Float";
		} else {
			return type;
		}
	}

}
