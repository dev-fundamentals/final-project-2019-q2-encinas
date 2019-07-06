package coffeeMakerPackage;

public class PressureValve {
	
	private Boolean state;
	
	PressureValve() {
		this.state = true; //open by default
	}
	
	public Boolean getState() {
		return this.state;
	}
	
	public void open() {
		this.state = true;
	} 
	
	public void close() {
		System.out.println("Closing valve...");
		this.state = false;
	}
}
