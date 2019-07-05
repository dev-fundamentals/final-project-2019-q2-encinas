package coffeeMakerPackage;

public class CoffeeMaker {
	Boolean lights;
	PressureValve valve = new PressureValve();
	
	PlateSensor plateSensor = new PlateSensor();
	PlateHeater plateHeater = new PlateHeater(plateSensor);
	Pot pot = new Pot(plateHeater);
	
	WaterSensor waterSensor = new WaterSensor();
	BoilerHeater boilerHeater = new BoilerHeater(waterSensor);
	Boiler boiler = new Boiler(boilerHeater);	
	
	Filter filter = new Filter(pot);
	
	CoffeeMaker() {
		lights = false;
		//valve = new PressureValve();
	}
	
	/*public void brew() {
		System.out.println("Verifying if pressure valve is open...");
		if(valveIsOpen()) {
			System.out.println("Closing valve...");
			valve.close();
		}
	}*/
	
	public void brew() {
		System.out.println("Verifying if pressure valve is open...");
		// First, verify if valve is open...
		if(valveIsOpen()) {
			System.out.println("Please close the valve...");
		}
		// Second, verify if there is water in boiler...
		if(existWaterInBoiler()) {
			System.out.println("The boiler does not have water, please will water...");
		}
		// Third, verify if the pot is in the plate heater
		if(!pot.hasPlateHeater()) {
			System.out.println("The Pot is not in the plate heater, please put the pot in plate...");
		}
		
	}
	
	public void fillCoffee(int numberOfCups) {
		System.out.println("Preparing " + numberOfCups + "cups...");
		
		if(!valveIsOpen() && existWaterInBoiler() && pot.hasPlateHeater()) {
			filter.filterIntoPot();
		}
				
	}
	
	private Boolean valveIsOpen() {
		System.out.println("Verifying if pressure-relief valve is open...");
		return valve.getState();
	}
	
	private Boolean existWaterInBoiler() {
		System.out.println("Verifying if there is enough water in the boiler...");
		return boiler.isEmpty();
	}
}
