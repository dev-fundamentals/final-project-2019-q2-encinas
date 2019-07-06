package coffeeMakerPackage;

import static org.junit.Assert.*;
import org.junit.Test;

public class PotTest {
	
	@Test
	public void isEmpty_emptyPot_resultTrue() {
		PlateSensor sensor = new PlateSensor(State.POTEMPTY);
		PlateHeater plateHeater = new PlateHeater(sensor);
		Pot pot = new Pot(plateHeater);
		assertTrue(pot.isEmpty());
	}
	
	@Test
	public void isEmpty_notEmptyPot_resultFalse() {
		PlateSensor sensor = new PlateSensor(State.POTNOTEMPTY);
		PlateHeater plateHeater = new PlateHeater(sensor);
		Pot pot = new Pot(plateHeater);
		assertFalse(pot.isEmpty());
	}
	
	@Test
	public void isPotInPlate_nullSensor_resultTrue() {
		Pot pot = new Pot(null);
		assertNull(pot.getPlateHeater());
	}
	
	@Test
	public void isPotInPlate_notNullSensor_resultFalse() {
		PlateHeater plateHeater = new PlateHeater(new Sensor(null));
		Pot pot = new Pot(plateHeater);
		assertNotNull(pot.getPlateHeater());
	}
}


