package product;

import java.util.ArrayList;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scoop{
	private IceCreamFlavor flavor;
	private ArrayList<MixIn> mixins;
	
	public Scoop(IceCreamFlavor flavor){
		this.flavor = flavor;
		this.mixins = new ArrayList<>();
	}
	
	/*public Scoop(BufferedReader in) throws IOException{
	}
	
	public void save(BufferedWriter out) throws IOException{
	}*/
	
	
	public void addMixIn(MixIn mixin){
		mixins.add(mixin);
	}
	
	@Override
	public String toString(){
		String scoop = flavor + " ";

		if (mixins.isEmpty()){
			return scoop;
		}
		
		scoop = scoop + "with ";
		
		for (int i = 0; i < mixins.size(); i++){
			if (i > 0) {
				scoop = scoop + ", ";
			}
			scoop = scoop + mixins.get(i);
		}
		
		return scoop;
	}
}
