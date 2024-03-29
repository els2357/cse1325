import java.util.Scanner;
import java.util.ArrayList;

class TravelCost{
	public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
		System.out.println("What is the price per gallon of gas?");
        final double dollarsPerGallonOfGas = scanner.nextDouble();
        System.out.println("What is the price per kWh of electricity?");
        final double centsPerKwhOfElectricity = scanner.nextDouble();
        System.out.println("How many miles is your trip?");
        double miles = scanner.nextDouble();
        
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        GasVehicle.dollarsPerGallonOfGas = dollarsPerGallonOfGas;
        ElectricVehicle.centsPerKwhOfElectricity = centsPerKwhOfElectricity;
        
        vehicles.add(new ElectricVehicle(2022, "Telsa",    "Model S Plaid",   BodyStyle.Sedan,     297, 100  ));
        vehicles.add(new ElectricVehicle(2022, "Telsa",    "Model 3 LR",      BodyStyle.Sedan,     242,  82  ));
        vehicles.add(new ElectricVehicle(2022, "GM",       "Bolt",            BodyStyle.Hatchback, 286,  66  ));
        vehicles.add(new ElectricVehicle(2022, "Nissan",   "LEAF",            BodyStyle.Hatchback, 269,  60  ));
        vehicles.add(new ElectricVehicle(2022, "Ford",     "Mustang Mach-E",  BodyStyle.SUV,       347,  88  ));
        vehicles.add(new ElectricVehicle(2022, "Ford",     "F-150 Lightning", BodyStyle.Truck,     511, 131  ));
        
        vehicles.add(new GasVehicle(     2022, "Ford",     "F-150",           BodyStyle.Truck,      25,  23  ));
        vehicles.add(new GasVehicle(     2022, "Toyota",   "Prius Hybrid",    BodyStyle.Hatchback,  55,  11.4));
        vehicles.add(new GasVehicle(     2022, "Toyota",   "RAV4",            BodyStyle.Crossover,  31,  14.5));
        vehicles.add(new GasVehicle(     2022, "Nissan",   "Rogue",           BodyStyle.Hatchback,  33,  14.5));
        vehicles.add(new GasVehicle(     2022, "Chrysler", "Pacifica",        BodyStyle.Minivan,    24,  19  ));
        vehicles.add(new GasVehicle(     2022, "Chrysler", "Pacifica Hybrid", BodyStyle.Minivan,    30,  16.5));
        
        
        for (Vehicle vehicle : vehicles){
        	double twoDecimal = vehicle.dollarsToTravel(miles);
        	System.out.print("$ ");
        	System.out.printf("%.2f", twoDecimal);
        	try {
        		System.out.print(" (range " + Math.round(vehicle.range()) + ") ");
        	} catch (ArithmeticException e){
        		e.printStackTrace();
        	} 
        	System.out.print(vehicle);
        	System.out.println();
        }
	}
}
