package product;

import java.util.ArrayList;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Order{
	private ArrayList<Serving> servings = new ArrayList<>();
	
	public Order(Serving serving){
		this.servings.clear();
	}
	
	public Order(BufferedReader in) throws IOException{		
		int count = Integer.parseInt(in.readLine());		
		for (int i = 0; i < count; i++){
			Serving serving = new Serving(in);		
			servings.add(i, serving);
		}
	}
	
	public void save(BufferedWriter out) throws IOException{
		int count = servings.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			servings.get(i).save(out);
		}
	}
	
	public void addServing(Serving serving){
		servings.add(serving);
	}

	@Override
	public String toString(){
		String order = " ";

		if (servings.isEmpty()){
			return order;
		}
		
		order = order + "topped with ";
		
		for (int i = 0; i < servings.size(); i++){
			if (i > 0) {
				order = order + ", ";
			}
			order = order + servings.get(i);
		}
		
		return order;
	}
}
