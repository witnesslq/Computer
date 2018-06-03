package sal.dao;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import sal.vo.Sal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalDaoImp {
	public List<Sal> getSalList() throws IOException {
		List<Sal> list = new ArrayList<>();

		Configuration conf = new Configuration();
		conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
		conf.addResource(new Path("/home/hadoop/app/hadoop/etc/hadoop/core-site.xml"));
		conf.addResource(new Path("/home/hadoop/app/hadoop/etc/hadoop/hdfs-site.xml"));
		FileSystem fs = FileSystem.get(conf);
		FSDataInputStream fin = fs.open(new Path("hdfs://master:9000//out/Computer/computer/part-r-00000"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(fin,"UTF-8"));
		String line = null;
		int num=0;
		while ((line = reader.readLine()) != null) {
			String[] lines = line.split("\t");
			Sal sal = new Sal(lines[0], Integer.parseInt(lines[2]));
			list.add(sal);

			if (num==30){
				break;
			}

			++num;
		}
		return list;
	}
}
