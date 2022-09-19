public class GasVehicle extends Vehicle{
	public static double dollarsPerGallonOfGas = Double.NaN;
	private double milesPerGallon;
	private double gallonsinTank;
	
	public GasVehicle(int year, String make, String model, BodyStyle bodystyle, double milesPerGallon, double gallonsinTank){
		super(year, make, model, bodystyle);
		this.milesPerGallon = milesPerGallon;
		this.gallonsinTank = gallonsinTank;
	}
	
	public double range(){
		return gallonsinTank * milesPerGallon;
	} 
	
	public double fuelConsumed(double miles){
		if (miles < range()){
			return miles / milesPerGallon;
		}
		
		else {
			throw new ArithmeticException("More Fuel Consumed Than Available!");
		}
	}
	
	public double dollarsToTravel(double miles){
		return fuelConsumed(miles) * dollarsPerGallonOfGas;
	}
}
