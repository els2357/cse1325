package product;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Container{
	protected String name;
	protected String description;
	protected int maxScoops;
	
	public Container(String name, String description, int maxScoops){
		this.name = name;
		this.description = description;
		this.maxScoops = maxScoops;
	}
	
	public Container(BufferedReader in) throws IOException{
		name = in.readLine();
		description = in.readLine();		
		maxScoops = Integer.parseInt(in.readLine());
	}
	
	public void save(BufferedWriter out) throws IOException{
		out.write("" + name + '\n');
		out.write("" + description + '\n');
		out.write("" + maxScoops + '\n');
	}
	
	@Override
	public String toString(){
		return name;
	} 
}
