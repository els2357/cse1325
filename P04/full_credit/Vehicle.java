abstract class Vehicle {
	private int year;
	private String make;
	private String model;
	private BodyStyle bodystyle;
	
	public Vehicle(int year, String make, String model, Bodystyle bodystyle){
		this.year = year;
		this.make = make;
		this.model = model;
		this.bodystyle = bodystyle;
	}
	
	public double range(){
		return;
	}
	
	public double fuelConsumed(double miles){
		return;
	}
	
	public double dollarsToTravel(double miles){
		return;
	}
	
	@Override
	public String toString(){
		return;
	}
}
