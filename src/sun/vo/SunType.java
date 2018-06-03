package sun.vo;

import java.util.List;

public class SunType {
	private String mlocation;
	private List<JobAndSal> jobAndSal;

	public SunType() {

	}

	public SunType(String location, List<JobAndSal> jobAndSal) {
		this.mlocation = location;
		this.jobAndSal = jobAndSal;
	}

	public String getMlocation() {
		return mlocation;
	}

	public void setMlocation(String mlocation) {
		this.mlocation = mlocation;
	}

	public List<JobAndSal> getJobAndSal() {
		return jobAndSal;
	}

	public void setJobAndSal(List<JobAndSal> jobAndSal) {
		this.jobAndSal = jobAndSal;
	}
}
