
public class Phone {
	private String os;
	private int ram;
	private String processsor;
	private int battery;
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getProcesssor() {
		return processsor;
	}
	public void setProcesssor(String processsor) {
		this.processsor = processsor;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public Phone(String os, int ram, String processsor, int battery) {
		super();
		this.os = os;
		this.ram = ram;
		this.processsor = processsor;
		this.battery = battery;
	}
	@Override
	public String toString() {
		return "Phone [os=" + os + ", ram=" + ram + ", processsor=" + processsor + ", battery=" + battery + "]";
	}
	
	
	
	
}
