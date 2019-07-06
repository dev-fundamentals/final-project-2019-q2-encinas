package coffeeMakerPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarkIV {
	
	static CoffeeMaker coffeeMaker = new CoffeeMaker();
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;
		int capacity = coffeeMaker.boiler.getCapacity();
		
		System.out.println("Please, enter the number of cups that you want");
		int numberOfCups = Integer.parseInt(br.readLine());
		
		if(numberOfCups > capacity) {
			System.out.println("The coffee maker can only serve " + capacity + " cups");
		} else {
			try {
				System.out.println("STARTING Coffee Maker");
				System.out.println("Select an option: ");
				while (!coffeeMaker.lights || option != 0) {
					if(option > 1) System.out.println("Select option 1 to continue preparing coffee");
					
					System.out.println("1.- Prepare coffee");
					System.out.println("2.- Close pressure valve");
					System.out.println("3.- Fill water");
					System.out.println("4.- Put the Pot in the plate heater");
					System.out.println("0.- Exit");
					
					option = Integer.parseInt(br.readLine());
					startCoffeeMakerProcess(option, numberOfCups);
					option = coffeeMaker.lights == true ? 0 : option; //exit of the Menu option if the lights are turned on
					if(coffeeMaker.lights) System.out.println("ENDING Coffee Maker process");
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void startCoffeeMakerProcess(int opt, int cups) {
		switch(opt) {
			case 1:
				coffeeMaker.brew();
				coffeeMaker.fillCoffee(cups);
				break;
			case 2:
				coffeeMaker.valve.close();
				System.out.println("The valve was closed.");
				break;
			case 3:
				coffeeMaker.boiler.fillWater();
				System.out.println("Now the boiler has water.");
				break;
			case 4:
				PlateSensor plateSensor = new PlateSensor(State.POTEMPTY);
				PlateHeater plateHeater = new PlateHeater(plateSensor);
				coffeeMaker.pot.setPlateHeater(plateHeater);
				System.out.println("Now the pot is in the plate heater and is turned on.");
				break;
		}		
	}
	
}
