package sun.dao;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import sun.vo.JobAndSal;
import sun.vo.SunType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SunDaoImp {
	public List<SunType> getSunType() throws IOException {
		List<SunType> list = new ArrayList<>();

		Configuration conf = new Configuration();
		conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
		conf.addResource(new Path("/home/hadoop/app/hadoop/etc/hadoop/core-site.xml"));
		conf.addResource(new Path("/home/hadoop/app/hadoop/etc/hadoop/hdfs-site.xml"));
		FileSystem fs = FileSystem.get(conf);
		FSDataInputStream fin = fs.open(new Path("hdfs://master:9000/out/Computer/suncomputer/part-r-00000"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
		String line = null;
		int num = 0;
		while ((line = reader.readLine()) != null) {
			if (num % 20 == 1) {
				String[] lines = line.split("\t");
				String location = lines[0];
				String jobName = lines[1];
				int sal = Integer.parseInt(lines[2]);

				if (jobName.length() >= 15) {
					continue;
				}

				if (list.size() == 0) {
					List<JobAndSal> list1 = new ArrayList<JobAndSal>();
					list1.add(new JobAndSal(jobName, sal));
					SunType type2 = new SunType(location, list1);
					list.add(type2);
				}

				for (int i = list.size() - 1; i >= 0; i--) {
					if (location.equals(list.get(i).getMlocation())) {
						list.get(i).getJobAndSal().add(new JobAndSal(jobName, sal));
						break;
					} else {
						List<JobAndSal> list1 = new ArrayList<JobAndSal>();
						list1.add(new JobAndSal(jobName, sal));
						SunType type2 = new SunType(location, list1);
						list.add(type2);
						break;
					}
				}
			}


			if (num == 2500) {
				break;
			}
			++num;
		}

		if (reader != null) {
			reader.close();
		}

		return list;
	}
}
