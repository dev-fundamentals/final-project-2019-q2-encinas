package coffeeMakerPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarkIV {
	
	static CoffeeMaker cm = new CoffeeMaker();
	
	/*
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int capacity = cm.boiler.getCapacity();
		System.out.println("Please, enter the number of cups");
		int numberOfCups = Integer.parseInt(br.readLine());
		if(numberOfCups > capacity) {
			System.out.println("The coffee maker can only serve " + capacity + " cups");
			br.close();
		} else {
			cm.brew();
			if(cm.fillCoffee(numberOfCups)) {
				System.out.println("The coffee maker finish filling " + numberOfCups + " cups");
			}
		}
	}*/
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CoffeeMaker coffeeMaker = new CoffeeMaker();
		int option = 0;
		int capacity = cm.boiler.getCapacity();
		
		System.out.println("Please, enter the number of cups that you want");
		int numberOfCups = Integer.parseInt(br.readLine());
		
		if(numberOfCups > capacity) {
			System.out.println("The coffee maker can only serve " + capacity + " cups");
		} else {
			try {
				do {
					System.out.println("Select an option: ");
					System.out.println("1.- Prepare coffee");
					System.out.println("2.- Close pressure valve");
					System.out.println("3.- Fill water");
					System.out.println("4.- Put the Pot in the plate heater");
					/*System.out.println("5.- Drip the coffee through the filter into the pot");
					System.out.println("6.- Turn on warmer plate (pot)");
					System.out.println("7.- Turn on warmer plate (boiler)");
					System.out.println("8.- Turn off warmer plate (pot)");
					System.out.println("9.- Turn off warmer plate (boiler)");*/
					System.out.println("0.- Exit");// lights on
					
					option = Integer.parseInt(br.readLine());
					startCoffeeMakerProcess(option, numberOfCups);
					
				} while (option != 0 || coffeeMaker.lights);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void startCoffeeMakerProcess(int opt, int cups) {
		
		switch(opt) {
			case 1:
				cm.brew();
				cm.fillCoffee(cups);
				break;
			case 2:
				cm.valve.close();
				break;
			case 3:
				cm.boiler.fillWater();
				break;
			case 4:
				cm.pot.hasPlateHeater();
		}
	}
	
	
	/*
	1. Preparar cafe
	2. Llenar agua
	3. Cerrar valvula
	4. Colocar Pot en el plato calentador
	5. 
	*/
}
