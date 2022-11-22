package product;

import java.util.ArrayList;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Order{
	private ArrayList<Serving> servings;
	
	public Order(){
		this.servings = new ArrayList<>();
	}
	
	public Order(BufferedReader in) throws IOException{	
		this.servings = new ArrayList<>();
		int count = Integer.parseInt(in.readLine());		
		for (int i = 0; i < count; i++){
			Serving serving = new Serving(in);		
			servings.add(i, serving);
		}
	}
	
	public void save(BufferedWriter out) throws IOException{
		out.write(servings.size() + "\n");
		for(Serving s : servings) s.save(out);
	}
	
	public void addServing(Serving serving){
		servings.add(serving);
	}

	public double price(){
		double orderPrice = 0;
		if (servings.size() > 0){
			for (int i=0; i<= servings.size(); i++){
				orderPrice += servings.get(i).price();
			}
		}
		return orderPrice;
	}

	@Override
	public String toString(){
        StringBuilder result = new StringBuilder();
        String separator = "";
        int count = 0;
        if(servings.size() > 0) {
            for(Serving s : servings) {
                result.append("Order" + " " + (count++) + " - $" + s.price() + "<br/>" + separator + s.toString());
                separator = "<br/>";
            }
        }
        return result.toString();
	}
}
