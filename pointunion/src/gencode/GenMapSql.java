package gencode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class GenMapSql implements GenCode {

	public static void main(String[] args) {
	}

	public void genCode(MetaTable t) {
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("src/com/pointunion/dao/ibatis/maps/" + MetaTable.upHeadFormat(t.getName()) + ".xml"));
			ps.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			ps.println("<!DOCTYPE sqlMap PUBLIC \"-//iBATIS.com//DTD SQL Map 2.0//EN\" \"http://www.ibatis.com/dtd/sql-map-2.dtd\">");
			ps.println("<sqlMap>");
			ps.println("\t<resultMap id=\"result\" class=\"com.pointunion.domain." + MetaTable.upHeadFormat(t.getName()) + "\">");
			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				ps.println("\t\t<result property=\"" + MetaTable.javaFormat(column.field) + "\" column=\"" + column.field + "\"/>");
			}
			ps.println("\t</resultMap>");
			ps.println();

			// get...ByPK
			ps.println("\t<select id=\"get" + MetaTable.upHeadFormat(t.getName()) + "ByPK\" resultMap=\"result\">");
			ps.println("\t\tselect");
			int count = 0;
			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				count++;
				if (count != 1) {
					ps.println(",");
				}
				ps.print("\t\t\t" + column.field);

			}
			ps.println();
			ps.println("\t\tfrom " + t.getName() + " where " + t.getPk().field + " = #value#");
			ps.println("\t</select>");
			ps.println();

			// insert...
			ps.println("\t<insert id=\"insert" + MetaTable.upHeadFormat(t.getName()) + "\" parameterClass=\"com.pointunion.domain." + MetaTable.upHeadFormat(t.getName()) + "\">");
			ps.print("\t\tinsert into " + t.getName() + "(");
			count = 0;
			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				count++;
				if (count != 1) {
					ps.print(",");
				}
				ps.print(column.field);

			}
			ps.println(")");
			ps.print("\t\tvalues(");

			count = 0;
			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				count++;
				if (count != 1) {
					ps.print(",");
				}
				ps.print("#" + MetaTable.javaFormat(column.field) + "#");
			}
			ps.println(")");
			ps.println("\t</insert>");
			ps.println();

			// update
			ps.println("\t<update id=\"update" + MetaTable.upHeadFormat(t.getName()) + "\" parameterClass=\"com.pointunion.domain." + MetaTable.upHeadFormat(t.getName()) + "\">");
			ps.println("\t\tupdate " + t.getName() + " set");
			count = 0;
			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				count++;
				if (count > 2) {
					ps.println(",");
				}

				if (count != 1) {
					ps.print("\t\t\t" + column.field + " = #" + MetaTable.javaFormat(column.field) + "#");
				}

			}
			ps.println();
			ps.println("\t\twhere " + t.getPk().field + " = #" + MetaTable.javaFormat(t.getPk().field) + "#");
			ps.println("\t</update>");
			ps.println();

			// delete...
			ps.println("\t<delete id=\"delete" + MetaTable.upHeadFormat(t.getName()) + "\">");
			ps.println("\t\tdelete " + t.getName() + " where " + t.getPk().field + " = #value#");
			ps.println("\t</delete>");
			ps.println();

			ps.println("</sqlMap>");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
