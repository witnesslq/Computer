package rele.dao;

import rele.vo.Rele;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReleDaoImp {
	public List<Rele> getReles() throws IOException {
		List<Rele> list = new ArrayList<>();
		BufferedReader in = new BufferedReader(new FileReader(new File("/home/hadoop/tmpdata/computerrel.txt")));
		String line = null;
		while ((line = in.readLine()) != null) {
			String[] lines = line.split("\t");
			String lines1 = lines[1];
			int num = lines[2].indexOf("7");
			String string = lines[2].substring(num+1).substring(0,2);
			Rele rele = new Rele(lines1,string,lines[0]);
			list.add(rele);
		}
		return list;
	}
}
