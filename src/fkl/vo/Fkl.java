package fkl.vo;

public class Fkl {
	private String location;
	private double fklNum;

	public Fkl() {
	}

	public Fkl(String location, double fklNum) {
		this.location = location;
		this.fklNum = fklNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getFklNum() {
		return fklNum;
	}

	public void setFklNum(double fklNum) {
		this.fklNum = fklNum;
	}
}
