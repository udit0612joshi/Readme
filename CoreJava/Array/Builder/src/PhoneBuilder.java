
public class PhoneBuilder {

	private String os;
	private int ram;
	private String processsor;
	private int battery;
	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}
	private PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}
	public PhoneBuilder setProcesssor(String processsor) {
		this.processsor = processsor;
		return this;
	}
	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;
	}
	
	
	public Phone getPhone()
	{
		return new Phone(os, ram, processsor, battery);
		
	}
	
	
	
	
}
