package coffeeMakerPackage;

public class Sensor {
	private State state;
	
	Sensor(State s) {
		this.state = s;
	}
	
	public State getState() {
		return this.state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
}

