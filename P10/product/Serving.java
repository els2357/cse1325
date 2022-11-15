package product;

import java.util.ArrayList;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Serving{
	private Container container;
	private ArrayList<Scoop> scoops = new ArrayList<>();
	private ArrayList<MixIn> toppings = new ArrayList<>();
	
	
	public Serving(Container container){
		this.container = container;
		this.scoops.clear();
		this.toppings.clear();
	}
	
	public Serving(BufferedReader in) throws IOException{
		container = new Container(in);
		
		int count = Integer.parseInt(in.readLine());		
		for (int i = 0; i < count; i++){
			Scoop scoop = new Scoop(in);		
			scoops.add(i, scoop);
		}
		
		count = Integer.parseInt(in.readLine());
		for (int i = 0; i < count; i++){
			MixIn topping = new MixIn(in);		
			toppings.add(i, topping);
		}
	}
	
	public void save(BufferedWriter out) throws IOException{
		container.save(out);
		
		int count = scoops.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			scoops.get(i).save(out);
		}
		
		count = toppings.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			toppings.get(i).save(out);
		}
	}
	
	public void addScoop(Scoop scoop){
		scoops.add(scoop);
	}
	
	public void addTopping(MixIn topping){
		toppings.add(topping);
	}

	@Override
	public String toString(){
		String serving = container + " ";

		if (scoops.isEmpty()){
			return serving;
		}
		
		serving = serving + "with ";
		
		for (int i = 0; i < scoops.size(); i++){
			if (i > 0) {
				serving = serving + ", ";
			}
			serving = serving + scoops.get(i);
		}
		
		return serving;
	}
}
