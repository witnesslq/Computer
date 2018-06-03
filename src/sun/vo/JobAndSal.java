package sun.vo;

public class JobAndSal {
	private String jobName;
	private int sal;

	public JobAndSal() {
	}

	public JobAndSal(String jobName, int sal) {
		this.jobName = jobName;
		this.sal = sal;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
}
