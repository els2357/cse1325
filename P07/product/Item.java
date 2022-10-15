package product;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Item{
	protected String name;
	protected String description;
	protected int cost;
	protected int price;
	
	public Item(String name, String description, int cost, int price){
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.price = price;
	}
	
	/*public Item(BufferedReader in) throws IOException{}
	
	public void save(BufferedWriter out) throws IOException{
	}*/
	
	public String name(){
		return name;
	}
	
	public String description(){
		return description;
	}
	
	public int price(){
		return price;
	}
	
	public int cost(){
		return cost;
	}
	
	@Override
	public String toString(){
		return name;
	} 
}
