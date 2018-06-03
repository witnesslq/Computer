package sal.vo;

public class Sal {
	private String location;
	private int sal;

	public Sal() {
	}

	public Sal(String location, int sal) {
		this.location = location;
		this.sal = sal;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
}
