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
	private ArrayList<MixIn> mixins = new ArrayList<>();
	
	public Scoop(IceCreamFlavor flavor){
		this.flavor = flavor;
		this.mixins.clear();
	}
	
	public Scoop(BufferedReader in) throws IOException{
		flavor = new IceCreamFlavor(in);
		int count = Integer.parseInt(in.readLine());
		for (int i = 0; i < count; i++){
			MixIn mix = new MixIn(in);		
			mixins.add(i, mix);
		}
	}
	
	public void save(BufferedWriter out) throws IOException{
		flavor.save(out);
		int count = mixins.size();
		out.write(count + "\n");
		for (int i = 0; i < count; i++){
			mixins.get(i).save(out);
		}
	}
	
	
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
