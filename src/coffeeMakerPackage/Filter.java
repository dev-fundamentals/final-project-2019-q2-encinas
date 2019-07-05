package coffeeMakerPackage;

public class Filter {
	Pot pot;
	
	Filter(Pot p) {
		this.pot = p;
	}
	
	public void filterIntoPot() {
		System.out.println("Coffee drips through the filter into the pot...");
		pot.getPlateHeater().sensor.setState(State.POTNOTEMPTY);
	}
}
