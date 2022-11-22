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
	private ArrayList<Scoop> scoops;
	private ArrayList<MixIn> toppings;
	
	
	public Serving(Container container){
		this.container = container;
        this.scoops = new ArrayList<>();
        this.toppings = new ArrayList<>();
	}
	
	public Serving(BufferedReader in) throws IOException{
        this.container = new Container(in);
        this.scoops = new ArrayList<>();
        int numScoops = Integer.parseInt(in.readLine());
        while(numScoops-- > 0) scoops.add(new Scoop(in));
        this.toppings = new ArrayList<>();
        int numToppings = Integer.parseInt(in.readLine());
        while(numToppings-- > 0) toppings.add(new MixIn(in));
	}
	
	public void save(BufferedWriter out) throws IOException{
        container.save(out);
        out.write("" + scoops.size() + '\n');
        for(Scoop s : scoops) s.save(out);
        out.write("" + toppings.size() + '\n');
        for(MixIn t : toppings) t.save(out);
	}
	
	public void addScoop(Scoop scoop){
		scoops.add(scoop);
	}
	
	public void addTopping(MixIn topping){
		toppings.add(topping);
	}
	
	public int numScoops(){
		return scoops.size();
	}
	
	public double price(){
		double scoopsPrice = 0;
		double toppingsPrice = 0;
		if (scoops.size() > 0){
			for (int i=0; i< scoops.size(); i++){
				scoopsPrice += scoops.get(i).price();
			}
		}
		
		if 	(toppings.size() > 0){
			for (int i=0; i< toppings.size(); i++){
				toppingsPrice += toppings.get(i).price();
			}
		}
		double servingPrice = scoopsPrice + toppingsPrice;
		return servingPrice;
	}
	
	@Override
	public String toString(){
        StringBuilder result = new StringBuilder(container.toString());
        if(scoops.size() > 0) {
            String separator = (scoops.size() == 1) ? " with a scoop of " : " with scoops of ";
            for(Scoop s : scoops) {
                result.append(separator + s.toString());
                separator = ", ";
            }
        }
        if(toppings.size() > 0) {
            String separator = (toppings.size() == 1) ? " and topped with " : " and toppings of ";
            for(MixIn t : toppings) {
                result.append(separator + t.toString());
                separator = ", ";
            }
        }
        return result.toString();
	}
}
