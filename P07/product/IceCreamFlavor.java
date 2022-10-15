package product;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IceCreamFlavor extends Item{
	public IceCreamFlavor(String name, String description, int cost, int price){
		super(name, description, cost, price);
	}
	
	/*public IceCreamFlavor(BufferedReader in) throws IOException{
	}
	
	public void save(BufferedReader out) throws IOException{
	}*/
}
