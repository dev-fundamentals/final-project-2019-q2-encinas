package coffeeMakerPackage;

public class Boiler {
	private static final int CAPACITY = 12;
	private BoilerHeater boilerHeater;
	
	Boiler(BoilerHeater b) {
		this.boilerHeater = b;
	}
	
	public int getCapacity() {
		return CAPACITY;
	}
	
	public BoilerHeater getBoilerHeater() {
		return this.boilerHeater;
	}
	
	public Boolean isEmpty() {
		Boolean result = false;
		State state = this.boilerHeater.sensor.getState();
		if(state.equals(State.BOILEREMPTY)) {
			result = true;
		}
		return result;
	}
	
	public void fillWater() {
		System.out.println("Filling water in boiler...");
		boilerHeater.sensor.setState(State.BOILERNOTEMPTY);
	}

}
