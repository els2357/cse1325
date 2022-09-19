public class ElectricVehicle extends Vehicle{
	public static double centsPerKwhOfElectricity = Double.NaN;
	private double whPerMile;
	private double kwhInBattery;
	
	public ElectricVehicle(int year, String make, String model, BodyStyle bodystyle, double whPerMile, double kwhInBattery){
		super(year, make, model, bodystyle);
		this.whPerMile = whPerMile;
		this.kwhInBattery = kwhInBattery;
	}
	
	public double range(){
		return kwhInBattery / (whPerMile/1000);
	} 
	
	public double fuelConsumed(double miles){
		if (miles < range()){
			return miles * (whPerMile/1000);
		}
		
		else {
			throw new ArithmeticException("More Fuel Consumed Than Available!");
		}
	}
	
	public double dollarsToTravel(double miles){
		return fuelConsumed(miles) * (centsPerKwhOfElectricity/1000);
	}
}
