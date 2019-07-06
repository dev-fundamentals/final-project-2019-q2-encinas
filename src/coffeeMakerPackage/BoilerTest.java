package coffeeMakerPackage;

import static org.junit.Assert.*;
import org.junit.Test;


public class BoilerTest {

	@Test
	public void isEmpty_emptyBoiler_resultTrue() {
		WaterSensor s = new WaterSensor(State.BOILEREMPTY);
		BoilerHeater boilerHeater = new BoilerHeater(s);
		Boiler b = new Boiler(boilerHeater);
		assertTrue(b.isEmpty());
	}
	
	@Test
	public void isEmpty_notEmptyBoiler_resultFalse() {
		WaterSensor s = new WaterSensor(State.BOILERNOTEMPTY);
		BoilerHeater boilerHeater = new BoilerHeater(s);
		Boiler b = new Boiler(boilerHeater);
		assertFalse(b.isEmpty());
	}
	
	
	@Test
	public void fillWater_notEmptyBoiler_resultFalse() {
		WaterSensor s = new WaterSensor(null);
		BoilerHeater boilerHeater = new BoilerHeater(s);
		Boiler b = new Boiler(boilerHeater);
		b.fillWater();
		assertEquals(State.BOILERNOTEMPTY, b.getBoilerHeater().sensor.getState());
	}
}
