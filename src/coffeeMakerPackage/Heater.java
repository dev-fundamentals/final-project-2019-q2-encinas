package coffeeMakerPackage;

public class Heater {
	private Boolean state;
	Sensor sensor = new Sensor();
	
	Heater(Sensor s) {
		this.state = false; //turn off by default
		this.sensor = s;
	}
	
	public Boolean getState() {
		return this.state;
	}
	
	public void setState(Boolean s) {
		this.state = s;
	}
}