package rele.vo;

public class Rele {
	private String num;
	private String value;
	private String jobName;

	public Rele(String num, String value,String jobName) {
		this.num = num;
		this.value = value;
		this.jobName = jobName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
