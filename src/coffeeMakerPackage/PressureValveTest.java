package coffeeMakerPackage;

import static org.junit.Assert.*;
import org.junit.Test;

public class PressureValveTest {
	
	@Test
	public void getState_valveOpen_resultTrue() {
		PressureValve p = new PressureValve();
		p.open();
		assertEquals(p.getState(), true);
	}
	
	@Test
	public void getState_valveClose_resultFalse() {
		PressureValve p = new PressureValve();
		p.close();
		assertEquals(p.getState(), false);
	}
}
