package coffeeMakerPackage;

public class CoffeeMaker {
	Boolean lights;
	PressureValve valve = new PressureValve();
	
	Pot pot = new Pot(null);
	
	WaterSensor waterSensor = new WaterSensor(State.BOILEREMPTY);
	BoilerHeater boilerHeater = new BoilerHeater(waterSensor);
	Boiler boiler = new Boiler(boilerHeater);	
	
	Filter filter = new Filter(pot);
	
	CoffeeMaker() {
		lights = false;
		//valve = new PressureValve();
	}
	
	public void brew() {
		// First, verify if valve is open...
		System.out.println("Verifying if pressure-relief valve is open...");
		if(valve.getState()) {
			System.out.println("Please close the valve.");
			return;
		}
		// Second, verify if there is water in boiler...
		System.out.println("Verifying if there is enough water in the boiler...");
		if(boiler.isEmpty()) {
			System.out.println("The boiler does not have water. Please will water.");
			return;
		}
		// Third, verify if the pot is in the plate heater
		if(!pot.hasPlateHeater()) {
			System.out.println("The Pot is not in the plate heater. Please put the pot in plate.");
			return;
		}
		
	}
	
	public void fillCoffee(int numberOfCups) {
		if(!valve.getState() && !boiler.isEmpty() && pot.hasPlateHeater()) {
			System.out.println("Preparing " + numberOfCups + " cups...");
			System.out.println("Coffee drips through the filter into the pot...");
			filter.filterIntoPot();
			System.out.println("If there is coffee in Pot, activating plate heater...");
			pot.getPlateHeater().setState(true); // activating plate heater
			this.lights = true; //activating lights
		}
	}	
}
