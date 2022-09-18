public class ElectricVehicle extends Vehicle{
	public static double centsPerKwhOfElectricity  = Double.NaN;
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
		//if more fuel is consumed than available (per gallonsInTank), throw an ArithmeticException with an appropriate message.
		return miles * (whPerMile/1000);
	}
	
	public double dollarsToTravel(double miles){
		return fuelConsumed(miles) * (centsPerKwhOfElectricity/1000);
	}
}
