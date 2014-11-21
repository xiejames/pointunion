package gencode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GenDaoImpl implements GenCode {

	public static void main(String[] args) {
	}

	public void genCode(MetaTable t) {
		try {
			PrintStream ps = new PrintStream(new FileOutputStream("src/com/pointunion/dao/ibatis/SqlMap" + MetaTable.upHeadFormat(t.getName()) + "Dao.java"));
			ps.println("package com.pointunion.dao.ibatis;");
			ps.println("import org.springframework.dao.DataAccessException;");
			ps.println("import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;");
			ps.println("import com.pointunion.dao.*;");
			ps.println("import com.pointunion.domain.*;");
			ps.println();

			ps.println("public class SqlMap" + MetaTable.upHeadFormat(t.getName()) + "Dao extends SqlMapClientDaoSupport implements " + MetaTable.upHeadFormat(t.getName()) + "Dao {");

			// get...ByPK
			ps.println("\tpublic " + MetaTable.upHeadFormat(t.getName()) + " get" + MetaTable.upHeadFormat(t.getName()) + "ByPK(" + MetaTable.upHeadFormat(t.getPk().type) + " " + MetaTable.javaFormat(t.getPk().field)
					+ ") throws DataAccessException {");
			ps.println("\t\treturn (" + MetaTable.upHeadFormat(t.getName()) + ") getSqlMapClientTemplate().queryForObject(\"get" + MetaTable.upHeadFormat(t.getName()) + "ByPK\", " + MetaTable.javaFormat(t.getPk().field) + ");");
			ps.println("\t}");
			ps.println();

			ps.println("\tpublic void insert" + MetaTable.upHeadFormat(t.getName()) + "(" + MetaTable.upHeadFormat(t.getName()) + " " + MetaTable.javaFormat(t.getName()) + ") throws DataAccessException {");
			ps.println("\t\tgetSqlMapClientTemplate().insert(\"insert" + MetaTable.upHeadFormat(t.getName()) + "\", " + MetaTable.javaFormat(t.getName()) + ");");
			ps.println("\t}");
			ps.println();

			ps.println("\tpublic void update" + MetaTable.upHeadFormat(t.getName()) + "(" + MetaTable.upHeadFormat(t.getName()) + " " + MetaTable.javaFormat(t.getName()) + ") throws DataAccessException {");
			ps.println("\t\tgetSqlMapClientTemplate().update(\"update" + MetaTable.upHeadFormat(t.getName()) + "\", " + MetaTable.javaFormat(t.getName()) + ");");
			ps.println("\t}");
			ps.println();

			ps.println("\tpublic void delete" + MetaTable.upHeadFormat(t.getName()) + "(" + MetaTable.upHeadFormat(t.getPk().type) + " " + MetaTable.javaFormat(t.getPk().field) + ") throws DataAccessException{");
			ps.println("\t\tgetSqlMapClientTemplate().delete(\"delete" + MetaTable.upHeadFormat(t.getName()) + "\", " + MetaTable.javaFormat(t.getPk().field) + ");");
			ps.println("\t}");
			ps.println();

			ps.println("}");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
