package product;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MixInFlavor extends Item{
	public MixInFlavor(String name, String description, int cost, int price){
		super(name, description, cost, price);
	}
	
	public MixInFlavor(BufferedReader in) throws IOException{
		flavor = new MixInFlavor(in);
	}
	
	public void save(BufferedWriter out) throws IOException{
		super.save(out);
	}
}
