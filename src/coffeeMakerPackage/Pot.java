package coffeeMakerPackage;

public class Pot {
	private PlateHeater plateHeater;
	State state;
	
	Pot(PlateHeater ph) {
		this.plateHeater = ph;
	}
	
	public PlateHeater getPlateHeater() {
		return this.plateHeater;
	}
	
	public void setPlateHeater(PlateHeater ph) {
		this.plateHeater = ph;
	}
	
	public Boolean isEmpty() {
		Boolean result = false;
		State state = this.plateHeater.sensor.getState();
		if(state == State.POTEMPTY) {
			result = true;
		}
		return result;
	}
	
	public Boolean hasPlateHeater() {
		return (this.plateHeater == null) ? false : true;  
	}
}
