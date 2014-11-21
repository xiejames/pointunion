package gencode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class GenDto implements GenCode {

	public static void main(String[] args) {
	}

	public void genCode(MetaTable t) {
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("src/com/pointunion/domain/" + MetaTable.upHeadFormat(t.getName()) + ".java"));
			ps.println("package com.pointunion.domain;");
			ps.println("import java.sql.Timestamp;");
			ps.println("import java.io.Serializable;");
			ps.println();

			ps.println("public class " + MetaTable.upHeadFormat(t.getName()) + " implements Serializable{");

			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				ps.println("\tprivate " + MetaTable.getType(column.type) + " " + MetaTable.javaFormat(column.field) + ";");
			}
			ps.println();

			ps.println("\tpublic " + MetaTable.upHeadFormat(t.getName()) + "() {");
			ps.println("\t}");
			ps.println();

			ps.print("\tpublic " + MetaTable.upHeadFormat(t.getName()) + "(");
			int count = 0;
			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				count++;
				if (count != 1) {
					ps.print(",");
				}
				ps.print(MetaTable.getType(column.type) + " " + MetaTable.javaFormat(column.field));
			}
			ps.println(") {");

			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				ps.println("\t\tthis." + MetaTable.javaFormat(column.field) + " = " + MetaTable.javaFormat(column.field) + ";");
			}
			ps.println("\t}");
			ps.println();

			for (Iterator j = t.getColumnList().iterator(); j.hasNext();) {
				Column column = (Column) j.next();
				ps.println("\tpublic " + MetaTable.getType(column.type) + " get" + MetaTable.upHeadFormat(column.field) + "(){");
				ps.println("\t\treturn " + MetaTable.javaFormat(column.field) + ";");
				ps.println("\t}");
				ps.println();

				ps.println("\tpublic void set" + MetaTable.upHeadFormat(column.field) + "(" + MetaTable.getType(column.type) + " " + MetaTable.javaFormat(column.field) + "){");
				ps.println("\t\tthis." + MetaTable.javaFormat(column.field) + " = " + MetaTable.javaFormat(column.field) + ";");
				ps.println("\t}");
				ps.println();
			}

			ps.println("}");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
