package gencode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		Collection tables = initTables("tables.txt");
		GenCode g1 = new GenMapSql();
		GenCode g2 = new GenDao();
		GenCode g3 = new GenDaoImpl();
		GenCode g4 = new GenDto();

		for (Iterator it = tables.iterator(); it.hasNext();) {
			MetaTable t = (MetaTable) it.next();
			// g1.genCode(t);
			// g2.genCode(t);
			// g3.genCode(t);
			g4.genCode(t);
		}
	}

	public static Collection initTables(String initFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(initFile));
		String line;
		Collection list = new ArrayList();
		MetaTable table = null;
		while ((line = reader.readLine()) != null) {
			if (line.trim().length() < 1) {
				continue;
			}

			if (line.split("[\\t ]+").length == 1) {
				table = new MetaTable();
				table.setName(line.trim());
				list.add(table);
			} else {
				String arr[] = line.split("[\\t ]+");
				table.add(arr[0].trim(), arr[1].trim());
			}
		}
		return list;
	}

}
