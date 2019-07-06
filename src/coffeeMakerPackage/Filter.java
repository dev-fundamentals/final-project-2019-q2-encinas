package coffeeMakerPackage;

public class Filter {
	Pot pot;
	
	Filter(Pot p) {
		this.pot = p;
	}
	
	public void filterIntoPot() {
		pot.getPlateHeater().sensor.setState(State.POTNOTEMPTY);
	}
}
